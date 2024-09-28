package com.l3org.bankingsystem.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "userId")
    private String userId;

    @Column(name = "userName", nullable = false, length = 50)
    private String userName;

    @Embedded
    private PersonalInformation personalInformation;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Account> accountList;

    public User() {
    }

    public User(String userId, String userName, String mailId, String password, String mobileNumber, Date dateOfBirth, Date dateOfCreation, String status, List<Account> accountList) {
        this.userId = userId;
        this.userName = userName;
        this.personalInformation = new PersonalInformation(mailId, password, mobileNumber, dateOfBirth, dateOfCreation, status);
        this.accountList = accountList;
    }
    
    

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public PersonalInformation getPersonalInformation() {
		return personalInformation;
	}

	public void setPersonalInformation(PersonalInformation personalInformation) {
		this.personalInformation = personalInformation;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}


	@Embeddable
	public static class PersonalInformation {
        @Column(name = "mailId", nullable = false)
        private String mailId;

        @Column(name = "password", nullable = false)
        private String password;

        @Column(name = "mobileNumber", nullable = false)
        private String mobileNumber;

        @Column(name = "dateOfBirth", nullable = false)
        private Date dateOfBirth;

        @Column(name = "dateOfCreation", nullable = false)
        private Date dateOfCreation;

        @Column(name = "status", nullable = false)
        private String status;

        public PersonalInformation() {
        }

        public PersonalInformation(String mailId, String password, String mobileNumber, Date dateOfBirth, Date dateOfCreation, String status) {
            this.mailId = mailId;
            this.password = password;
            this.mobileNumber = mobileNumber;
            this.dateOfBirth = dateOfBirth;
            this.dateOfCreation = dateOfCreation;
            this.status = status;
        }

		public String getMailId() {
			return mailId;
		}

		public void setMailId(String mailId) {
			this.mailId = mailId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public Date getDateOfCreation() {
			return dateOfCreation;
		}

		public void setDateOfCreation(Date dateOfCreation) {
			this.dateOfCreation = dateOfCreation;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
        
    }
}
