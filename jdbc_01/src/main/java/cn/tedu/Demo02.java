package cn.tedu;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;

public class Demo02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3", "root", "201602054");
		//创建sql对象
		Statement sta = conn.createStatement();
		//执行sql语句
		String sql="drop table newdb4";//删除表
		sta.execute(sql);
		System.out.println("执行成功!");
		//关闭资源
		sta.close();
		conn.close();
	}
}
