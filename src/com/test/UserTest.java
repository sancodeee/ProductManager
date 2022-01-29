package com.test;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.entity.Users;
import org.junit.Test;

import java.util.List;

public class UserTest {
    private UsersDao usersDao = new UsersDaoImpl();
    @Test
    public  void  insert(){

        usersDao.insertUsers(new Users("ycy9","123456"));
    }
    @Test
    public void  delete(){
        usersDao.deleteUsersById(5);
    }
    @Test
    public void update(){
        usersDao.updateUsers(new Users(3,"ycy1","123456"));
    }
    @Test
    public void selectById(){
        Users users = usersDao.selectUsersById(1);
        System.out.println(users);

    }
    @Test
    public void selectByName(){
        Users users = usersDao.selectUsersByUsername("ycy");
        System.out.println(users);

    }
    @Test
    public void selectAll(){
        List<Users> users = usersDao.selectUsers();
        for (Users s : users) {
            System.out.println(s);
        }
    }


}
