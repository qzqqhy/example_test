package test.jdbc;

import java.io.IOException;
import java.sql.*;


/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: ConnectMysql.java
 * @Package test.jdbc
 * @Description: 造供应数据
 * @Company www.viewhigh.com
 * @date 2016年7月6日 下午7:09:09
 */
public class ConnectMysql_Dev_Update {
    private static String insert_sql = "update yzmm.m_kja_task_answer set task_id=FLOOR((RAND() * 132)) where id=?";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        doStore();
    }

    private static void doStore() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DBUtils.getConnection();
        conn.setAutoCommit(false); // 设置手动提交  
        int count = 0;
        PreparedStatement psts = conn.prepareStatement(insert_sql);

        for (int i = 1; i <= 577; i++) {
            psts.setInt(1, i);
            boolean b = psts.execute();
            conn.commit();  // 提交
            if (b) {
                count++;
            }
        }


        System.out.println("All down : " + count);
        conn.close();
    }

}
