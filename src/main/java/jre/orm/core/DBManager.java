package jre.orm.core;

import jre.orm.bean.Configuration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author liaowm5
 * @version 1.0
 * @description 连接对象的管理
 * @date 2019-02-23 08:25
 **/
public class DBManager {
    private static Configuration conf;

    static {
        Properties pros = new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        conf=new Configuration();
        conf.setDriver(pros.getProperty("mysql-driver"));
        conf.setUrl(pros.getProperty("mysql-url"));
        conf.setUser(pros.getProperty("mysql-user"));
        conf.setPasswd(pros.getProperty("mysql-pwd"));
        conf.setDb(pros.getProperty("mysql"));
        conf.setSrcPath(pros.getProperty("src-path"));
        conf.setPoPackage(pros.getProperty("po-package"));
        conf.setQueryClass(pros.getProperty("query-class"));
        conf.setJdbcPoolMax(Integer.parseInt(pros.getProperty("jdbc-pool-max")));
        conf.setJdbcPoolMin(Integer.parseInt(pros.getProperty("jdbc-pool-min")));
    }

    public static Connection getMYSQLConn(){
        try {
            Class.forName(conf.getDriver());
            return DriverManager.getConnection(conf.getUrl(),conf.getUser(),conf.getPasswd());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection createConn(){
        try {
            Class.forName(conf.getDriver());
            return DriverManager.getConnection(conf.getUrl(),conf.getUser(),conf.getPasswd());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Configuration getConf() {
        return conf;
    }

    public static void close(ResultSet rs, Statement ps, Connection conn){
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
            if(conn!=null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void close(Statement ps,Connection conn){
        try{
            if(ps!=null){
                ps.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            if(conn!=null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void close(Statement ps){
        try{
            if(ps!=null){
                ps.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void close(Connection conn){
        try{
            if(conn!=null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
