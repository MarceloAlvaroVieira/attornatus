package com.attornatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.model.User;

public interface UserRepository extends JpaRepository<User, Long>{}