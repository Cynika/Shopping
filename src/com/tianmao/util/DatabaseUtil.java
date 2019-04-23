
package com.tianmao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 数据库工具类，帮助获取到对应数据库的连接和关闭连接
 *
 * @author Anna
 */
public class DatabaseUtil {

    private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QDU";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "sa";

    private static final String DRIVER_CLASS2 = "com.mysql.jdbc.Driver";
    private static final String URL2 = "jdbc:mysql://cd-cdb-o3v1sjms.sql.tencentcdb.com:63142/QDU";
    private static final String USERNAME2 = "root";
    private static final String PASSWORD2 = "tgs123456@";


    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_CLASS2);
            DriverManager.setLoginTimeout(5);
            return DriverManager.getConnection(URL2, USERNAME2, PASSWORD2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
        try {
            if (null != rs) rs.close();
            if (null != ps) ps.close();
            if (null != con) con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
