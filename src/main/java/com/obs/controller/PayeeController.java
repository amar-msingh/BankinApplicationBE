package com.obs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.obs.pojo.Customer;
import com.obs.pojo.Payee;
import com.obs.service.CustomerService;
import com.obs.service.PayeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PayeeController {
	@Autowired
	PayeeService pyser;
	@Autowired
	CustomerService cusser;
	
	@PostMapping("/addPayee/{accno}")
	public boolean addPayee(@RequestBody Payee payee,@PathVariable(name = "accno") String accno)
	{
		int acc=Integer.parseInt(accno);
		int accnopayee=Integer.parseInt(payee.getPayaccno());
		Customer customer1=cusser.searchCustomerByAcc(accnopayee);
		if(customer1==null)
		{
			return false;
		}
		Customer customer=cusser.searchCustomerByAcc(acc);
		
		payee.setCustomer(customer);
		pyser.setPayee(payee);
		return true;
	}
	@GetMapping("/getPayee/{accno}")
	public List<Payee> getPayee(@PathVariable(name = "accno") String accno)
	{
		System.out.println(accno);
		int acc=Integer.parseInt(accno);
		return pyser.getPayeeList(acc);
	}

}
