package com.obs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obs.JPArepo.AccountJPARepo;
import com.obs.JPArepo.CustomerJPARepo;
import com.obs.dto.Login;
import com.obs.pojo.Account;
import com.obs.pojo.Customer;
import com.obs.repository.AccountRepo;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	AccountJPARepo accjrepo;
	
	@Autowired
	AccountRepo accrepo;
	
	@Autowired
	CustomerJPARepo cusjrepo;
	@Override
	public Account getAccountByFId(int accno)
	{
		return accjrepo.findByaccNo(accno);
	}
	@Override
	public Customer getCustomerById(int accno)
	{
		return accrepo.getCustomerById(accno);
	}
	@Override
	public Customer findBymobileNum(long mobno) {
		return accrepo.getCustomerBymobNo(mobno);
	}
	@Override
	public Customer findByemailid(String email) {
		
		return cusjrepo.findByemailID(email);
	}
	@Override
	public boolean mergeAccount(Account account) {
		accrepo.mergeAccount(account);
		return true;
	}
	
}
