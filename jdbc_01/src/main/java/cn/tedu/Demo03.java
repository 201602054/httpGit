package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * ������ɾ��:excuteUpdate(sql)
 * @author Tedu
 *
 */
public class Demo03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��������
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3", "root", "201602054");
		//����sql����
		Statement sta = conn.createStatement();
		//ִ��sql���
//		String sql="update emp set ename='TTTT' where empno=11";
//		sta.executeUpdate(sql);
		
// ��ѯ
		String sql="select ename,sal from emp";
		//��ѯ�Ľ����
		ResultSet rs = sta.executeQuery(sql);
		//���������
		while (rs.next()) {
			String name=rs.getString(1);//()�п������ֶε�����/�ֶε�����(��sql������ֶε�˳��)
			double sal=rs.getDouble("sal");
			System.out.println(name+":"+sal);
		}
		
		System.out.println("ִ�гɹ�!");
		//�ر���Դ
		sta.close();
		conn.close();
	}
}
