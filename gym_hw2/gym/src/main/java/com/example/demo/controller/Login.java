package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.limit.Limit;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.version.ApiVersion;


@ApiVersion(1)
@RequestMapping("/{version}")
@RestController

public class Login {
	
	private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

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
	
	@Limit(key = "login", period = 100, count = 2)
	@RequestMapping(value="/login", method=RequestMethod.GET)
	
	public  ModelAndView Login() {
		
		     ModelAndView mv = new ModelAndView("login"); 
		     System.out.println("version v1");
		    
		      System.out.println("这是第"+ATOMIC_INTEGER.incrementAndGet()+"次访问");
	        return mv; 
	}
	
	

}
