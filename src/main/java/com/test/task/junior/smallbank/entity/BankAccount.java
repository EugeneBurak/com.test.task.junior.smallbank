package com.test.task.junior.smallbank.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "Bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "account_id", length = 6, nullable = false)
    private int id;

    @Column(name = "client_id")
    private int clientId;

    @Column(name = "amount")
    private double amount;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})          //
//    @JoinColumn(name = "from_account_id", nullable = false)
////    @JoinColumn(name = "to_account_id", nullable = false)
//    private Transaction transaction;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})          //
    @JoinColumn(name = "from_account_id", nullable = false)
    private Transaction transactionFrom;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})          //
    @JoinColumn(name = "to_account_id", nullable = false)
    private Transaction transactionTo;


    public BankAccount() {
    }

    public BankAccount(int clientId, double amount, Transaction transactionFrom, Transaction transactionTo) {
        this.clientId = clientId;
        this.amount = amount;
        this.transactionFrom = transactionFrom;
        this.transactionTo = transactionTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Transaction getTransactionFrom() {
        return transactionFrom;
    }

    public void setTransactionFrom(Transaction transactionFrom) {
        this.transactionFrom = transactionFrom;
    }

    public Transaction getTransactionTo() {
        return transactionTo;
    }

    public void setTransactionTo(Transaction transactionTo) {
        this.transactionTo = transactionTo;
    }

}
