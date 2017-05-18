package com.yue.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.yue.model.Page;
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
//	分页查询所有用户
	@RequestMapping(value="queryAllUserPage")
	@ResponseBody
	public JsonResult<Page<User>> queryAllUserPage(int currentPage, int pageSize){
		try{
			List<User> getUser= userService.queryAllUserPage();
			Page<User> page = new Page<User>();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalRow(getUser.size());
			List<User> pageUser = new ArrayList<User>();
			int start = (page.getCurrentPage()-1)*page.getPageSize();
			int end = start + page.getPageSize();
			for(int i=start;i<end;i++){
				try{
					pageUser.add(getUser.get(i));
				}catch(Exception e){
					
				}
			}
			page.setList(pageUser);
			try{
				return new JsonResult<Page<User>>(page);
			}catch(Exception e){
				return new JsonResult<Page<User>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Page<User>>(e);
		}
		
	}
//	根据用户编码查询用户
	@RequestMapping(value="queryUserById")
	@ResponseBody
	public JsonResult<User> queryUserById(String userId){
		try{
			User getUser= userService.queryUserById(userId);
			try{
				return new JsonResult<User>(getUser);
			}catch(Exception e){
				return new JsonResult<User>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<User>(e);
		}
		
	}
}