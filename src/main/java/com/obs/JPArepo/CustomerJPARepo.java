package com.obs.JPArepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.obs.pojo.Customer;

public interface CustomerJPARepo extends JpaRepository<Customer,String> {
	
	@Query("select c from Customer c where c.emailID LIKE %:email%")
	public Customer findByemailID(String email);
}
