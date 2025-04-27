package com.springdersleri.main;

import com.springdersleri.__SpringProjesi.User;
import com.springdersleri.config.AppConfig;
import com.springdersleri.services.LoginService;
import com.springdersleri.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext context =  new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		System.out.println(userService.getUserList());
		for (User user : userService.getUserList()) {
			System.out.println(user);
		}

		LoginService loginService = new LoginService();
		loginService.Login();
	}

}
