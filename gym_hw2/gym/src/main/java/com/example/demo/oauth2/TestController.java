package com.example.demo.oauth2;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@EnableResourceServer  //开启资源服务
//
//public class TestController {
//
//	 private static final Logger log = LoggerFactory.getLogger(TestController.class);
//	 
//	// 添加一个测试访问接口
//    @GetMapping("/user")
//    public Authentication getUser(Authentication authentication) {
//    	
//    
//    	
//        log.info("resource: user {}", authentication);
//        return authentication;
//    }
//
//	
//}
