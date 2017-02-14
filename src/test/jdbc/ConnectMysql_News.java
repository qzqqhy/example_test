package test.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


/**
 * @Title: ConnectMysql.java
 * @Package test.jdbc
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhongqiang.qiu
 * @Company www.viewhigh.com
 * @date 2016年7月6日 下午7:09:09
 * @version V1.0
 */
public class ConnectMysql_News {
    private static String insert_sql = "INSERT INTO GB2B_NEWS    (title,`type`,news_type,class_id,class_name,news_src,content,news_abstract,news_img,cancomments,validity,cust_id,cust_name,oper_user,oper_time,add_user,add_date,is_commend,img_watermark,`status`,create_time,update_time,is_show)VALUES (rand_string(9),0,0,?/*class_id*/,?/*class_name*/,'www.baidu.com','<p>aaaaa</p>','aaaaaaaaa','http://img.yhrp.ucrl.net/webdemo/7a11f4eb47bd4ea3b68cb60917bd36dd.jpg',1,1,?/*cust_id*/,?/*cust_name*/,?/*oper_user*/,UNIX_TIMESTAMP(NOW()),?/*add_user*/,UNIX_TIMESTAMP(NOW()),1,0,0,"+new Date().getTime()+",UNIX_TIMESTAMP(NOW()),1)";
    //100102,100103,100115,100107,100113,100112,100114,
    private static Integer classIds[]={100117, 100116};
//    "行业热点","市场研究","政策解读","互联网医疗","商家动态","产品动态","招标信息",
    private static String classNames[]={"处罚","表扬"};
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
        String sql = "select * from gb2b_user limit 0,10";
        ResultSet rs = statement.executeQuery(sql);
        String v_company_id;
        String v_id;
        String v_company_name;
        while (rs.next()) {
            v_company_id = rs.getString("company_id");
            v_id=rs.getString("id");
            v_company_name=rs.getString("company_name");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < classNames.length; j++) {
                    psts.setLong(1, classIds[j]);
                    psts.setString(2, classNames[j]);
                    psts.setString(3, v_company_id);
                    psts.setString(4, v_company_name);
                    psts.setString(5, v_id);  
                    psts.setString(6, v_id);  
                    psts.addBatch();          // 加入批量处理  
                    count++;              
                }
            }
        }  
        psts.executeBatch(); // 执行批量处理  
        conn.commit();  // 提交  
        System.out.println("All down : " + count);  
        conn.close();  
    }
  
}