package com.obs.service;

import java.util.List;

import com.obs.dto.DateRange;
import com.obs.pojo.Account;
import com.obs.pojo.Customer;
import com.obs.pojo.Transaction;

public interface UserService {
	public Customer searchCustomerByAcc(int accNo);
	public boolean mergeCustomer(Customer customer);
	public boolean mergeAccount(Account account);
	public Account getAccountByFID(int accno);
	public List<Transaction> getAllTransaction(int accno);
	public List<Transaction> getTransactionbyDate(DateRange date,int accno);
}
