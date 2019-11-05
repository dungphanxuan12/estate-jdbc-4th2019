package com.laptrinhweb.repository;

import com.laptrinhweb.entity.UserEntity;

public interface IUserRepository extends GenericJDBC<UserEntity> {

	Long insert(UserEntity userEntity);

}
