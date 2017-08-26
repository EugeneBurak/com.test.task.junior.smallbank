package com.test.task.junior.smallbank.services.impl;

import com.test.task.junior.smallbank.entity.Transaction;
import com.test.task.junior.smallbank.repository.TransactionRepository;
import com.test.task.junior.smallbank.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        Transaction savedTransaction = transactionRepository.saveAndFlush(transaction);
        return savedTransaction;
    }

    @Override
    public void deleteTransaction(int id) {
        transactionRepository.delete(id);
    }

    @Override
    public Transaction getTransactionById(int id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction getTransactionByTime(Date time) {
        return transactionRepository.findByTime(time);
    }

    @Override
    public Transaction editTransaction(Transaction transaction) {
        return transactionRepository.saveAndFlush(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
