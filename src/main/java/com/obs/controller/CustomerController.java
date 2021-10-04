package com.obs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.obs.pojo.Customer;
import com.obs.service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CustomerController {

	
	@Autowired
	CustomerService cService;
	
	@PostMapping("/customer")
	public boolean addCustomer(@RequestBody Customer customer){
		return cService.addCustomer(customer);
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return cService.getCustomers();
	}
	
	
	
}