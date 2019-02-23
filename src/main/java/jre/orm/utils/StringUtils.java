package jre.orm.utils;

/**
 * @author liaowm5
 * @version 1.0
 * @description 封装了String常用的操作
 * @date 2019-02-23 08:26
 **/
public class StringUtils {
    /**
     * @description: 转化为驼峰式命名
     * @param str 1
     * @return: java.lang.String 
     **/
    public static String getCamelFormat(String str){
        return str.toUpperCase().substring(0,1)+str.substring(1);
    }
}
