package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    //线程绑定
    private  static  ThreadLocal<Connection> tl=new ThreadLocal<>(); //创建一个ThreadLocal对象 泛型为Connection  将来只能绑定Connection对象

    private  static Properties prop=null;
    static {//静态代码块内容：只执行1次
        InputStream in=null;
        try {
            //通过输入流读取jdbc.properties配置文件
            // in = new FileInputStream("./src/jdbc.properties");
            //使用类加载的流读取配置文件
            //类加载的流读取配置文件  /表示是com顶级父包所在的目录
            //in=JDBCUtils.class.getResourceAsStream("/jdbc.properties");   //在src下面
            in= com.util.JDBCUtils.class.getResourceAsStream("/com/conf/jdbc.properties");
            //将配置文件的内容保存到properties集合中
            prop = new Properties();
            prop.load(in);
            //1 加载驱动
            Class.forName(prop.getProperty("driver"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //抽取jdbc前两步
    public  static Connection getConnection(){
        //1.先从ThreadLocal中获取Connection
        Connection conn=tl.get();
        //如果获取不到coon 代表是第一次获取连接对象，需要从数据库获取连接对象
        if(conn==null) {
            try {
                //2 创建和数据库之间的连接
                String url = prop.getProperty("url");
                String username = prop.getProperty("username");
                String password = prop.getProperty("password");
                conn = DriverManager.getConnection(url, username, password);
                //将创建好的conn进行绑定
                tl.set(conn);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }
        //如果不为null  代表不是第一次使用  直接返回
        return conn;
    }

    public static void close(Connection conn, PreparedStatement pstm, ResultSet rs){
        //6 释放资源
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (pstm!=null){
            try {
                pstm.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
                //当使用完conn之后 需要在释放资源的同时将conn给移除掉
                tl.remove();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        System.out.println(getConnection());
    }


}
