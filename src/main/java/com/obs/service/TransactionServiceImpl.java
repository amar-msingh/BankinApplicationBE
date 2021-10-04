package com.obs.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obs.dto.Transfer;
import com.obs.pojo.Customer;
import com.obs.pojo.Transaction;
import com.obs.repository.TransactionRepo;
import com.obs.repository.UserRepo;
@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionRepo tr;
	@Autowired
	UserRepo user;
	@Override
	public int setTransaction(Transfer transfer) {
		System.out.println(transfer.getFromaccno());
		System.out.println(transfer.getToaccno());
		Customer customerfrom=user.searchCustomerByAcc(Integer.parseInt(transfer.getFromaccno()));
		Customer customerto=user.searchCustomerByAcc(Integer.parseInt(transfer.getToaccno()));
		if(customerto==null||customerfrom==null)
		{
			return 2;
		}
		int amount = Integer.parseInt(transfer.getAmount());
		if (amount > Integer.parseInt(customerfrom.getBalance()))
			return 1;
		customerfrom.setBalance(Integer.toString(Integer.parseInt(customerfrom.getBalance()) - amount));
		customerto.setBalance(Integer.toString(Integer.parseInt(customerto.getBalance()) + amount));
		user.mergeCustomer(customerto);
		user.mergeCustomer(customerfrom);
		LocalDateTime dateTime = LocalDateTime.now();
		Transaction tr1=new Transaction();
		Transaction tr2=new Transaction();
		System.out.println(customerto);
		tr1.setTxDetails(transfer.getTxndetails());
		tr1.setTxDate(dateTime); 
		tr1.setTxType("Withdrawal");
		tr1.setTxAmount(String.valueOf(transfer.getAmount()));
		tr1.setTxbal(customerfrom.getBalance());
		tr1.setCustomer(customerfrom);
		tr.mergeTransaction(tr1);
		tr2.setTxDetails(transfer.getTxndetails());
		tr2.setTxDate(dateTime);
		tr2.setTxType("Deposit");
		tr2.setTxAmount(String.valueOf(transfer.getAmount()));
		tr2.setTxbal(customerto.getBalance());
		tr2.setCustomer(customerto);
		tr.mergeTransaction(tr2);
		return 0;
	}

}
