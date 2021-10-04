package com.obs.repository;

import java.util.List;

import com.obs.pojo.Payee;

public interface PayeeRepo {
public boolean setPayee(Payee payee);
public List<Payee> getPayeeList(int accno);
}
