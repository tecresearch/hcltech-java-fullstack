package com.cetpa.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cetpa.models.User;
import com.cetpa.repositories.AccountRepository;
import com.cetpa.services.UserService;

@Controller
public class UserController 
{
	@Autowired private UserService userService;
	@Autowired private AccountRepository accountRepository;
	
	@GetMapping("registration")
	public String getRegistrationView()
	{
		return "user/registration/registration-form";
	}
	@PostMapping("register-user")
	public String registerUser(User user,Model model)
	{
		int accountno=userService.saveUser(user);
		model.addAttribute("accountno",accountno);
		model.addAttribute("username",user.getFirstname()+" "+user.getLastname());
		return "user/registration/registration-success";
	}
	@PostMapping("authenticate-user")
	public ModelAndView authenticateUser(String userid,String password,HttpSession ses)
	{
		User user=userService.getUser(userid);
		ModelAndView modelAndView=new ModelAndView();
		if(user==null)
		{
			modelAndView.setViewName("user/login/login-form");
			modelAndView.addObject("msg","Entered userid does not exist");
			modelAndView.addObject("uid",userid);
			return modelAndView;
		}
		if(!user.getPassword().equals(password))
		{
			modelAndView.setViewName("user/login/login-form");
			modelAndView.addObject("msg","Entered password is wrong");
			modelAndView.addObject("uid",userid);
			return modelAndView;
		}
		ses.setAttribute("username",user.getFirstname()+" "+user.getLastname());
		int accountno=accountRepository.getAccountNoByUserId(userid);
		ses.setAttribute("accountno",accountno);
		modelAndView.setViewName("redirect:/");
		return modelAndView;
	}
	@GetMapping("logout")
	public String logoutUser(HttpSession ses,Model model)
	{
		model.addAttribute("username",ses.getAttribute("username"));
		ses.invalidate();
		return "user/login/logout-success";
	}
}
