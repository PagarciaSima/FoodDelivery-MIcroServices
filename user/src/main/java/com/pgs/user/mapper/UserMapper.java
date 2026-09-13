package com.pgs.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.pgs.user.dto.UserDTO;
import com.pgs.user.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User mapUserDTOToUser(UserDTO userDTO);

	UserDTO mapUserToUserDTO(User user);

}