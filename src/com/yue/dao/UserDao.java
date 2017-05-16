package com.yue.dao;

import java.util.List;

import com.yue.model.User;

public interface UserDao {
//	 public List<User> findAllUser();
	 public User queryUserByName(User user);
	 public int insertUser(User user);
	 public List<User> queryAllUser();
//	 public int insertUser(User user);
//	 public int deleteUser(int id);
//	 public int updateUser(User user);
//	 public void mergeUser(User user);
//	 public List<User> selectUser(String username_cx);
}

