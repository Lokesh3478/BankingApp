package com.l3org.bankingsystem.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.l3org.bankingsystem.model.Account;
import com.l3org.bankingsystem.model.User;
import com.l3org.bankingsystem.repository.UserRepositiry;

@Service
public class UserService {
	@Autowired
	private UserRepositiry userRepo;
	public UserService(UserRepositiry userRepo) {
		this.userRepo = userRepo;
	}
	public User loginUsingUserId(String userId,String password) {
		User user = userRepo.findById(userId).orElse(null);
		return user;
	}
	
//	public User loginUsingUserMailId(String mailId,String password) {
//		User user = userRepo.findUserBymailId(mailId).orElse(null);
//		return user;
//	}
	
	public User signUp(String userId, String userName, String mailId, String password, String mobileNumber, Date dateOfBirth) {
		User user = new User(userId, userName, mailId, password, mobileNumber, dateOfBirth, new Date(), "active", new ArrayList<Account>());
		try {
			return userRepo.save(user);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
}
