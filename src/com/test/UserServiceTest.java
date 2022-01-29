package com.test;

import com.service.UsersService;
import com.service.impl.UsersServiceImpl;
import org.junit.Test;

public class UserServiceTest {
    private  UsersService usersService = new UsersServiceImpl();
    @Test
    public void login(){
        boolean login = usersService.login("ycy", "123");
        System.out.println(login);
    }
    @Test
    public void register(){
        usersService.register("陈贝勒","123456","123456");
    }
}
