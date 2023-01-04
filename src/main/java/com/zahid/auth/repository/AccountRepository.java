package com.zahid.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zahid.auth.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    public Account findByEmail(String email);
}
