package jre.jdbc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 测试时间处理,取出指定时间段的数据
 * 文本大对象的使用。包含：将字符串、文件内容插入数据库中的CLOB字段，将CLOB字段值取出来的操作。
 * BLOB对象的使用。包含：将字符串、文件内容插入数据库中的BLOB字段，将BLOB字段值取出来的操作。
 * java.sql.Date
 * java.sql.Time
 * java.sql.TimeStamp
 * */
public class Test07 {

    public static long str2date(String dateStr){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
            return format.parse(dateStr).getTime();
        }catch (ParseException e){
            e.printStackTrace();
            return -1;
        }
    }

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

            ps = connection.prepareStatement("SELECT * FROM t_user WHERE create_timestamp > ? AND create_timestamp < ?");


            java.sql.Date dateStart = new java.sql.Date(str2date("2019-02-13 12:38:44"));
            java.sql.Date dateEnd = new java.sql.Date(str2date("2019-02-16 00:00:00"));

            ps.setObject(1,dateStart);
            ps.setObject(2,dateEnd);

            //ps.setClob(2,new FilerReader(new File("d:/a.txt")));  //将文本文件内容直接输入到数据库中

            rs = ps.executeQuery();

            //将程序中的字符串输入到数据库的CLOB字段
            //ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaabbb".getBytes()))));

            ps = connection.prepareStatement("SELECT * FROM t_user WHERE id=?");
            ps.setObject(1,101024);

            //ps.setBlob(3, new FileInputStream("d:/icon.jpg"));


            rs = ps.executeQuery();
            while (rs.next()){
                Clob clob = rs.getClob("myInfo");
                Reader reader = clob.getCharacterStream();
                int temp = 0;
                while ((temp=reader.read())!=-1){
                    System.out.println((char)temp);
                }
            }

            while(rs.next()){
                System.out.println(rs.getInt("id")+"--"+rs.getString("user_name")+"--"+rs.getTimestamp("create_timestamp"));
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
