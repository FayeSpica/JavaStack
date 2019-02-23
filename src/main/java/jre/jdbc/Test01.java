package jre.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 测试Statement语句执行
 * */
public class Test01 {
    public static void main(String[] args) throws Exception{
        // 加载驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");

        long start = System.currentTimeMillis();
        //建立连接(连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时！这是Connection对象管理的一个要点！)
        //真正开发中，为了提高效率，都会使用连接池来管理连接对象！
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/test","root","root#0");
        long end = System.currentTimeMillis();
        System.out.println(connection);
        System.out.println("建立连接，耗时："+(end-start)+"ms毫秒");


        // 1.Statement
        Statement stmt = connection.createStatement();
        stmt.execute("INSERT INTO t_user (user_name,pwd,create_time) VALUES ('A1','66666',now())");


    }
}
