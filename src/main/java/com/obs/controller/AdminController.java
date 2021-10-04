package com.obs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.obs.pojo.Admin;
import com.obs.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	AdminService aService;
	
	@PutMapping("/approvecustomers/{accNo}")
	public boolean approveCustomerByAcc(@PathVariable(name = "accNo") int accNo) {
		System.out.println(accNo);
		return aService.approveCustomerByAcc(accNo);
	}
	
	@DeleteMapping("/disapprovecustomers/{accNo}")
	public boolean disapproveCustomerByAcc(@PathVariable(name = "accNo") int accNo) {
		System.out.println(accNo);
		return aService.disapproveCustomerByAcc(accNo);
	}
	
	@PostMapping("/adminlogin")
	public int loginAdmin(@RequestBody Admin admin)
	{
		
		Admin ad=aService.findAdminByID(admin.getId());
		if(ad==null)
		{
			return 2;
		}
		if(ad.getPass().equals(admin.getPass()))
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}

}
