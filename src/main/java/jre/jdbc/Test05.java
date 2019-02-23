package jre.jdbc;

import java.sql.*;

/**
 * 测试事务
 * */
public class Test05 {


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

            connection.setAutoCommit(false);  //默认true,自动提交事务

            ps = connection.prepareStatement("INSERT INTO t_user (user_name,pwd) VALUES(?,?)");
            ps.setObject(1,"B0");
            ps.setObject(2,"123456");
            ps.execute();
            System.out.println("插入一个用户");

            try {
                Thread.sleep(6000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }


            ps1 = connection.prepareStatement("INSERT INTO t_user (user_name,pwd) VALUES(?,?,?)");
            ps1.setObject(1,"B1");
            ps1.setObject(2,"123456");
            ps1.execute();

            connection.commit();
            System.out.println("插入第二个用户");

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
