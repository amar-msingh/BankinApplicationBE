package com.obs.repository;

import com.obs.pojo.Transaction;

public interface TransactionRepo {
public boolean mergeTransaction(Transaction tran);
}
