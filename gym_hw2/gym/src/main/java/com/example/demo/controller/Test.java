package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.entity2.Coach;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository2.CoachRepository;
import com.example.demo.service.CoachService;
import com.example.demo.service.UserService;

import org.springframework.data.domain.Sort;




@Controller

public class Test {
//	
//	

	
	@Autowired
	private UserRepository userRepository;
	

	
	//分页显示
	@RequestMapping(value="/list")
	public String list(Model m ,@RequestParam(value="pageNo", required=false, defaultValue="0") int pageNo, 
			@RequestParam(value="size",defaultValue="5") int size) throws Exception{
		
		pageNo=pageNo<0?0:pageNo;
		Sort sort=new Sort(Sort.Direction.ASC,"id");
		
		
		Pageable pageable = new PageRequest(pageNo, size,sort);
		
		  Page<User> page = userRepository.findAll(pageable);
		  
		    System.out.println("page.getNumber()"+page.getNumber());  //当前页start
	        System.out.println("page.getNumberOfElements()"+page.getNumberOfElements());  //当前页start
	        System.out.println("page.getSize()"+page.getSize());   //每页数量size
	        System.out.println("page.getTotalElements()"+page.getTotalElements());  //总数量
	        System.out.println("page.getTotalPages()"+page.getTotalPages());    //总页数

	        m.addAttribute("page", page);
	        System.out.println("m="+m);
				return "list";
	
	}
	


}
