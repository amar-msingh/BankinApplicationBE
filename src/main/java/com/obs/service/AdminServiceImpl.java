package com.obs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obs.pojo.Admin;
import com.obs.repository.AdminRepo;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
@Autowired
AdminRepo adrepo;

@Override
public Admin findAdminByID(int num) {
	return adrepo.findById(num);
}

@Override
public boolean approveCustomerByAcc(int accNo) {
	return adrepo.approveCustomerByAcc(accNo);
}

@Override
public boolean disapproveCustomerByAcc(int accNo) {
	return adrepo.disapproveCustomerByAcc(accNo);
}
}
