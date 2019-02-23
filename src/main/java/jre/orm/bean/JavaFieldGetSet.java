package jre.orm.bean;

/**
 * @author liaowm5
 * @version 1.0
 * @description 封装了Java属性和get、set方法的源代码
 * @date 2019-02-23 09:50
 **/
public class JavaFieldGetSet {
    //属性的源码信息
    private String fieldInfo;

    //get方法的源码信息，如 public int getUserId(){}
    private String getInfo;

    //set方法的源码信息，如 public void setUserId(int id){this.id = id}
    private String setInfo;

    public JavaFieldGetSet() {
    }

    public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
        this.fieldInfo = fieldInfo;
        this.getInfo = getInfo;
        this.setInfo = setInfo;
    }

    public String getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(String fieldInfo) {
        this.fieldInfo = fieldInfo;
    }

    public String getGetInfo() {
        return getInfo;
    }

    public void setGetInfo(String getInfo) {
        this.getInfo = getInfo;
    }

    public String getSetInfo() {
        return setInfo;
    }

    public void setSetInfo(String setInfo) {
        this.setInfo = setInfo;
    }

    @Override
    public String toString() {
        return "JavaFieldGetSet{" +
                "fieldInfo='" + fieldInfo + '\'' +
                ", getInfo='" + getInfo + '\'' +
                ", setInfo='" + setInfo + '\'' +
                '}';
    }
}
