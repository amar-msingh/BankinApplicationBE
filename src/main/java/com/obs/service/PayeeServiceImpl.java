package com.obs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obs.pojo.Payee;
import com.obs.repository.PayeeRepo;

@Service
@Transactional
public class PayeeServiceImpl implements PayeeService{
	@Autowired
	PayeeRepo pyrepo;
	@Override
	public boolean setPayee(Payee payee) {
		pyrepo.setPayee(payee);
		return true;
	}

	@Override
	public List<Payee> getPayeeList(int accno) {
		return pyrepo.getPayeeList(accno);
	}

}
