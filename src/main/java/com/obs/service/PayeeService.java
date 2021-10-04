package com.obs.service;

import java.util.List;

import com.obs.pojo.Payee;

public interface PayeeService {
	public boolean setPayee(Payee payee);
	public List<Payee> getPayeeList(int accno);
}
