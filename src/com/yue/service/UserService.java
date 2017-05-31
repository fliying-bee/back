package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yue.dao.UserDao;
import com.yue.model.User;
@Service
public class UserService {
	@Autowired
	private UserDao userdao;
    public User queryUserByName(User user){
    	return userdao.queryUserByName(user);
    }
    public int insertUser(User user){
    	return userdao.insertUser(user);
    }
    public List<User> queryAllUser(){
    	return userdao.queryAllUser();
    }
    public List<User> queryAllUserPage(){
    	return userdao.queryAllUserPage();
    }
    public User queryUserById(String userId){
    	return userdao.queryUserById(userId);
    }
    public int updateUser(User user) {
		return userdao.updateUser(user);
	}

}
