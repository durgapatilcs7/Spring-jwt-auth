package com.security.login.service;

import java.util.List;

import com.security.login.model.User;
import com.security.login.model.UserDto;

public interface UserService {

	User save(UserDto user);

	List<User> findAll();

	void delete(int id);

	User findOne(String username);

	User findById(int id);

	UserDto update(UserDto userDto);

}
