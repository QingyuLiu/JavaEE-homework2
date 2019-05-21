package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class Register {
	@Autowired
	  private UserService userService;
	
	
	
	@PostMapping(value="/register")
	public ModelAndView addUser(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("email") String email) {
		   System.out.println(username+password);
		   User user=new User();
		   user.setUsername(username);
		   user.setPassword(password);
		   user.setEmail(email);
		   
		  if(userService.save(user)==true) {
			     ModelAndView mv = new ModelAndView("redirect:/login"); 
	   	        return mv; 
		  }
			
		  else {
			  ModelAndView mv = new ModelAndView("redirect:/register"); 
	   	        return mv; 
		  }
		  
		
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView register() {
		
		  ModelAndView mv = new ModelAndView("redirect:/register"); 
 	        return mv; 
	}
	
}
