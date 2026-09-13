package com.pgs.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pgs.user.dto.UserDTO;
import com.pgs.user.entity.User;
import com.pgs.user.mapper.UserMapper;
import com.pgs.user.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public UserDTO addUser(UserDTO userDTO) {
	    User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
	    return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
	}

	public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
	    Optional<User> fetchedUser = userRepo.findById(userId);
	    if(fetchedUser.isPresent()) {
	        return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchedUser.get()), HttpStatus.OK);
	    }
	    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

}