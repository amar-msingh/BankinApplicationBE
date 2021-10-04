package com.obs.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.obs.pojo.Account;
import com.obs.pojo.Customer;
@Component
public class SendMailServiceImpl implements SendMailService{

	@Autowired
	private MailSender mailSender;

	
	
	@Override
	public boolean sendotpemail(Customer customer,String otp) {
		
		 SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("DBSA4794@outlook.com");
		 message.setTo(customer.getEmailID());
		message.setSubject("This is your DBSA BANK OTP Mail");
		message.setText("This is your DBSA Bank OTP :"+otp);
		
		mailSender.send(message);
		return true;
	}



	@Override
	public boolean sendIDemail(String email,int accno){
		
		
		
		System.out.println(email);
		 SimpleMailMessage message=new SimpleMailMessage();
		    message.setFrom("DBSA4794@OUTLOOK.COM");
			message.setTo(email);
			message.setSubject("This is your DBSA BANK Account Number Mail ");
			message.setText("This is your account number  :   "+accno +" /n Thank you for banking with us.");
			System.out.println("Done till here");
			mailSender.send(message);
			return true;
	}



	@Override
	public boolean sendAccountDetail(Account account, int accno,String email) {
		SimpleMailMessage message=new SimpleMailMessage();
	    message.setFrom("DBSA4794@OUTLOOK.COM");
	    message.setTo(email);
	    message.setSubject("Your account has been approved please refer below informations for further use");
	    message.setText("\n Customer Number : "+accno+" \n Customer Id : "+account.getAccId()+"\n Login Password :  "+account.getPass()+"\n Transaction Password : "+account.getTxPass());
	    mailSender.send(message);
	    return true;
	}
	
	
	
	

}
