package com.niit.dao;

import com.niit.model.User;

public interface UserDao {
	public boolean registerUser(User userDetail);
	public boolean updateUser(User userDetail);
	public User getUser(String loginname);
	public User checkUser(User userDetail);

}
