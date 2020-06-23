package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controller.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	@RequestMapping("/adduser")
	public String addUser(Model model) {

		model.addAttribute("userBean", new UserBean());
		return "addUser";// addUser.jsp
	}

	@PostMapping(value = "/insertuser")
	public String insertUser(UserBean userBean) {

		System.out.println(userBean.getFirstName());
		int res = userDao.addUser1(userBean);
		if (res > 0)
			return "redirect:viewuser";

		return "redirect:viewuser";
	}

	@GetMapping(value = "/viewuser")
	public String viewUser(Model model) {

		List<UserBean> listOfUsers = userDao.getAllUsers();
		model.addAttribute("users", listOfUsers);
		return "ViewUser";
	}

	@GetMapping(value = "/deleteuser/{uId}")
	public String deleteUser(@PathVariable int uId) {

		System.out.println("uid in deleet method .." + uId);
		userDao.deleteUser(uId);

		return "redirect:/viewuser";

	}
	@RequestMapping(value="/edituser/{uId}")
	public String editUser(@PathVariable String uId,Model model)
	{
		UserBean userBean =userDao.getDataById(uId);
		System.out.println(userBean.getFirstName());
		model.addAttribute("userBean1",new UserBean());
		model.addAttribute("userBean", userBean);
		return "EditUser";
	}
	
	
	  @PostMapping(value="/updateuser") 
	  public String updateUser(UserBean userBean1) {
	 
		  System.out.println(userBean1.getFirstName());
		  
		  int res=userDao.updateUser(userBean1);
		  if (res > 0)
				return "redirect:viewuser";

			return "redirect:viewuser";
	  }
	 

}
