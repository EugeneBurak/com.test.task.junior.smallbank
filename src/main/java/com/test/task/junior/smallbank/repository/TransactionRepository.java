package com.test.task.junior.smallbank.repository;

import com.test.task.junior.smallbank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>    {
    @Query("select b from Transaction b where b.transaction_id = :transaction_id")
    Transaction findById(@Param("transaction_id") int id);
}
