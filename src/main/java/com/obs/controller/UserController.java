package com.obs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.obs.dto.AccountDetails;
import com.obs.dto.ChangePassword;
import com.obs.dto.DateRange;
import com.obs.pojo.Account;
import com.obs.pojo.Customer;
import com.obs.pojo.Transaction;
import com.obs.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	UserService userser;
	
	@GetMapping("/userdetails/{accno}")//localStorage stored
	public Customer getDetails(@PathVariable(name = "accno") String accno)
	{
		int acc=Integer.parseInt(accno);
		Customer cust=userser.searchCustomerByAcc(acc);
		return cust;
	}
	//----
	@PostMapping("/userdetails/{accno}")
	public boolean mergeCustomer(@RequestBody Customer customer,@PathVariable(name = "accno") String accno)
	{
		System.out.println(accno);
		int acc=Integer.parseInt(accno);
		customer.setAccNo(acc);
		System.out.println(customer);
		userser.mergeCustomer(customer);
		return true;
	}
	
	//----
	@PostMapping("/changepassword/{accno}")
	public boolean changepassword(@RequestBody ChangePassword chngpass,@PathVariable(name = "accno") String accno)
	{
		System.out.println(chngpass.getPass1());
		System.out.println(chngpass.getPass2());
		System.out.println(chngpass.getPass3());
		System.out.println(chngpass.getPass4());
		int acc=Integer.parseInt(accno);
		Account account=userser.getAccountByFID(acc);
		if(account==null)
		{
			return false;
		}
		if(chngpass.getPass1().equals(chngpass.getPass2())==false)
		{
			return false;
		}
		if(chngpass.getPass3().equals(chngpass.getPass4())==false)
		{
			return false;
		}
	
		
		account.setPass(chngpass.getPass1());
		account.setTxPass(chngpass.getPass3());
		userser.mergeAccount(account);
		return true;
	}
	@GetMapping("/accountdetails/{accno}")
	public AccountDetails getAccountDetails(@PathVariable(name = "accno") String accno)
	{
		int acc=Integer.parseInt(accno);
		
		Account account=userser.getAccountByFID(acc);
		Customer customer=userser.searchCustomerByAcc(acc);
		AccountDetails acd=new AccountDetails();
		acd.setAccno(customer.getAccNo());
		acd.setAccid(account.getAccId());
		acd.setBalance(customer.getBalance());
		acd.setDob(customer.getDob());
		acd.setEmail(customer.getEmailID());
		acd.setFname(customer.getFirstName());
		acd.setLname(customer.getLastName());
		acd.setMobnum(customer.getMobileNum());
		return acd;
	}
	@GetMapping("/getTransaction/{accno}")
	public List<Transaction> getTransactionDetails(@PathVariable(name = "accno") String accno)
	{
		int acc=Integer.parseInt(accno);
		return userser.getAllTransaction(acc);
		
	}
	
	@PostMapping("/getTransactiononit/{accno}")
	public List<Transaction> getTransactionDetailsByDate(@RequestBody DateRange dr,@PathVariable(name = "accno") String accno)
	{
		System.out.println("Inside the spring Boot");
		int acc=Integer.parseInt(accno);
		System.out.println(accno);
		System.out.println(dr.getDate1());
		return userser.getTransactionbyDate(dr, acc);
	}
	@PostMapping("/deposit/{accno}")
	public boolean depositMoney(@RequestBody long num,@PathVariable(name = "accno") int accno)
	{
		
		Customer customer=userser.searchCustomerByAcc(accno);
		if(customer==null)
			return false;
		long l=Long.parseLong(customer.getBalance());
		l=l+num;
		customer.setBalance(String.valueOf(l));
		userser.mergeCustomer(customer);
		return true;
	}
}
