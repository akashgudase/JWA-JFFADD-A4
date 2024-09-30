package com.jspiders.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
