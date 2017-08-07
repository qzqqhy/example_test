package test.jdbc;

import test.bean.KjaTaskAnswer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: ConnectMysql.java
 * @Package test.jdbc
 * @Description: 造供应数据
 * @Company www.viewhigh.com
 * @date 2016年7月6日 下午7:09:09
 */
public class ConnectMysql_Dev_m_kja_task_Update {

    private static String update_sql = "update yzmm.m_kja_task set target_id=? where id=?";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        //doStore(1);
    }

    public static void doStore(List<KjaTaskAnswer> list) throws ClassNotFoundException, SQLException, IOException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DBUtils.getConnection();
        conn.setAutoCommit(false); // 设置手动提交  
        PreparedStatement psts = conn.prepareStatement(update_sql);
        long count = 0;
        long time = Math.toIntExact(new Date().getTime() / 1000);
        for (int i = 0; i < list.size(); i++) {
            KjaTaskAnswer kjaTaskAnswer = list.get(i);
            psts.setLong(1, kjaTaskAnswer.getTargetId());
            psts.setLong(2, kjaTaskAnswer.getTaskId());
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
