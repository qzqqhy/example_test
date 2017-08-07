package test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: DBUtils.java
 * @Package test.jdbc
 * @Description: TODO(用一句话描述该文件做什么)
 * @Company www.viewhigh.com
 * @date 2016年7月6日 下午7:08:16
 */
public class DBUtils {
    private static String url = "jdbc:mysql://rm-2zea3kd81a8o6kg6ho.mysql.rds.aliyuncs.com:3306/yzmm?characterEncoding=utf8";
    private static String user = "root";
    private static String psw = "Sevenkids123";

    private static Connection conn;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private DBUtils() {

    }

    /**
     * 获取数据库的连接
     *
     * @return conn
     */
    public static Connection getConnection() {
        if (null == conn) {
            try {
                conn = DriverManager.getConnection(url, user, psw);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return conn;
    }

    /**
     * 释放资源
     *
     * @param conn
     * @param pstmt
     * @param rs
     */
    public static void closeResources(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                if (null != pstmt) {
                    try {
                        pstmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    } finally {
                        if (null != conn) {
                            try {
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }
    }
}
