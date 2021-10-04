package com.obs.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obs.dto.Login;
import com.obs.pojo.Account;
import com.obs.pojo.Customer;

@Repository
public class AccountRepoImpl implements AccountRepo {
	@Autowired
	EntityManager eMan;
	@Override
	public Account getAccountById(int ACCID) {
		Account acc=eMan.find(Account.class, ACCID);
		return acc;
	}
	
	@Override
	public Customer getCustomerById(int ACCNO) {
		return eMan.find(Customer.class, ACCNO);
	}
	@Override
	public Customer getCustomerBymobNo(long mobNo) {
			System.out.println("This is your mobile  service "+ mobNo);
			Customer cust=null;	
			try {
			cust=(Customer)eMan.createQuery("select c from Customer c where c.mobileNum=:mobno").setParameter("mobno", mobNo).getSingleResult();
				}
			catch(Exception e){
				System.out.println("No Account Present");
			}
			return cust;

	}

	@Override
	public boolean mergeAccount(Account account) {
	 eMan.persist(account);
	 return true;
	}

	
	
	



}
