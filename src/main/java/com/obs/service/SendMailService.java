package com.obs.service;

import javax.mail.MessagingException;

import com.obs.pojo.Account;
import com.obs.pojo.Customer;

public interface SendMailService {
public boolean sendotpemail(Customer customer,String otp);
public boolean sendIDemail(String email,int accno);
public boolean sendAccountDetail(Account account,int accno,String email);
}
