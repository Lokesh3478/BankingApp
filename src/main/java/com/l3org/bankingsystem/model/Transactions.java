package com.l3org.bankingsystem.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transactions {

    @Id
    @Column(name = "transactionId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transactionId;
    
    

    @ManyToOne
    @JoinColumn(name = "senderAccountNo", nullable = false)
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "receiverAccountNo", nullable = false)
    private Account receiver;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "transactionType", nullable = false)
    private String transactionType;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "status", nullable = false)
    private boolean status;

    public Transactions() {
    }

	public Transactions(long transactionId, Account sender, Account receiver, double amount, String transactionType,
			Date date, boolean status) {
		super();
		this.transactionId = transactionId;
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
		this.transactionType = transactionType;
		this.date = date;
		this.status = status;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public Account getSender() {
		return sender;
	}

	public void setSender(Account sender) {
		this.sender = sender;
	}

	public Account getReceiver() {
		return receiver;
	}

	public void setReceiver(Account receiver) {
		this.receiver = receiver;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
    
}
