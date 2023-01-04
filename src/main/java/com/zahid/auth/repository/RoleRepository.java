package com.zahid.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zahid.auth.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    
}
