package com.actionlistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.actionlistapi.model.Principal;


// Implementation to access and query  principal table
public interface PrincipalRepository extends JpaRepository<Principal,String> {

    Principal findByUniversityId(String username);
}
