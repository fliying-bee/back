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
			Integer setUser= userService.insertUser(user);
			user.setPassword("*********");
			if(setUser==1){
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
	public JsonResult<List> queryAllUser(){
		try{
			List getUser= userService.queryAllUser();
			return new JsonResult<List>(getUser);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<List>(e);
		}
		
	}
	
//	@RequestMapping(value="findAllUser.do")
//	@ResponseBody
//	public Map<String, Object> findAllUser(Model model){
//		System.out.println("------------------------------>findAllUser");
//		this.page = new Page();
//		List<User> users = userService.findAllUser();
//    	userAll = users;
//    	Map<String, Object> modelMap = new HashMap<String, Object>(3);
//    	modelMap.put("test",users);
////    	getPage(users,model);
////		getSubList(users,model);
//		return modelMap;
//	}
//	@RequestMapping(value="add")
//	public String add(){
//		System.out.println("------------------------------->add");
//		return "add";
//	}
//	@RequestMapping(value="alter")
//	public String alter(@RequestParam(value="id") int id,Model model){
//		System.out.println("------------------------------->alter");
//		for(int i=0;i<userAll.size();i++){
//			User user = userAll.get(i);
//			if(user.getId()==id){
//				model.addAttribute("user", user);
//			}
//		}
//		return "add";
//	}
//	@RequestMapping(value="mergeUser.do")
//	public String mergeUser(@ModelAttribute("user") @Valid  User user,Model model){
//		System.out.println("-------------------------------->mergeUser");
//		userService.mergeUser(user);
//		List<User> users = userService.findAllUser();
//    	userAll = users;
//		getPage(users,model);
//    	getSubList(users,model);
//		return "main";
//	}
//	@RequestMapping(value="deleteUser.do")
//	public String deleteUser(@ModelAttribute("page") @Valid  Page page,@RequestParam(value="id") int id,Model model){
//		System.out.println("-------------------------------->deleteUser");
//		this.page=page;
//		int flag = userService.deleteUser(id);
//		System.out.println("***flag="+flag);
//		List<User> users = userService.findAllUser();
//		if((page.getCurrentPage()-1)*page.getRowsPerPage() == users.size()){
//		   page.setCurrentPage(page.getCurrentPage()-1);
//		}
//    	userAll = users;
//		getPage(users,model);
//    	getSubList(users,model);
//		return "main";
//	}
//	@RequestMapping(value="selectUser.do")
//	public String selectUser(@ModelAttribute("page") @Valid  Page page,Model model){
//		System.out.println("------------------------------->selectUser");
//		this.page = page;
//		List<User> users = userService.selectUser(page.getUsername_cx());
//    	userAll = users;
//        page.setRowsPerPage(3);
//        page.setCurrentPage(1);
//		getPage(users,model);
//		getSubList(users,model);
//		return "main";
//	}
//	@RequestMapping(value="turnPage.do")
//	public String turnPage(@ModelAttribute("page") @Valid  Page page,Model model){
//		System.out.println("------------------------------->turnPage");
//		this.page = page;
//		getPage(userAll,model);
//		getSubList(userAll,model);
//		return "main";
//	}
//	public void getSubList(List<User> users,Model model){
//    	int rowsCount = users.size();
//		int start = (page.getCurrentPage()-1)*page.getRowsPerPage() ;
//		int end = page.getCurrentPage()*page.getRowsPerPage() ;
//		int startIndex = start>rowsCount?1:start;
//		int endIndex = end>rowsCount?rowsCount:end;
//		List<User> userList = userAll.subList(startIndex,endIndex);
//		model.addAttribute("userList",userList);
//	}
//	public void getPage(List<User> users,Model model){
//    	int rowsCount = users.size();
//    	int totalPage = rowsCount/page.getRowsPerPage()+(rowsCount%page.getRowsPerPage()>0?1:0);
//    	page.setRowsCount(rowsCount);
//    	page.setTotalPage(totalPage);
//    	model.addAttribute("page",page );
//    	
//	}

}