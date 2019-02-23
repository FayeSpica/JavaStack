package jre.jdbc;

import java.sql.*;

/**
 * 测试ResultSet语句执行
 * */
public class Test03 {
    public static void main(String[] args){
        Connection connection=null;
        PreparedStatement ps=null;
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


            String sql = "SELECT * FROM t_user";  //避免注入
            ps = connection.prepareStatement(sql);
            boolean affected = ps.execute();
            //int count = ps.executeUpdate();

            rs = ps.executeQuery();

            System.out.println(rs);

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getDate(4));
            }
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
                if(connection!=null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
