package com.l3org.bankingsystem.repository;

import com.l3org.bankingsystem.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser,String> {
}
