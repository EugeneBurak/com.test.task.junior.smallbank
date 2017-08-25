package com.test.task.junior.smallbank.repository;

import com.test.task.junior.smallbank.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
    @Query("select b from Bank_account b where b.account_id = :account_id")
    BankAccount findById(@Param("account_id") int id);
}
