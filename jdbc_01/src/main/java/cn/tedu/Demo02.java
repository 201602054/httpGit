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
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��������
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3", "root", "201602054");
		//����sql����
		Statement sta = conn.createStatement();
		//ִ��sql���
		String sql="drop table newdb4";//ɾ����
		sta.execute(sql);
		System.out.println("ִ�гɹ�!");
		//�ر���Դ
		sta.close();
		conn.close();
	}
}
