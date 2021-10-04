package com.obs.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obs.pojo.Payee;
@Repository
public class PayeeRepoImpl implements PayeeRepo {
	@Autowired
	EntityManager eMan;
	@Override
	public boolean setPayee(Payee payee) {
		eMan.persist(payee);
		return true;
	}

	@Override
	public List<Payee> getPayeeList(int accno) {
		String query  = "Select p from Payee p where p.customer.accNo=:accNo";
		Query q = eMan.createQuery(query);
		q.setParameter("accNo",accno);
		return (List<Payee>) q.getResultList();
	}

}
