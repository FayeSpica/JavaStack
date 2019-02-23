package jre.jdbc;

import java.sql.*;

/**
 * 测试批处理,避免使用PreparedStatement
 * */
public class Test04 {
    public static void main(String[] args){
        Connection connection=null;
        Statement stmt=null;
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

            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            for(int i=0;i<20000;i++){
                stmt.addBatch("INSERT INTO t_user (user_name,pwd,create_time) VALUES ('gao"+i+"','666',NOW())");
            }
            stmt.executeBatch();
            connection.commit(); //手动提交事务

            end = System.currentTimeMillis();
            System.out.println("[Statement]批量插入，耗时：" + (end - start) + "ms毫秒");
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
                if(stmt!=null){
                    stmt.close();
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
