package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ⹤����
 * @author Tedu
 *
 */
public class DBUtils {
	//���ڷ�װJDBC�����Ӳ���
	public static Connection getConn() throws Exception{
		//1)ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2)��ȡ���Ӷ���
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3", 
				"root", "201602054");
		return conn;
	}
	
	
}
