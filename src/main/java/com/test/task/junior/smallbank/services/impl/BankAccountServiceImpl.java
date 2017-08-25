package com.test.task.junior.smallbank.services.impl;

import com.test.task.junior.smallbank.entity.BankAccount;
import com.test.task.junior.smallbank.repository.BankAccountRepository;
import com.test.task.junior.smallbank.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount addBankAccount(BankAccount bankAccount) {
        BankAccount savedBankAccount = bankAccountRepository.saveAndFlush(bankAccount);
        return savedBankAccount;
    }

    @Override
    public void deleteBankAccount(int id) {
        bankAccountRepository.delete(id);
    }

    @Override
    public BankAccount getBankAccountById(int id) {
        return bankAccountRepository.findById(id);
    }

    @Override
    public BankAccount editBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.saveAndFlush(bankAccount);
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }
}
