package com.laptrinhweb.service.impl;

import com.laptrinhweb.converter.UserConverter;
import com.laptrinhweb.dto.UserDTO;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.service.IUserService;

public class UserService implements IUserService {

	@Override
	public UserDTO save(UserDTO newUser) {
		UserConverter userConverter = new UserConverter();
		@SuppressWarnings("unused")
		UserEntity userEntity = userConverter.convertToEntity(newUser);
		return null;
	}

}
