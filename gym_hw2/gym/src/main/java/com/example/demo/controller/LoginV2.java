package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.version.ApiVersion;

@ApiVersion(2)
@RequestMapping("/{version}")
@RestController
public class LoginV2 {

	@Autowired
	  private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping(value="/login")
	public ModelAndView list(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		        if(userService.login(user)==false) {
		        	   ModelAndView mv = new ModelAndView("redirect:/login"); 
		   	        return mv; 
		        }
		        	
		        else {
		        	 ModelAndView mv = new ModelAndView("redirect:/list"); 
			   	        return mv; 
		        }
		        	
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)

	public  ModelAndView Login() {
		
		     ModelAndView mv = new ModelAndView("login"); 
		     System.out.println("version v2");
	        return mv; 
	}
	
	
	

	
}
