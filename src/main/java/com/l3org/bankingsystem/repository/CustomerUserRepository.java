package com.l3org.bankingsystem.repository;


import com.l3org.bankingsystem.model.CustomerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerUserRepository extends JpaRepository<CustomerUser,String> {
    @Query
    boolean existsByPersonalInformationMailId(String personalInformationMailId);
    @Query
    boolean existsByUserId(String userId);
    @Query
    boolean existsByPersonalInformationMobileNumber(String personalInformationMobileNumber);
}
