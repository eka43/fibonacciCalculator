package com.project383.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project383.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
