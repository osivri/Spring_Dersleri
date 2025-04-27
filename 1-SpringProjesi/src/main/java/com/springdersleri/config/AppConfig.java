package com.springdersleri.config;

import com.springdersleri.__SpringProjesi.User;
import com.springdersleri.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService() {
        UserService userService = new UserService();

        List<User> userList = new ArrayList<>();
        userList.add(new User("Oğuzhan"));
        userList.add(new User("Elif"));

        userService.setUserList(userList);
        return  userService;
    }
}
