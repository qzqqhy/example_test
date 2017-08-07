package test.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: ConnectMysql.java
 * @Package test.jdbc
 * @Description: 造求购数据
 * @Company www.viewhigh.com
 * @date 2016年7月6日 下午7:09:09
 */
public class ConnectMysql {
    private static String insert_sql = "INSERT INTO gb2b_salebuy(title,trade_type,manufacturer,standard,start_date,end_date,content,validity,cust_id,company_name,oper_user,oper_time,add_date,is_commend,is_show,`status`,create_time,update_time,img_watermark) VALUES(rand_string(9),1,rand_string(25),rand_string(9),UNIX_TIMESTAMP(NOW()),UNIX_TIMESTAMP(DATE_ADD(NOW(),INTERVAL 1 MONTH)),CONCAT('<p>',rand_string(25),'</p>'),1,?,?,?,UNIX_TIMESTAMP(NOW()),1,1,0,0,UNIX_TIMESTAMP(NOW()),UNIX_TIMESTAMP(NOW()),0)";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        doStore();
    }

    private static void doStore() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DBUtils.getConnection();
        conn.setAutoCommit(false); // 设置手动提交  
        int count = 0;
        PreparedStatement psts = conn.prepareStatement(insert_sql);
        Statement statement = conn.createStatement();
        String sql = "select * from gb2b_user";
        ResultSet rs = statement.executeQuery(sql);
        String v_company_id;
        String v_id;
        String v_company_name;
        while (rs.next()) {
            v_company_id = rs.getString("company_id");
            v_id = rs.getString("id");
            v_company_name = rs.getString("company_name");
            for (int i = 0; i < 25; i++) {
                psts.setLong(1, Long.valueOf(v_company_id));
                psts.setString(2, v_company_name);
                psts.setString(3, v_id);
                psts.addBatch();          // 加入批量处理  
                count++;
            }
        }
        psts.executeBatch(); // 执行批量处理  
        conn.commit();  // 提交  
        System.out.println("All down : " + count);
        conn.close();
    }

}
