package com.obs.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.obs.dto.DateRange;
import com.obs.pojo.Account;
import com.obs.pojo.Customer;
import com.obs.pojo.Transaction;

@Repository
public class UserRepoImpl implements UserRepo {
@Autowired
EntityManager eMan;

@Override
public Customer searchCustomerByAcc(int accNo) {
	Customer obj=eMan.find(Customer.class, accNo);
	System.out.println(obj);
	return obj;
}

@Override
public boolean mergeCustomer(Customer customer) {
	eMan.merge(customer);
	return true;
}

@Override
public boolean mergeAccount(Account account) {
	eMan.merge(account);
	return true;
}

@Override
public Account getAccountByFID(int accno) {
	Account account=null;
	try
	{
		account=(Account) eMan.createQuery("select a from Account a where a.customer.accNo=:ACCNO").setParameter("ACCNO", accno).getSingleResult();
	}
	catch(Exception e)
	{
		System.out.println("Account not found");
	}
	return account;
}

@SuppressWarnings("unchecked")
@Override
public List<Transaction> getAllTransaction(int accno) {
	String query  = "Select tx from Transaction tx where tx.customer.accNo=:accNo order by tx.txDate desc";
	Query q = eMan.createQuery(query);
	q.setParameter("accNo", accno);
	return (List<Transaction>) q.getResultList();
}

@Override
public List<Transaction> getTransactionbyDate(DateRange date, int accno) {
	System.out.println("Inside range Repo");
	String query  = "Select tx from Transaction tx where tx.customer.accNo=:accNo and tx.txDate between :date1 and :date2 order by tx.txDate desc";
	Query q = eMan.createQuery(query);
	
	System.out.println(date.getDate1().atStartOfDay());
	/*
	Timestamp timestamp1 = Timestamp.valueOf(date.getDate1().atStartOfDay());
	Timestamp timestamp2 = Timestamp.valueOf(date.getDate2().atStartOfDay());
		
	System.out.println(timestamp1.toString());
	*/
	LocalDateTime l1=date.getDate1().atStartOfDay();
	LocalDateTime l2=date.getDate2().atStartOfDay();
	q.setParameter("accNo",accno);
	q.setParameter("date1",l1);
	q.setParameter("date2",l2);
	return (List<Transaction>) q.getResultList();
}
}
