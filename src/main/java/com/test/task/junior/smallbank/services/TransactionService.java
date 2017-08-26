package com.test.task.junior.smallbank.services;

import com.test.task.junior.smallbank.entity.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionService {
    Transaction addTransaction(Transaction transaction);
    void deleteTransaction(int id);
    Transaction getTransactionById(int id);
    Transaction getTransactionByTime(Date time);
    Transaction editTransaction (Transaction transaction);
    List<Transaction> getAllTransactions();

}
