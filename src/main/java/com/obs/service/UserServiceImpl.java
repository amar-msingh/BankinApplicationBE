package com.obs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obs.dto.DateRange;
import com.obs.pojo.Account;
import com.obs.pojo.Customer;
import com.obs.pojo.Transaction;
import com.obs.repository.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepo usrepo;
	@Override
	public Customer searchCustomerByAcc(int accNo) {
		
		return usrepo.searchCustomerByAcc(accNo);
	}

	@Override
	public boolean mergeCustomer(Customer customer) {
		usrepo.mergeCustomer(customer);
		return true;
	}

	@Override
	public boolean mergeAccount(Account account) {
		usrepo.mergeAccount(account);
		return true;
	}

	@Override
	public Account getAccountByFID(int accno) {
	return	usrepo.getAccountByFID(accno);
		
	}

	@Override
	public List<Transaction> getAllTransaction(int accno) {
		return usrepo.getAllTransaction(accno);
	}

	@Override
	public List<Transaction> getTransactionbyDate(DateRange date, int accno) {
		return usrepo.getTransactionbyDate(date, accno);
	}

}
