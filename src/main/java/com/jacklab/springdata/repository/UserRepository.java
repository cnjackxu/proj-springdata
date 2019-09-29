package com.jacklab.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacklab.springdata.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	

}
