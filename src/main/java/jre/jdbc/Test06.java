package jre.jdbc;

import java.sql.*;
import java.util.Date;
import java.util.Random;

/**
 * 测试时间处理
 * java.sql.Date
 * java.sql.Time
 * java.sql.TimeStamp
 * */
public class Test06 {


    public static void main(String[] args){
        Connection connection=null;
        PreparedStatement ps=null;
        PreparedStatement ps1=null;
        ResultSet rs=null;
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");

            long start = System.currentTimeMillis();
            //建立连接(连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时！这是Connection对象管理的一个要点！)

            //真正开发中，为了提高效率，都会使用连接池来管理连接对象！
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/test", "root", "root#0");
            long end = System.currentTimeMillis();
            System.out.println(connection);
            System.out.println("建立连接，耗时：" + (end - start) + "ms毫秒");

            start = System.currentTimeMillis();

            for (int i=0;i<100000;i++) {
                ps = connection.prepareStatement("INSERT INTO t_user (user_name,create_time,create_timestamp) VALUES(?,?,?)");
                ps.setObject(1, "B0");
                ps.setObject(2, new Date());

                ps.setObject(3, new Timestamp(System.currentTimeMillis()- (new Random().nextInt((int)Math.pow(10,9)) )));
                ps.executeUpdate();
                //System.out.println("插入一个用户");
            }

            end = System.currentTimeMillis();
            System.out.println("默认事务自动提交，耗时：" + (end - start) + "ms毫秒");

            start = System.currentTimeMillis();

            connection.setAutoCommit(false);
            for (int i=0;i<100000;i++) {
                ps = connection.prepareStatement("INSERT INTO t_user (user_name,create_time,create_timestamp) VALUES(?,?,?)");
                ps.setObject(1, "B0");
                ps.setObject(2, new Date());

                ps.setObject(3, new Timestamp(System.currentTimeMillis()- (new Random().nextInt((int)Math.pow(10,9)) )));
                ps.executeUpdate();
                //System.out.println("插入一个用户");
            }
            connection.commit();
            end = System.currentTimeMillis();
            System.out.println("事务手动提交，耗时：" + (end - start) + "ms毫秒");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rs!=null){
                    rs.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if(ps!=null){
                    ps.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if(ps1!=null){
                    ps1.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if(connection!=null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
