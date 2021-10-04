package com.obs.JPArepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obs.pojo.Account;

public interface MYJPARepo extends JpaRepository<Account, String> {

}
