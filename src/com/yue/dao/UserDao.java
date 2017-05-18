package com.yue.dao;

import java.util.List;

import com.yue.model.User;

public interface UserDao {
//	 public List<User> findAllUser();
	 //根据ID查 
	 public User queryUserById(String userId);
	 //分页查询所有
	 public List<User> queryAllUserPage();
	 public User queryUserByName(User user);
	 public int insertUser(User user);
	 public List<User> queryAllUser();
//	 public int insertUser(User user);
//	 public int deleteUser(int id);
//	 public int updateUser(User user);
//	 public void mergeUser(User user);
//	 public List<User> selectUser(String username_cx);
}

