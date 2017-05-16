package com.yue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yue.model.User;
import com.yue.service.UserService;
import com.yue.util.JsonResult;

@Controller
public class UserController {
	@Autowired
	
	private UserService userService;
	User user = new User();
//	注册
	@RequestMapping(value="insertUser")
	@ResponseBody
	public JsonResult<User> insertUser(String userId,String userName,String password,String userTel,String userAddr,String userSex){
		user.setUserId(userId);
		user.setUserName(userName);
		user.setPassword(password);
		user.setUserTel(userTel);
		user.setUserAddr(userAddr);
		user.setUserSex(userSex);
		try{
			int flag= userService.insertUser(user);
			user.setPassword("*********");
			if(flag==1){
				return new JsonResult<User>(user);	
			}else{
				User error = new User();
				JsonResult<User> result = new JsonResult<User>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<User>(e);
		}
		
	}
//	登录
	@RequestMapping(value="queryUserByName")
	@ResponseBody
	public JsonResult<User> queryUserByName(String username,String password){
		user.setUserName(username);
		user.setPassword(password);
		try{
			User getUser= userService.queryUserByName(user);
			try{
				getUser.setPassword("**********");
				return new JsonResult<User>(getUser);
			}catch(Exception e){
				return new JsonResult<User>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<User>(e);
		}
		
	}
//	查询所有用户
	@RequestMapping(value="queryAllUser")
	@ResponseBody
	public JsonResult<List<User>> queryAllUser(){
		try{
			List<User> getUser= userService.queryAllUser();
			return new JsonResult<List<User>>(getUser);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<List<User>>(e);
		}
		
	}

}