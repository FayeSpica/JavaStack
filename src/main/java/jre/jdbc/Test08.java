package jre.jdbc;

import java.io.Reader;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * 测试时间JDBCUtil
 * java.sql.Date
 * java.sql.Time
 * java.sql.TimeStamp
 * */
public class Test08 {

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
            connection = JDBCUtil.getMYSQLConn();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,connection);
        }
    }
}
