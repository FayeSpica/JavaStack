package jre.orm.core;

/**
 * @author liaowm5
 * @version 1.0
 * @description MySQL<--->Java类型转换
 * @date 2019-02-23 09:39
 **/
public class MySQLTypeConverter implements TypeConverter{
    private static MySQLTypeConverter instance = new MySQLTypeConverter();

    private MySQLTypeConverter(){

    }

    public static MySQLTypeConverter getInstance(){
        return instance;
    }

    @Override
    public String dbType2JavaType(String dbType) {
        switch (dbType.toUpperCase()){
            case "VARCHAR":
            case "CHAR":
                return "String";
            case "INT":
            case "TINYINT":
            case "SMALLINT":
            case "INTEGER":
                return "Integer";
            case "BIGINT":
                return "Long";
            case "DOUBLE":
            case "FLOAT":
                return "Double";
            case "CLOB":
                return "java.sql.Clob";
            case "BLOB":
                return "java.sql.Blob";
            case "DATE":
                return "java.sql.Date";
            case "TIME":
                return "java.sql.Time";
            case "TIMESTAMP":
                return "java.sql.Timestamp";
            default:
                return "";
        }
    }

    @Override
    public String javaType2dbType(String javaType) {
        return null;
    }
}
