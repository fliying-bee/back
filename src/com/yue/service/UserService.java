package com.yue.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yue.dao.UserDao;
import com.yue.model.User;
@Service
public class UserService {
	@Autowired
	private UserDao userdao;
//    public List<User> findAllUser(){
//    	return iuser.findAllUser();
//    }
    public User queryUserByName(User user){
    	return userdao.queryUserByName(user);
    }
    public List queryAllUser(){
    	return userdao.queryAllUser();
    }
//    public int insertUser(User user){
//    	return iuser.insertUser(user);
//    }
//    public int deleteUser(int id){
//    	return iuser.deleteUser(id);
//    }
//	public int updateUser(User user) {
//		return iuser.updateUser(user);
//	}
//	public void mergeUser(User user) {
//		 iuser.mergeUser(user);
//	}
//	public List<User> selectUser(String username_cx) {
//		return iuser.selectUser(username_cx);
//	}
}
