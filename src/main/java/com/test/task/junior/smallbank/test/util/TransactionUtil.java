package com.test.task.junior.smallbank.test.util;

import com.test.task.junior.smallbank.entity.Transaction;

public class TransactionUtil {
    public static Transaction createTransaction()   {
        Transaction transaction = new Transaction();
        transaction.setAmount(50);
        return transaction;
    }
}
