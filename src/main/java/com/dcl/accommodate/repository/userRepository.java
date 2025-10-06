package com.dcl.accommodate.repository;

import com.dcl.accommodate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Integer> {
}
