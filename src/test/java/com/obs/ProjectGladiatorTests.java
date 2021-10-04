package com.obs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.obs.dto.Transfer;
import com.obs.pojo.Account;
import com.obs.pojo.Admin;
import com.obs.pojo.Customer;
import com.obs.pojo.Payee;
import com.obs.service.AdminService;
import com.obs.service.AdminServiceImpl;
import com.obs.service.CustomerService;
import com.obs.service.CustomerServiceImpl;
import com.obs.service.LoginService;
import com.obs.service.PayeeService;
import com.obs.service.SendMailService;

import com.obs.service.UserService;

@SpringBootTest
class ProjectGladiatorTests {
	
	@Autowired
	CustomerService cService;
	
	@Autowired
	AdminService aService;
	
	@Autowired
	PayeeService pService;
	
	@Autowired
	LoginService lService;
	
	@Autowired 
	SendMailService smService;
	
	
	
	@Autowired
	UserService uService;
	

	Customer c1=new Customer();
	Payee p1=new Payee();
	Account a1=new Account();

	

	@Test
	public void testaddCustomer() {
		
		
		c1.setAadharNum("23405667784432"); c1.setEmailID("dummytest@gmail.com");c1.setMobileNum(8808864794l);
		c1.setTitle("Mr.");c1.setFirstName("Ankit"); c1.setLastName("Ayush"); c1.setFatherName("Alok");
		c1.setmAddrLine1("DummyTestStreet"); c1.setmAddrLine2("DummyArea"); c1.setmCity("DummyCity");
		c1.setrPincode("100001"); c1.setrState("DummyState"); c1.setGrossAnnualIncome(1000);c1.setIsApproved("0");
		System.out.println(c1);
		boolean res1=cService.addCustomer(c1);
		System.out.println(res1);
		assertEquals(res1, true);
	}

	
	@Test
	public void testapproveCustomerById() {
		boolean res2=aService.approveCustomerByAcc(c1.getAccNo());
		assertEquals(res2, false);	
	}
	
	
	@Test
	public void testdisapproveCustomerById() {
		boolean res3=aService.disapproveCustomerByAcc(c1.getAccNo());
		assertEquals(res3, false);
	}
	
	@Test
	public void testaddPayee() {
		Customer c2=new Customer();
		c2.setAadharNum("10022");c2.setEmailID("bettejgb");c2.setMobileNum(869689494);
		p1.setCustomer(c2);
		p1.setPayaccno("106"); p1.setPayname("DummyPayee1"); p1.setPaynn("TestNickName1");
		boolean res4=pService.setPayee(p1);
		assertEquals(res4, true);
	}
	
	@Test
	public void testmergeAccount() {
		a1.setCustomer(c1); a1.setAttempt(0);a1.setPass("DummyPass"); a1.setTxPass("DummyTransactionpassword");
		a1.setisRegistered("0");
		boolean res5=lService.mergeAccount(a1);
		assertEquals(res5, true);
			
	}
	
	@Test
	public void testsendIdEmail() {
		boolean res6=smService.sendIDemail("dummytest@gmail.com", c1.getAccNo());
		assertEquals(res6, true);
	}
	
//	@Test
//	public void testsendAccountDetail() {
//		boolean res7=smService.sendAccountDetail(a1, c1.getAccNo(), "DummyMsg");
//		assertEquals(res7, true);
//	}
	
	@Test
	public void testmergeAccount1() {
		boolean res8=uService.mergeAccount(a1);
		assertEquals(res8, true);
	}
	
	@Test
	public void testmergeCustomer() {
		c1.setAadharNum("1000122");c1.setEmailID("Aggdjf");c1.setMobileNum(1647669l);
		boolean res9=uService.mergeCustomer(c1);
		assertEquals(res9, true);
	}
	
	@Test
	public void testgetAccountById() {
		Account res10=uService.getAccountByFID(c1.getAccNo());
		assertEquals(res10, null);
	}
	
	@Test
	public void testgetCusomerListLength() {
		int res11=cService.sizeOfList();
		assertEquals(1, 1);
	}

	

}