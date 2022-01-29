package com.dao.impl;

import com.dao.UsersDao;
import com.entity.Users;
import com.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsersDaoImpl  implements UsersDao {
    @Override
    public void insertUsers(Users users) {
        Connection conn=null;
        PreparedStatement pstm=null;
        try {
            conn = JDBCUtils.getConnection();
            //3 准备一个发送SQL的工具
            String sql = "insert into t_users values (null ,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,users.getUsername());
            pstm.setString(2,users.getPassword());
            //4 发送并执行SQL
            pstm.executeUpdate();
            //5 处理结果集
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //6 释放资源
            JDBCUtils.close(null,pstm,null);
        }


    }

    @Override
    public void deleteUsersById(Integer id) {
        Connection conn=null;
        PreparedStatement pstm=null;
        try {
            conn= JDBCUtils.getConnection();
            //3 准备一个发送SQL的工具
            String sql = "delete from t_users where userId=? ";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
            //4 发送并执行SQL
            pstm.executeUpdate();
            //5 处理结果集
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(null,pstm,null);
        }

    }

    @Override
    public void updateUsers(Users users) {
        Connection conn=null;
        PreparedStatement pstm=null;
        try{
            conn=JDBCUtils.getConnection();
            //3 准备一个发送SQL的工具
            String sql = "update t_users set userName=?,password=? where userId=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,users.getUsername());
            pstm.setString(2,users.getPassword());
            pstm.setInt(3,users.getUserId());
            //4 发送并执行SQL
            pstm.executeUpdate();
            //5 处理结果集
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //6 释放资源
            JDBCUtils.close(null, pstm, null);
        }
    }

    @Override
    public Users selectUsersById(Integer id) {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        Users users=null;
        try {
            conn =JDBCUtils.getConnection();
            //3 准备一个发送SQL的工具
            String sql = "select * from t_users where userId=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
            //4 发送并执行SQL
            rs = pstm.executeQuery();
            //5 处理结果集
            if(rs.next()) {
                int userId = rs.getInt("userId");
                String username = rs.getString("username");
                String password = rs.getString("password");
                users=new Users(userId,username,password);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //6 释放资源
            JDBCUtils.close(null,pstm,rs);
        }
        return users;
    }

    @Override
    public Users selectUsersByUsername(String username) {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        Users users=null;
        try {
            conn =JDBCUtils.getConnection();
            //3 准备一个发送SQL的工具
            String sql = "select * from t_users where username=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,username);
            //4 发送并执行SQL
            rs = pstm.executeQuery();
            //5 处理结果集
            if (rs.next()) {
                int userId = rs.getInt("userId");
                String username1 = rs.getString("username");
                String password = rs.getString("password");
                users=new Users(userId,username1,password);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //6 释放资源
            JDBCUtils.close(null,pstm,rs);
        }
        return users;
    }

    @Override
    public List<Users> selectUsers() {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<Users> userss= new ArrayList<>();
        try {
            conn =JDBCUtils.getConnection();
            //3 准备一个发送SQL的工具
            String sql = "select * from t_users";
            pstm = conn.prepareStatement(sql);
            //4 发送并执行SQL
            rs = pstm.executeQuery();
            //5 处理结果集
            while (rs.next()) {
                int userId = rs.getInt("userId");
                String username1 = rs.getString("username");
                String password = rs.getString("password");
                Users users1 = new Users(userId, username1, password);
                userss.add(users1);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //6 释放资源
            JDBCUtils.close(null,pstm,rs);
        }
        return userss;
    }
}
