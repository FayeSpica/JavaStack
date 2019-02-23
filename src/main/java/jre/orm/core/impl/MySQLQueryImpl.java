package jre.orm.core.impl;

import jre.jdbc.JDBCUtil;
import jre.orm.bean.ColumnInfo;
import jre.orm.bean.TableInfo;
import jre.orm.bean.User;
import jre.orm.core.DBManager;
import jre.orm.core.Query;
import jre.orm.core.TableContext;
import jre.orm.utils.JDBCUtils;
import jre.orm.utils.ReflectUtils;
import jre.orm.utils.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liaowm5
 * @version 1.0
 * @description MySQL查询 分页
 * @date 2019-02-23 13:45
 **/
public class MySQLQueryImpl extends Query {

    public static void main(String[] args){
        User user = new User();
        user.setId(6);
        user.setUser_name("fffg");
        //new MySQLQueryImpl().delete(user);
        //new MySQLQueryImpl().update(user,new String[]{"user_name"});
        List<User> list=new MySQLQueryImpl().queryAll(User.class,"SELECT * FROM user WHERE id>?",new Object[]{new Integer(7)});
        for(User user1:list){
            System.out.println(user1.getId());
        }
    }
}
