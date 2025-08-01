package timetracker.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import timetracker.admin.entity.User;
import timetracker.admin.service.UserService;

@Controller
@RequestMapping("admin/user")
public class UserController 
{
	@Autowired private UserService userService;
	@Autowired private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("dashboard")
	public ModelAndView getUserDashboardView()
	{
		List<User> userList=userService.getList();
		ModelAndView modelAndView=new ModelAndView("admin/dashboard/user/user-dashboard");
		modelAndView.addObject("userList",userList);
		return modelAndView;
	}
	@GetMapping("get-user")
	@ResponseBody
	public Boolean getUserByUsername(String username)
	{
		User user=userService.findUserByUsername(username);
		return user!=null;
	}
	@PostMapping("add-user")
	public String addUser(User user)
	{
		String password=user.getPassword();
		String epassword=passwordEncoder.encode(password);
		user.setPassword(epassword);
		userService.createUser(user);
		return "redirect:dashboard";
	}
}
