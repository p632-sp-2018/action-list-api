package com.actionlistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.actionlistapi.model.Principal;

import java.util.Optional;

public interface PrincipalRepository extends JpaRepository<Principal,String> {

    Principal findByUniversityId(String username);
}
