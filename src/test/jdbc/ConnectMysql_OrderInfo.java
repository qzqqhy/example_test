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
 * @Description: 造供应数据
 * @Company www.viewhigh.com
 * @date 2016年7月6日 下午7:09:09
 */
public class ConnectMysql_OrderInfo {
    private static String insert_sql = "INSERT INTO `GB2B_SALEBUY` ( `title`, `product_id`, `product_name`,`trade_type`, `manufacturer`, `standard`, `start_date`, `end_date`, `content`, `validity`, `cust_id`, `company_name`, `oper_user`, `oper_time`, `add_user`, `add_date`, `is_commend`, `is_show`, `status`, `create_time`, `update_time`, `img_watermark`) SELECT rand_name(9),p.product_id,p.product_name,'0',rand_string(19),rand_string(9),UNIX_TIMESTAMP(NOW())*1000,UNIX_TIMESTAMP(NOW())*1000,'<p>测icheici</p>\n\n<p>&nbsp;车ice从策划国际电工委员会</p>\n\n<p>&nbsp;</p>\n\n<p>车icehei策划ieee</p>\n','1',?/*cust_id*/,?/*company_name*/,?/*oper_user*/,UNIX_TIMESTAMP(NOW())*1000,?/*add_user*/,UNIX_TIMESTAMP(NOW())*1000,'0','1','0',UNIX_TIMESTAMP(NOW())*1000,UNIX_TIMESTAMP(NOW())*1000,'0' FROM cp_prd_service_product p where id=?";

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
            for (int i = 0; i < 50; i++) {
                psts.setLong(1, Long.valueOf(v_company_id));
                psts.setString(2, v_company_name);
                psts.setString(3, v_id);
                psts.setString(4, v_id);
                psts.setInt(5, count + 1);
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
