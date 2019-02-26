package jre.orm.pool;

import jre.orm.core.DBManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liaowm5
 * @version 1.0
 * @description 连接池的类 采用LRUCache实现
 * @date 2019-02-23 17:32
 **/
public class DBConnPool {
    private static List<Connection> pool;  //连接池对象

    //最大连接数
    private static final int POOL_MAX_SIZE;
    //最小连接数
    private static final int POOL_MIN_SIZE;

    static {
        POOL_MAX_SIZE=DBManager.getConf().getJdbcPoolMax();
        POOL_MIN_SIZE=DBManager.getConf().getJdbcPoolMin();
    }

    public void initPool(){
        if(pool==null){
            pool = new ArrayList();
        }

        while (pool.size()<DBConnPool.POOL_MIN_SIZE){
            pool.add(DBManager.createConn());
            System.out.println("初始化池，池中连接数："+pool.size());
        }
    }

    /**
     * @description:  从连接池中取出连接(从容器中去除)
     * @param
     * @return: java.sql.Connection
     **/
    public synchronized Connection getConnection(){
        int lastIndex = pool.size()-1;
        Connection connection=pool.get(lastIndex);
        pool.remove(connection);


        return connection;
    }

    /**
     * @description: 将连接放回池中
     * @param connection 1
     * @return: void
     **/
    public synchronized void close(Connection connection){
        if(pool.size()>POOL_MAX_SIZE){ //超过
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            pool.add(connection);
        }
    }

    public DBConnPool() {
        initPool();
    }


}
