package com.obs.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obs.pojo.Customer;
import com.obs.repository.CustomerRepo;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepo cRepo;

	@Override
	public boolean addCustomer(Customer customer) {
		
		return cRepo.addCustomer(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		
		return cRepo.getCustomers();
	}

	@Override
	public Customer searchCustomerByAcc(int accNo) {
	
		return cRepo.searchCustomerByAcc(accNo);
	}

	@Override
	public int sizeOfList() {

		List<Customer> customerList = new ArrayList<Customer>();  
		return customerList.size();
	}

}