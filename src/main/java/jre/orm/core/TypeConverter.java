package jre.orm.core;

/**
 * @author liaowm5
 * @version 1.0
 * @description 负责Java数据类型和数据库数据类型的互相转换
 * @date 2019-02-23 08:19
 **/
public interface TypeConverter {

    /**
     * @description: 将数据库数据类型转化成Java的数据类型
     * @param dbType 1 数据库字段的数据类型
     * @return: java.lang.String Java数据类型
     **/
    public String dbType2JavaType(String dbType);

    /**
     * @description: 将Java数据类型转化成数据库数据类型
     * @param javaType 1 Java数据类型
     * @return: java.lang.String 数据库类型
     **/
    public String javaType2dbType(String javaType);
}
