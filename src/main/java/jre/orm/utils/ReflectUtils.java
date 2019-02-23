package jre.orm.utils;

import java.lang.reflect.Method;

/**
 * @author liaowm5
 * @version 1.0
 * @description 封装了反射常用操作
 * @date 2019-02-23 08:26
 **/
public class ReflectUtils {

    /**
     * @description: 调用obj对象对应属性filedName的get方法
     * @param fieldName 1
     * @param obj 2
     * @return: java.lang.Object
     **/
    public static Object invokeGet(String fieldName,Object obj){
        try {
            Class clazz = obj.getClass();
            Method method = clazz.getDeclaredMethod("get"+
                    StringUtils.getCamelFormat(fieldName),null);
            Object primaryKeyValue = method.invoke(obj,null);
            return primaryKeyValue;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @description: 调用obj对象对应属性filedName的set方法
     * @param fieldName 1
     * @param obj 2
     * @return: java.lang.Object
     **/
    public static void invokeSet(Object obj,String fieldName,Object value){
        try {
            Class clazz = obj.getClass();
            Method method = clazz.getDeclaredMethod("set"+
                     StringUtils.getCamelFormat(fieldName),value.getClass());
            method.invoke(obj,value);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
