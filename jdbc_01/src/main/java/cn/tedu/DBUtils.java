package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 * @author Tedu
 *
 */
public class DBUtils {
	//用于封装JDBC的连接操作
	public static Connection getConn() throws Exception{
		//1)注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2)获取连接对象
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3", 
				"root", "201602054");
		return conn;
	}
	
	
}
