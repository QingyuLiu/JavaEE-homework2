package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.transaction.annotation.EnableTransactionManagement;




@EnableCaching

@SpringBootApplication
@Configuration

@EntityScan
@EnableJpaRepositories(basePackages = "webroot.webserv",
entityManagerFactoryRef = "entityManagerFactory",
transactionManagerRef = "transactionManager")

@EnableTransactionManagement
@EnableAutoConfiguration
@MapperScan("com.example.demo.mapper")

//@EnableAuthorizationServer  //开启认证服务

public class GymApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);
	}
	
	 protected SpringApplicationBuilder config(SpringApplicationBuilder applicationBuilder){
	        return applicationBuilder.sources(GymApplication.class);
	    }


}


