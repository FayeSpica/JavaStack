package jre.orm.core;

import jre.orm.bean.ColumnInfo;
import jre.orm.bean.TableInfo;
import jre.orm.utils.JDBCUtils;
import jre.orm.utils.ReflectUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lxx
 **/
@SuppressWarnings("all")
public abstract class Query implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @description: 增加模板方法，简化代码
     * @param callBack 1
     * @param clazz 2
     * @param sql 3
     * @param params 4
     * @return: java.util.List 
     **/
    public List executeQueryTemplate(CallBack callBack,Class clazz,String sql,Object[] params){
        Connection connection = DBManager.getMYSQLConn();
        List list = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try{
            ps = connection.prepareStatement(sql);
            JDBCUtils.handleParams(ps,params);

            rs = ps.executeQuery();
            list=callBack.execute(connection,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(ps,connection);
            return list;
        }
    }

    /**
     * @description:  直接执行一个DML语句
     * @param sql 1 SQL语句
     * @param params 2 PreparedStatement SQL参数
     * @return: int 执行SQL语句后影响记录的行数
     **/
    public int executeDML(String sql, Object... params) {

        Connection connection = DBManager.getMYSQLConn();
        int count = 0;
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql);
            JDBCUtils.handleParams(ps,params);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBManager.close(ps,connection);
        }

        return count;
    }

    /**
     * @description: 将一个对象存储到数据库中(只存对象中不为null的属性)
     * @param o 1 要存储的对象
     * @return: void
     **/
    public void insert(Object o) {
        // INSERT INTO [tableName] (id,...) VALUES (?,?)
        Class clazz = o.getClass();
        TableInfo tableInfo = TableContext.poClassTableInfoMap.get(clazz);

        StringBuilder sb = new StringBuilder("INSERT INTO "+tableInfo.getName()+" (");

        List<Object> params = new ArrayList<>();  //存储参数对象
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields){
            String fieldName = field.getName();
            Object fieldValue = ReflectUtils.invokeGet(fieldName,o);

            if(fieldValue!=null){
                sb.append(fieldName+",");
                params.add(fieldValue);
            }
        }

        sb.setCharAt(sb.length()-1,')');
        sb.append(" VALUES (");
        for (int i=0;i<params.size();i++){
            sb.append("?,");
        }
        sb.setCharAt(sb.length()-1,')');

        executeDML(sb.toString(),params.toArray());
    }

    /**
     * @description: 删除clazz表示类对应表中的记录(指定主键值id的记录)
     * @param clazz 1 跟表对应的Class对象
     * @param id 2 主键
     * @return: int 影响行数
     **/
    public int delete(Class clazz, Object id) {

        TableInfo tableInfo = TableContext.poClassTableInfoMap.get(clazz);

        ColumnInfo primaryColumn = tableInfo.getPrimaryKey();

        String sql = "DELETE FROM "+tableInfo.getName()+" WHERE "+primaryColumn.getName()+"=? ";


        return executeDML(sql,id);
    }

    /**
     * @description: 删除对象在数据库中对应的记录(对象所在的类对应到表，对象的主键的值对应到记录)
     * @param o 1
     * @return: int
     **/
    public int delete(Object o) {
        Class clazz = o.getClass();
        TableInfo tableInfo = TableContext.poClassTableInfoMap.get(clazz);
        ColumnInfo primaryColumn = tableInfo.getPrimaryKey();  //主键

        // 通过反射机制，调用属性对应的get方法或者set方法
        Object primaryKeyValue = ReflectUtils.invokeGet(primaryColumn.getName(),o);

        return delete(clazz,primaryKeyValue);
    }

    /**
     * @description: 更新对象指定字段的记录
     * @param o 1
     * @param fieldNames 2
     * @return: int
     **/
    public int update(Object o, String... fieldNames) {
        // UPDATE SET uname=?,create_time=1 WHERE id=1
        Class clazz = o.getClass();
        TableInfo tableInfo = TableContext.poClassTableInfoMap.get(clazz);
        StringBuilder sb = new StringBuilder("UPDATE "+tableInfo.getName()+" SET ");
        List<Object> params = new ArrayList<>();  //存储参数对象

        for(String fieldName:fieldNames){
            Object fieldValue = ReflectUtils.invokeGet(fieldName,o);
            params.add(fieldValue);
            sb.append(fieldName+"=?,");
        }
        sb.setCharAt(sb.length()-1,' ');
        sb.append("WHERE id=?");

        params.add(ReflectUtils.invokeGet(tableInfo.getPrimaryKey().getName(),o));

        return executeDML(sb.toString(),params.toArray());
    }

    /**
     * @description: 更新对象
     * @param o 1
     * @return: int
     **/
    public int update(Object o) {

        return 0;
    }

    /**
     * @description: 查询返回多行记录，返回list
     * @param sql 1 查询语句
     * @param clazz 2 封装数据的JavaBean
     * @param params 3 SQL参数
     * @return: java.util.List
     **/
    public List queryAll(Class clazz,String sql, Object... params) {
        List list = new ArrayList();
        executeQueryTemplate((connection,ps,rs)->{
            ResultSetMetaData rsMetaData = rs.getMetaData();
            while (rs.next()){
                Object rowObj = clazz.newInstance();

                // SELECT username,pwd FROM user WHERE id > ? AND age>18
                for (int i=0;i<rsMetaData.getColumnCount();i++){
                    String columnName = rsMetaData.getColumnLabel(i+1);
                    Object columnValue = rs.getObject(i+1);
                    if(columnValue!=null) {
                        ReflectUtils.invokeSet(rowObj, columnName, columnValue);
                    }
                }
                list.add(rowObj);
            }
            return list;
        },clazz,sql,params);
        return list;
    }

    /**
     * @description: 查询返回1行记录
     * @param sql 1 查询语句
     * @param clazz 2 封装数据的JavaBean
     * @param params 3 SQL参数
     * @return: java.lang.Object
     **/
    public Object queryOne(Class clazz,String sql,Object... params) {
        List list = queryAll(clazz,sql,params);
        return (list==null||list.size()==0)?null:list.get(0);
    }

    /**
     * @description: 查询返回1行记录的某一列
     * @param sql 1 查询语句
     * @param params 3 SQL参数
     * @return: java.lang.Object
     **/
    public Object queryValue(String sql, Object... params) {
        Connection connection = DBManager.getMYSQLConn();
        Object res = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try{
            ps = connection.prepareStatement(sql);
            JDBCUtils.handleParams(ps,params);

            rs = ps.executeQuery();
            ResultSetMetaData rsMetaData = rs.getMetaData();
            while (rs.next()){
                res=rs.getObject(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(ps,connection);
            return res;
        }
    }

    /**
     * @description: 查询返回1行记录的某一列
     * @param sql 1 查询语句
     * @param params 3 SQL参数
     * @return: java.lang.Object
     **/
    public Number queryNumber(String sql, Object... params) {
        return (Number) queryValue(sql, params);
    }
}
