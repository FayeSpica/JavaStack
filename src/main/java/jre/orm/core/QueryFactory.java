package jre.orm.core;

/**
 * @author liaowm5
 * @version 1.0
 * @description 创建Query对象的工厂类
 * @date 2019-02-23 08:19
 **/
public class QueryFactory {
    private static QueryFactory factory = new QueryFactory();

    private static Query prototypeObj;  //原型对象

    static {
        try {
            Class clazz = Class.forName(DBManager.getConf().getQueryClass());
            prototypeObj = (Query) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private QueryFactory(){

    }

    public Query createQuery(){
        try {
            return (Query) prototypeObj.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }finally {
            return null;
        }
    }
}
