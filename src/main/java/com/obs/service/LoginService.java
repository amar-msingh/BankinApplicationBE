package com.obs.service;

import java.util.List;

import com.obs.dto.Login;
import com.obs.pojo.Account;
import com.obs.pojo.Customer;

public interface LoginService {
public  Account getAccountByFId(int accno);
public Customer getCustomerById(int ACCNO);
public Customer findBymobileNum(long mobno);
public Customer findByemailid(String email);
public boolean mergeAccount(Account account);
}
