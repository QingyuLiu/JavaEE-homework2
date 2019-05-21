package com.example.demo.oauth2;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//
//@EnableWebSecurity //开启权限认证
//public class Oauth2SecurityConfig extends WebSecurityConfigurerAdapter{
//
//	 // 配置这个bean会在做AuthorizationServerConfigurer配置的时候使用
//    @Bean
//    @Override
//
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin"))
//                .roles("test")
//        ;
//    }
//
//}
