package com.jsp.usere8.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.usere8.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
