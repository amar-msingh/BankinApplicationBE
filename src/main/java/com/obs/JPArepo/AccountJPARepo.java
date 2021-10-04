package com.obs.JPArepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.obs.pojo.Account;
import com.obs.pojo.Customer;

public interface AccountJPARepo extends JpaRepository<Account,Integer>{
	@Query("select a from Account a where a.customer.accNo=:ACCNO")
	public Account findByaccNo(int ACCNO);

}
