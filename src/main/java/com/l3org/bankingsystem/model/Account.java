
package com.l3org.bankingsystem.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "accountNo")
    private long accountNo; // assigned manually

    @ManyToOne
    @JoinColumn(name = "accountTypeId", nullable = false)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Embedded
    private AccountInformation accountInformation;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Transactions> sentTransactions;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Transactions> receivedTransactions;

    @Column(name = "balance", nullable = false)
    private double balance;

    @Column(name = "dateOfCreation", nullable = false)
    private Date dateOfCreation;

    public Account() {
    }

	public Account(long accountNo, AccountType accountType, User user, AccountInformation accountInformation,
			List<Transactions> sentTransactions, List<Transactions> receivedTransactions, double balance,
			Date dateOfCreation) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.user = user;
		this.accountInformation = accountInformation;
		this.sentTransactions = sentTransactions;
		this.receivedTransactions = receivedTransactions;
		this.balance = balance;
		this.dateOfCreation = dateOfCreation;
	}
	public long getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public AccountInformation getAccountInformation() {
		return accountInformation;
	}

	public void setAccountInformation(AccountInformation accountInformation) {
		this.accountInformation = accountInformation;
	}


	public List<Transactions> getSentTransactions() {
		return sentTransactions;
	}

	public void setSentTransactions(List<Transactions> sentTransactions) {
		this.sentTransactions = sentTransactions;
	}

	public List<Transactions> getReceivedTransactions() {
		return receivedTransactions;
	}

	public void setReceivedTransactions(List<Transactions> receivedTransactions) {
		this.receivedTransactions = receivedTransactions;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}



	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	@Embeddable
    public static class AccountInformation {
        @Column(name = "aadharNumber", nullable = false)
        private String aadharNumber;

        @Column(name = "mobileNumber", nullable = false)
        private String mobileNumber;

        @ManyToOne
        @JoinColumn(name = "branchIfsc", nullable = false)
        private Branch branch;

        public AccountInformation() {
        }

		public AccountInformation(String aadharNumber, String mobileNumber, Branch branch) {
			super();
			this.aadharNumber = aadharNumber;
			this.mobileNumber = mobileNumber;
			this.branch = branch;
		}

		public String getAadharNumber() {
			return aadharNumber;
		}

		public void setAadharNumber(String aadharNumber) {
			this.aadharNumber = aadharNumber;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public Branch getBranch() {
			return branch;
		}

		public void setBranch(Branch branch) {
			this.branch = branch;
		}
        

    }
}
