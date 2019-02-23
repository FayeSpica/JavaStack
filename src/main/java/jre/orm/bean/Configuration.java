package jre.orm.bean;

/**
 * @author liaowm5
 * @version 1.0
 * @description 管理配置信息
 * @date 2019-02-23 08:32
 **/
public class Configuration {
    //驱动类
    private String driver;
    //JDBC URL
    private String url;
    //数据库用户名
    private String user;
    //数据库密码
    private String passwd;
    //数据库
    private String db;
    //项目的源码路径
    private String srcPath;
    //扫描生成Java类的包
    private String poPackage;

    //执行查询使用的查询类
    private String queryClass;

    //数据库连接池对象
    private Integer jdbcPoolMax;
    private Integer jdbcPoolMin;

    public Configuration() {
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getPoPackage() {
        return poPackage;
    }

    public void setPoPackage(String poPackage) {
        this.poPackage = poPackage;
    }

    public String getQueryClass() {
        return queryClass;
    }

    public void setQueryClass(String queryClass) {
        this.queryClass = queryClass;
    }

    public Integer getJdbcPoolMax() {
        return jdbcPoolMax;
    }

    public void setJdbcPoolMax(Integer jdbcPoolMax) {
        this.jdbcPoolMax = jdbcPoolMax;
    }

    public Integer getJdbcPoolMin() {
        return jdbcPoolMin;
    }

    public void setJdbcPoolMin(Integer jdbcPoolMin) {
        this.jdbcPoolMin = jdbcPoolMin;
    }
}
