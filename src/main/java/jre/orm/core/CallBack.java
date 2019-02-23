package jre.orm.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author liaowm5
 * @version 1.0
 * @description 回调接口
 * @date 2019-02-23 16:58
 **/
public interface CallBack {
    public List execute(Connection connection, PreparedStatement ps, ResultSet rs) throws Exception;
}
