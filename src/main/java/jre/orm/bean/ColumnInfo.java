package jre.orm.bean;

/**
 * @author liaowm5
 * @version 1.0
 * @description 封装表中一个字段的信息
 * @date 2019-02-23 08:27
 **/
public class ColumnInfo {
    //字段名称
    private String name;

    //字段的数据类型
    private String dataType;

    //字段的键类型
    private KeyType keyType;

    public ColumnInfo() {
    }

    public ColumnInfo(String name, String dataType, KeyType keyType) {
        this.name = name;
        this.dataType = dataType;
        this.keyType = keyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public KeyType getKeyType() {
        return keyType;
    }

    public void setKeyType(KeyType keyType) {
        this.keyType = keyType;
    }
}


