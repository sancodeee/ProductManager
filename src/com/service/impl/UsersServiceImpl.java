package com.service.impl;

import com.dao.impl.UsersDaoImpl;
import com.entity.Users;
import com.service.UsersService;
import com.util.JDBCUtils;


import java.sql.Connection;
import java.sql.SQLException;

public class UsersServiceImpl implements UsersService {
    private  UsersDaoImpl usersDao = new UsersDaoImpl();
    @Override
    public boolean login(String username, String password) {
        Connection conn = JDBCUtils.getConnection();
        boolean flag=true;

        try {
            conn.setAutoCommit(false);
            Users users = usersDao.selectUsersByUsername(username);
            if(users!=null&&users.getPassword().equals(password)){
               flag=true;
            } else {
                flag= false;
            }

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,null,null);
        }
        return flag;
    }

    @Override
    public void register(String username, String pwd1, String pwd2) {
        Connection conn = JDBCUtils.getConnection();
        try {
            conn.setAutoCommit(false);
            if(pwd1.equals(pwd2)){
                usersDao.insertUsers(new Users(null,username,pwd1));
            }else {
                throw new RuntimeException("注册失败");
            }
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,null,null);
        }

    }
}
