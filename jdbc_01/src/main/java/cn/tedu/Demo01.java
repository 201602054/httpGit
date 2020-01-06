package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1)注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2)获取连接对象
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3", 
				"root", "201602054");
		System.out.println(conn);
		//3)创建sql执行对象
		Statement sta = conn.createStatement();
		//4)执行sql语句
		String sql="select * from dept";
		ResultSet rs = sta.executeQuery(sql);
		
		/*String sql1="create table newdb4"+"(id int primary key,name varchar(10))";
		sta.execute(sql1);		*/
		
		List<Newdb3_dept> list=new ArrayList<Newdb3_dept>();//Newdb3_dept是数据库中的表的分装类
		while (rs.next()) {
			Newdb3_dept dept=new Newdb3_dept();
			dept.setDeptno(rs.getInt("DEPTNO"));
			dept.setDname(rs.getString("DNAME"));
			dept.setLoc(rs.getString("LOC"));
			list.add(dept);
		}
		System.out.println(list);
		//5)关闭资源
		rs.close();
		sta.close();
		conn.close();
		
	}
}
