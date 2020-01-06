package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 测试增删改:excuteUpdate(sql)
 * @author Tedu
 *
 */
public class Demo03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3", "root", "201602054");
		//创建sql对象
		Statement sta = conn.createStatement();
		//执行sql语句
//		String sql="update emp set ename='TTTT' where empno=11";
//		sta.executeUpdate(sql);
		
// 查询
		String sql="select ename,sal from emp";
		//查询的结果集
		ResultSet rs = sta.executeQuery(sql);
		//遍历结果集
		while (rs.next()) {
			String name=rs.getString(1);//()中可以是字段的名字/字段的索引(在sql语句中字段的顺序)
			double sal=rs.getDouble("sal");
			System.out.println(name+":"+sal);
		}
		
		System.out.println("执行成功!");
		//关闭资源
		sta.close();
		conn.close();
	}
}
