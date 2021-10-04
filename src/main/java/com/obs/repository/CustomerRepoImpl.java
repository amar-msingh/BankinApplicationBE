package com.obs.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.obs.pojo.Customer;

@Service
@Transactional

public class CustomerRepoImpl implements CustomerRepo {
	
	@Autowired
	EntityManager eMan;

	@Override
	public boolean addCustomer(Customer customer) {
		eMan.persist(customer);
		return true;
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customerlist=eMan.createQuery("from Customer").getResultList();
		return customerlist;
	}

	@Override
	public Customer searchCustomerByAcc(int accNo) {
		Customer obj=eMan.find(Customer.class, accNo);
		return obj;
		
	}
	
	
	

}