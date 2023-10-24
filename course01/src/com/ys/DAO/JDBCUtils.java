package com.ys.DAO;






import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * ClassName:JDBCUtils
 * Package:
 * Description:
 *
 * @Author:ziyou
 * @Create:2023/5/26 - 15:47
 * @Version:
 */
public class JDBCUtils {

    public static Connection getConnection() throws Exception {

        // 1.读取配置文件中的4个基本信息

        //1.获取Driver实现类对象
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //2.提供三个基本链接信息
        String  url = "jdbc:mysql://localhost:3306/db_course?rewriteBatchedStatements=true&useCode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "123456";
        //注册驱动
        DriverManager.registerDriver(driver);
        //获取链接
        Connection conn = DriverManager.getConnection(url,user,password);
        //System.out.println(conn);
        return conn;
    }
    public static Connection  getConnection2() throws Exception {
        // 1.读取配置文件中的4个基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("source/jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        // 2.加载驱动
        Class.forName(driverClass);

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
        return conn;
    }
    @Test
    public void  getConnection1() throws Exception {
        // 1.读取配置文件中的4个基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("source/jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        // 2.加载驱动
        Class.forName(driverClass);

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
        //return conn;
    }
    /**
     *
     * @Description 关闭连接和Statement的操作
     * @author shkstart
     * @date 上午9:12:40
     * @param
     * @param
     */
    public static void closeResource(Connection conn, Statement ps){
        try {
            if(ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @Description 关闭资源操作
     * @author shkstart
     * @date 上午10:21:15
     * @param conn
     * @param ps
     * @param rs
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs){
        try {
            if(ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if(ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


