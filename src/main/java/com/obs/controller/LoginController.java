package com.obs.controller;

import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obs.dto.Login;
import com.obs.dto.Netregister;
import com.obs.pojo.Account;
import com.obs.pojo.Customer;
import com.obs.service.LoginService;
import com.obs.service.LoginServiceImpl;
import com.obs.service.SendMailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
@Autowired
LoginService logser;
@Autowired
SendMailService smsser;

@PostMapping("/login")
public int checkLogin(@RequestBody Login login )
{
	System.out.println("This is the Account Number"+login.getACCNO());
	Account account=logser.getAccountByFId(login.getACCNO());
	if(account==null)
		return 3;
	if(account.getAttempt()>=3)
			return 2;
	if(account.getisRegistered().equals("0"))
		return 4;
	if(account.getPass().equals(login.getPASS()))
	{
		account.setAttempt(0);
		logser.mergeAccount(account);
		return 0;
	}
		else
	{
		account.setAttempt(account.getAttempt()+1);
		logser.mergeAccount(account);
		
		if(account.getAttempt()>=3)
			return 2;
		else
			return 1;
	}
}
@PostMapping("/status")
public int chechkStatus(@RequestBody String mobno)
{
	System.out.println("This is your mob "+mobno);
	Customer customer=logser.findBymobileNum(Long.parseLong(mobno, 10));
	if(customer==null) 
		return 2;
	else if(Integer.parseInt(customer.getIsApproved())==0)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}
@PostMapping("/netregister")
public boolean netregister(@RequestBody Netregister netreg )
{
	Account account=logser.getAccountByFId(netreg.getAccno());
		if(account==null)
		{
			return false;
		}
	if(account.getPass().equals(netreg.getPass())&&account.getTxPass().equals(netreg.getTxnpass()))
			{
			account.setisRegistered("1");
			logser.mergeAccount(account);
			System.out.println(account.getisRegistered());
			return true;
			}
	else
		return false;
}
@PostMapping("/sendotp")
public String sendpass(@RequestBody int accno)
{
	Customer customer=logser.getCustomerById(accno);
	if(customer==null)
	{
		return null;
	}
	Account account=logser.getAccountByFId(accno);
	if(account==null)
		return null;
	Random rand = new Random();
	String id = String.format("%04d", rand.nextInt(10000));
	System.out.println(id);
	smsser.sendotpemail(customer,id);
	return id;
}
@PostMapping("/sendID")
public boolean sendID(@RequestBody String email)
{
	System.out.println("Your email id "+email);
	Customer customer=logser.findByemailid(email);	
	System.out.println("Your customer number is  "+ customer);
	if(customer==null)
	{
		return false;
	}
	Account account=logser.getAccountByFId(customer.getAccNo());
	if(account==null)
		return false;
	smsser.sendIDemail(email,customer.getAccNo());
	return true;
	}

@PostMapping("/setnewpass/{accno}")
public boolean setNewPass(@RequestBody String pass1,@PathVariable(name = "accno") String accno)
{
	
	int acc=Integer.parseInt(accno);
	Account account=logser.getAccountByFId(acc);
	account.setPass(pass1);
	account.setAttempt(0);
	logser.mergeAccount(account);
	return true;
}

}
