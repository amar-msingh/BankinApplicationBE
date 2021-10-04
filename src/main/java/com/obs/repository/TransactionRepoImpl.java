package com.obs.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obs.pojo.Transaction;

@Repository
public class TransactionRepoImpl implements TransactionRepo{
@Autowired
EntityManager eMan;

@Override
public boolean mergeTransaction(Transaction tran) {
	eMan.persist(tran);
	return true;
}

}
