package com.obs.repository;

import com.obs.pojo.Admin;

public interface AdminRepo {
	public Admin findById(int num);
	public boolean approveCustomerByAcc(int accNo);
	public String setPasswordOfAcc();
	public boolean disapproveCustomerByAcc(int accNo);
}
