package jre.orm.utils;

import java.sql.PreparedStatement;

/**
 * @author liaowm5
 * @version 1.0
 * @description 封装JDBC查询操作
 * @date 2019-02-23 08:25
 **/
public class JDBCUtils {

    /**
     * @description: 给SQL设置参数
     * @param ps 1 预编译sql语句对象
     * @param params 2 参数
     * @return: void 
     **/
    public static void handleParams(PreparedStatement ps,Object... params){
        try {
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
