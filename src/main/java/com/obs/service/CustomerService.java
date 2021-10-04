package com.obs.service;

import java.util.List;

import com.obs.pojo.Customer;

public interface CustomerService {

	public boolean addCustomer(Customer customer);
	public List<Customer> getCustomers();
	public Customer searchCustomerByAcc(int accNo);
	public int sizeOfList();
}