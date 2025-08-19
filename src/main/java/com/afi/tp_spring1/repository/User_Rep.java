package com.afi.tp_spring1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afi.tp_spring1.model.User;

public interface User_Rep extends JpaRepository<User, Long>{

}
