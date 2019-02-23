package jre.orm.core;

import com.mysql.cj.xdevapi.Table;
import jre.orm.bean.ColumnInfo;
import jre.orm.bean.JavaFieldGetSet;
import jre.orm.bean.KeyType;
import jre.orm.bean.TableInfo;
import jre.orm.utils.StringUtils;
import sun.tools.jconsole.Tab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jre.orm.utils.JavaFileUtils.*;

/**
 * @author liaowm5
 * @version 1.0
 * @description 负责获取管理数据库所有表结构和类结构的关系，并可以根据表结构生成类结构。
 * @date 2019-02-23 08:24
 **/
public class TableContext {

    //表名为key，表信息对象为value
    public static Map<String, TableInfo> tables = new HashMap<>();

    //将po的class对象和表信息对象关联起来
    public static Map<Class,TableInfo> poClassTableInfoMap = new HashMap<>();

    private TableContext(){

    }

    static {
        try{
            Connection con = DBManager.getMYSQLConn();
            DatabaseMetaData dbMetaData = con.getMetaData();
            System.out.println(con.getCatalog());
            System.out.println(con.getSchema());
            System.out.println(dbMetaData.getDriverName());
            System.out.println(dbMetaData.getURL());
            System.out.println(dbMetaData.getUserName());
            ResultSet tableSet = dbMetaData.getTables(con.getCatalog(),"%","%",new String[]{"TABLE"});

            while (tableSet.next()){
                String tableName = (String) tableSet.getObject("TABLE_NAME");
                System.out.println(tableName);
                System.out.println(tableSet);
                TableInfo tableInfo = new TableInfo(tableName,new HashMap<>()
                        ,new ArrayList<>());
                tables.put(tableName,tableInfo);

                ResultSet columnSet = dbMetaData.getColumns(con.getCatalog(),con.getSchema(),tableName,null);
                while (columnSet.next()){
                    ColumnInfo columnInfo = new ColumnInfo(columnSet.getString("COLUMN_NAME")
                    ,columnSet.getString("TYPE_NAME"), KeyType.NORMAL);
                    tableInfo.getColumns().put(columnInfo.getName(),columnInfo);
                    System.out.println(columnInfo.getName());
                }

                ResultSet pkSet = dbMetaData.getPrimaryKeys(con.getCatalog(),con.getSchema(),tableName);
                while (pkSet.next()){
                    ColumnInfo columnInfo =(ColumnInfo) tableInfo.getColumns().get(pkSet.getObject("COLUMN_NAME"));
                    if(columnInfo!=null)columnInfo.setKeyType(KeyType.PRIMARY_KEY);
                    tableInfo.getPrimaryKeys().add(columnInfo);
                }

                if(tableInfo.getPrimaryKeys().size()>0){
                    tableInfo.setPrimaryKey(tableInfo.getPrimaryKeys().get(0));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //更新类结构
        updateJavaPOFile();

        //加载po包下面所有的类，便于重用，提高效率！
        loadPOTables();
    }

    public static Map<String, TableInfo> getTables() {
        return tables;
    }

    /**
     * @description: 重新生成persistent object class
     * @return: void
     **/
    public static void updateJavaPOFile(){
        for(TableInfo tableInfo:TableContext.tables.values()){
            createJavaPOFile(tableInfo,MySQLTypeConverter.getInstance());
        }
    }


    /**
     * @description: 加载po包下的类
     * @return: void
     **/
    public static void loadPOTables(){

        for (TableInfo tableInfo:tables.values()){
            try{
                Class clazz = Class.forName(DBManager.getConf().getPoPackage()+"."+
                        StringUtils.getCamelFormat(tableInfo.getName()));
                poClassTableInfoMap.put(clazz,tableInfo);
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args){
        Map<String,TableInfo> tables = TableContext.tables;
        System.out.println(tables);
    }
}
