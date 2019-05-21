package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.entity2.Coach;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository2.CoachRepository;
import com.example.demo.service.CoachService;

import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@RestController
public class CURD {
	
	  private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	  private CoachService coachService;
	@Autowired
	private CoachRepository coachRepository;
	
	
	
	@GetMapping("/deleteUser")
	  public ModelAndView deleteUser(User u)throws Exception{
		userRepository.delete(u);
		  ModelAndView mv = new ModelAndView("redirect:/list"); 
	        return mv;
    //删除成功,重定向到分类查询页面
  }

	@RequestMapping("/updateUser")   //修改方法
  public ModelAndView updateUser(User u)throws Exception{
		userRepository.saveAndFlush(u); //CrudRepository:JPA 新增和修改用的都是save. 它根据实体类的id是否为0来判断是进行增加还是修改
		 ModelAndView mv = new ModelAndView("redirect:/list"); 
	        return mv;
      //修改成功,重定向到分类查询页面
  }

	
	 @RequestMapping("/editUser")     //获取方法（先走查询，再走修改）
	    public ModelAndView editUser(int id ,Model m)throws Exception{
	        Optional<User> u =userRepository.findById(id);  //根据id查询
	        m.addAttribute("u",u.get()); //查到展示到修改页面
	        ModelAndView mv = new ModelAndView("editUser"); 
	        return mv;
	           }
	 
	 @GetMapping(value="/find")
		public ModelAndView Find(Model m,@RequestParam(value="pageNo", required=false, defaultValue="0") int pageNo, 
				@RequestParam(value="size",defaultValue="5") int size) throws Exception{
			
			pageNo=pageNo<0?0:pageNo;
			Sort sort=new Sort(Sort.Direction.ASC,"id");
			
			
			Pageable pageable = new PageRequest(pageNo, size,sort);
			
			  Page<Coach> page = coachRepository.findAll(pageable);
			  
			    System.out.println("page.getNumber()"+page.getNumber());  //当前页start
		        System.out.println("page.getNumberOfElements()"+page.getNumberOfElements());  //当前页start
		        System.out.println("page.getSize()"+page.getSize());   //每页数量size
		        System.out.println("page.getTotalElements()"+page.getTotalElements());  //总数量
		        System.out.println("page.getTotalPages()"+page.getTotalPages());    //总页数

		        m.addAttribute("page", page);
		        System.out.println("m="+m);
		        ModelAndView mv = new ModelAndView("find"); 
		        return mv;
					
		
		}
	 

	 @ApiOperation(value = "根据id查询用户信息", notes = "查询数据库中某个用户的信息")
	 @PostMapping(value = "/find") 
	 public ModelAndView findUser(@RequestParam("id") String id,Model m)
	 
	 {       
		 logger.info("开始查询某个用户的信息");
		
		 Integer id1=Integer.parseInt(id);
			
		
		 
		 
		 List<Coach> list= new ArrayList<Coach>();
		 list.add(coachService.findById(id1));
			  Page<Coach> page = new PageImpl<Coach>(list, new PageRequest(0, 5), 1);
					  
			  

		        m.addAttribute("page", page);
		        ModelAndView mv = new ModelAndView("find"); 
		        return mv;
	 }
}
