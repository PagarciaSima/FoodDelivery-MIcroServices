package com.pgs.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgs.user.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}