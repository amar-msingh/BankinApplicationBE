package com.obs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obs.pojo.Admin;
import com.obs.repository.AdminRepo;


public interface AdminService {
	public Admin findAdminByID(int num);
	public boolean approveCustomerByAcc(int accNo);
	
	public boolean disapproveCustomerByAcc(int accNo);
	
	
}
