package com.l3org.bankingsystem.service;

import java.util.ArrayList;
import java.util.Date;

import com.l3org.bankingsystem.model.AdminUser;
import com.l3org.bankingsystem.model.CustomerUser;
import com.l3org.bankingsystem.repository.AdminUserRepository;
import com.l3org.bankingsystem.repository.CustomerUserRepository;
import com.l3org.bankingsystem.service.exceptions.FieldValueNotFoundException;
import com.l3org.bankingsystem.service.exceptions.InvalidPassWordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	private CustomerUserRepository customerUserRepository;
    @Autowired
    private AdminUserRepository adminUserRepository;

	public LoginService(CustomerUserRepository customerUserRepository, AdminUserRepository adminUserRepository) {
		this.customerUserRepository = customerUserRepository;
		this.adminUserRepository = adminUserRepository;
	}

	/*Customer User*/
	//Loging Using User ID

	public CustomerUser getUser(String userId) throws FieldValueNotFoundException {
		return customerUserRepository.findById(userId).orElseThrow(()->new FieldValueNotFoundException("userId"));
	}

	public CustomerUser customerUserLoginUsingUserId(String userId, String password) throws FieldValueNotFoundException, InvalidPassWordException {
		CustomerUser user = customerUserRepository.findById(userId).orElse(null);
		if(user == null) {
			throw new FieldValueNotFoundException("user-id");
		}
		if(!password.equals(user.getPersonalInformation().getPassword())){
			throw new InvalidPassWordException("invalid-password");
		}
		return user;
	}

	public CustomerUser loginUsingUserMailId(String mailId,String password) throws FieldValueNotFoundException, InvalidPassWordException {
		CustomerUser user = customerUserRepository.findById(mailId).orElse(null);
		if(user==null){
			throw new FieldValueNotFoundException("mailId");
		}
		if(!password.equals(user.getPersonalInformation().getPassword())){
			throw new InvalidPassWordException("invalidPassword");
		}
		return user;
	}
	
	public CustomerUser customerUserSignUp(String userId, String userName, String mailId, String password, String mobileNumber, Date dateOfBirth) {
		CustomerUser user = new CustomerUser(userId,userName,mailId,password,mobileNumber,dateOfBirth,new Date(),"active",new ArrayList<>());
		if(customerUserRepository.existsByPersonalInformationMailId(mailId)){
			throw new DuplicateKeyException("mailId");
		}
		if(customerUserRepository.existsByUserId(userId)){
			throw new DuplicateKeyException("userId");
		}
		if(customerUserRepository.existsByPersonalInformationMobileNumber(mobileNumber)){
			throw new DuplicateKeyException("mobileNumber");
		}
		return customerUserRepository.save(user);
	}

	/*Admin User*/
	//Login for admin
	public AdminUser adminUserLoginUsingUserId(String userId, String password) throws FieldValueNotFoundException, InvalidPassWordException {
		AdminUser user = adminUserRepository.findById(userId).orElse(null);
		if(user == null) {
			throw new FieldValueNotFoundException("userId");
		}
		if(password.equals(user.getPersonalInformation().getPassword())){
			throw new InvalidPassWordException("invalidPassword");
		}
		return user;
	}
}
