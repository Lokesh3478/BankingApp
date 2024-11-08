
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
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    @Embedded
    private AccountInformation accountInformation;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transactions> sentTransactions;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Transactions> receivedTransactions;

    @Column(name = "balance", nullable = false)
    private double balance;

    @Column(name = "dateOfCreation", nullable = false)
    private Date dateOfCreation;
    public Account() {
    }
	public Account(long accountNo, AccountType accountType, User user, String aadharNumber, String mobileNumber, Branch branch,
				   List<Transactions> sentTransactions, List<Transactions> receivedTransactions, double balance,
				   Date dateOfCreation, String mpin) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.user = user;
		this.accountInformation = new AccountInformation(aadharNumber, mobileNumber, branch,mpin);
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

	@Override
	public String toString() {
		return "Account{" +
				"accountNo=" + accountNo +
				", accountType=" + (accountType != null ? accountType : "N/A") +
				", userId=" + (user != null ? user.getUserId(): "N/A") + // Assuming user has getId() method
				", balance=" + balance +
				", dateOfCreation=" + dateOfCreation +
				'}';
	}


	@Embeddable
    public static class AccountInformation {
        @Column(name = "aadhaarNumber", nullable = false,unique = true)
        private String aadhaarNumber;

        @Column(name = "mobileNumber", nullable = false,unique = true)
        private String mobileNumber;

        @ManyToOne
        @JoinColumn(name = "branchIfsc", nullable = false)
        private Branch branch;

		@Column(name = "mpin")
		private String mpin;


        public AccountInformation() {
        }

		public AccountInformation(String aadhaarNumber, String mobileNumber, Branch branch, String mpin) {
			super();
			this.aadhaarNumber = aadhaarNumber;
			this.mobileNumber = mobileNumber;
			this.branch = branch;
			this.mpin = mpin;
		}

		public String getAadhaarNumber() {
			return aadhaarNumber;
		}

		public void setAadhaarNumber(String aadharNumber) {
			this.aadhaarNumber = aadharNumber;
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

		public String getMpin() {
			return mpin;
		}

		public void setMpin(String mpin) {
			this.mpin = mpin;
		}

		@Override
		public String toString() {
			return "AccountInformation{" +
					"aadhaarNumber='" + aadhaarNumber + '\'' +
					", mobileNumber='" + mobileNumber + '\'' +
					", branch=" + branch +
					", mpin=" + mpin +
					'}';
		}
	}
}
