package com.service;

public interface UsersService {
    //业务方法：登录
    public  boolean login(String username,String password);
    //业务方法:注册方法
    public void register(String  username,String pwd1,String pwd2);
}
