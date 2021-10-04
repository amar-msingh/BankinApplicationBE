package com.obs.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obs.dto.DefaultPassword;
import com.obs.pojo.Account;
import com.obs.pojo.Admin;
import com.obs.pojo.Customer;
import com.obs.service.SendMailService;
@Repository
public class AdminRepoImpl implements AdminRepo{
	@Autowired
	EntityManager eMan;
	@Autowired
	SendMailService smsser;
	@Override
	public Admin findById(int num) {
		return eMan.find(Admin.class, num);
	}

	@Override
	public boolean approveCustomerByAcc(int accNo) {
		Customer obj=eMan.find(Customer.class,accNo);
		if(obj==null)
		{
			return false;
		}
		Account aobj=new Account();
		String email=obj.getEmailID();
		obj.setIsApproved("1");
		eMan.merge(obj);
		String userpassword=setPasswordOfAcc();
		 String transactionpassword=setPasswordOfAcc();
		 aobj.setPass(userpassword);
		 aobj.setTxPass(transactionpassword);
		 aobj.setCustomer(obj);
		 eMan.persist(aobj);
		 smsser.sendAccountDetail(aobj,accNo,email);
		 return true;
	}

	@Override
	public String setPasswordOfAcc() {
		DefaultPassword dp=new DefaultPassword();
		String passstr=String.valueOf(dp.set_Password());
		return passstr;
	}

	@Override
	public boolean disapproveCustomerByAcc(int accNo) {
		Customer obj=eMan.find(Customer.class,accNo);
		if(obj==null)
			return false;
		else
			eMan.remove(obj);
		return true;
	}

}
