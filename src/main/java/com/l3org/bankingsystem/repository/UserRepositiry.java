package com.l3org.bankingsystem.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.l3org.bankingsystem.model.User;

public interface UserRepositiry extends JpaRepository<User,String> {
}
