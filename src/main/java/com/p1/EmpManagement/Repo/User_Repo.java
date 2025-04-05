package com.p1.EmpManagement.Repo;

import com.p1.EmpManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface User_Repo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
