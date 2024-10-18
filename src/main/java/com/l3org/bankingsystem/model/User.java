package com.l3org.bankingsystem.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "userType", discriminatorType = DiscriminatorType.STRING)
@Table(name = "user")
public abstract class User {

	@Id
	@Column(name = "userId")
	private String userId;

	@Column(name = "userName", nullable = false, length = 50)
	private String userName;

	@Embedded
	private PersonalInformation personalInformation;

	@Column(name = "dateOfCreation", nullable = false)
	private Date dateOfCreation;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name="admin_code",nullable=true)
	private String adminCode;

	public User() {
	}

	public User(String userId, String userName, String mailId, String password, String mobileNumber, Date dateOfBirth,Date dateOfCreation, String status) {
		this.userId = userId;
		this.userName = userName;
		this.personalInformation = new PersonalInformation(mailId,password,mobileNumber,dateOfBirth);
		this.dateOfCreation = dateOfCreation;
		this.status = status;
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

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	@Embeddable
	public static class PersonalInformation {
		@Column(name = "mailId", nullable = false, unique = true)
		private String mailId;

		@Column(name = "password", nullable = false)
		private String password;

		@Column(name = "mobileNumber", nullable = false , unique = true)
		private String mobileNumber;

		@Column(name = "dateOfBirth", nullable = false)
		private Date dateOfBirth;

		public PersonalInformation() {
		}

		public PersonalInformation(String mailId, String password, String mobileNumber, Date dateOfBirth) {
			this.mailId = mailId;
			this.password = password;
			this.mobileNumber = mobileNumber;
			this.dateOfBirth = dateOfBirth;
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

		@Override
		public String toString() {
			return "PersonalInformation{" +
					"mailId='" + mailId + '\'' +
					", password='" + password + '\'' +
					", mobileNumber='" + mobileNumber + '\'' +
					", dateOfBirth=" + dateOfBirth +
					'}';
		}
	}

	@Override
	public String toString() {
		return "User{" +
				"userId='" + userId + '\'' +
				", userName='" + userName + '\'' +
				", personalInformation=" + personalInformation +
				", dateOfCreation=" + dateOfCreation +
				", status='" + status + '\'' +
				", adminCode='" + adminCode + '\'' +
				'}';
	}
}
