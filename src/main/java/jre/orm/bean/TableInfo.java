package jre.orm.bean;

import jre.orm.core.TableContext;

import java.util.List;
import java.util.Map;

/**
 * @author liaowm5
 * @version 1.0
 * @description 存储表结构的信息
 * @date 2019-02-23 08:32
 **/
public class TableInfo {

    //表名
    private String name;

    //所有字段的信息
    private Map<String,ColumnInfo> columns;

    //主键
    private ColumnInfo primaryKey;

    //联合主键
    private List<ColumnInfo> primaryKeys;

    public Map<Class,TableInfo> poClassTableInfoMap;

    public TableInfo() {
    }

    public TableInfo(String name, Map<String, ColumnInfo> columns, ColumnInfo primaryKey, List<ColumnInfo> primaryKeys, Map<Class, TableInfo> poClassTableInfoMap) {
        this.name = name;
        this.columns = columns;
        this.primaryKey = primaryKey;
        this.primaryKeys = primaryKeys;
        this.poClassTableInfoMap = poClassTableInfoMap;
    }

    public TableInfo(String name, Map<String, ColumnInfo> columns, ColumnInfo primaryKey) {
        this.name = name;
        this.columns = columns;
        this.primaryKey = primaryKey;
    }

    public TableInfo(String name, Map<String, ColumnInfo> columns, List<ColumnInfo> primaryKeys) {
        this.name = name;
        this.columns = columns;
        this.primaryKeys = primaryKeys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, ColumnInfo> columns) {
        this.columns = columns;
    }

    public ColumnInfo getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ColumnInfo primaryKey) {
        this.primaryKey = primaryKey;
    }

    public List<ColumnInfo> getPrimaryKeys() {
        return primaryKeys;
    }

    public void setPrimaryKeys(List<ColumnInfo> primaryKeys) {
        this.primaryKeys = primaryKeys;
    }
}
