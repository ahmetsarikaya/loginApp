package com.ebebek.dao;

import com.ebebek.model.User;

public interface UserDao {
	User findUserByUsername(String username);

	int saveUser(User user);
}
