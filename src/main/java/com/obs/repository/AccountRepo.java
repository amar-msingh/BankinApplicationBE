package com.obs.repository;

import java.util.List;

import com.obs.dto.Login;
import com.obs.pojo.Account;
import com.obs.pojo.Customer;

public interface AccountRepo {
 public Account getAccountById(int ACCID);
 public Customer getCustomerById(int ACCNO);
public Customer getCustomerBymobNo(long mobNo);
public boolean mergeAccount(Account account);
 
}
