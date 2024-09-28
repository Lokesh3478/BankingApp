package com.l3org.bankingsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounttype")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
public class AccountType {

    @Id
    @Column(name = "accountTypeId", nullable = false)
    private int accountTypeId;

    @Column(name = "accountTypeName", length = 50, nullable = false)
    private String accountTypeName;

    @Column(name = "interestRate", nullable = true)
    private double interestRate;

    @Column(name = "minimumBalance", nullable = true)
    private double minimumBalance;

    @Column(name = "overdraftLimit", nullable = true)
    private double overdraftLimit;

    @Column(name = "withdrawalLimit", nullable = true)
    private int withdrawalLimit;

    @Column(name = "depositLimit", nullable = true)
    private double depositLimit;

    @Column(name = "isMinorAccount", nullable = true)
    private boolean isMinorAccount;
}
