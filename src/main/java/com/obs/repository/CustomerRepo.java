package com.obs.repository;

import java.util.List;

import com.obs.pojo.Customer;

public interface CustomerRepo {

	public boolean addCustomer(Customer customer);
	public List<Customer> getCustomers();
	public Customer searchCustomerByAcc(int accNo);
}