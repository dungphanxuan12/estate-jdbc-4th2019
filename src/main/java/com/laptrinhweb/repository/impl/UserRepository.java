package com.laptrinhweb.repository.impl;

import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.repository.IUserRepository;

public class UserRepository extends AbstractJDBC<UserEntity> implements IUserRepository {

	@SuppressWarnings("unused")
	@Override
	public Long insert(UserEntity userEntity) {
		String sql = "INSERT ";
		return null;
	}

}
