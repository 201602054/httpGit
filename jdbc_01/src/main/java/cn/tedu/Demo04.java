package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class Demo04 {
	/*@ ע��,����@Test(ע�ⷽ��)�Ϳ���ִ��,��:��Ԫ����
	 * ���ָ�ŷ�����,�һ����и÷���,�հ״����е������еķ���
	 * */
	@Test
	public void insert() {
		try(Connection conn = DBUtils.getConn()) {//��Դ�Զ��ر�
			//����sql�Ķ���
			Statement sta=conn.createStatement();
			String sql="insert into emp(empno,ename) values(101,'Lucy')";
			//ִ��sql
			sta.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void update() {
		try(Connection conn = DBUtils.getConn()) {
			Statement sta=conn.createStatement();
			String sql="update emp set ename='Hanmeimei' where empno=101";
			sta.executeUpdate(sql);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void delete() {
		try (Connection conn = DBUtils.getConn()){
			Statement sta = conn.createStatement();
			String sql="delete from emp where empno=101";
			sta.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void select() {
		try (Connection conn = DBUtils.getConn()){
			Statement sta = conn.createStatement();
			String sql="select ename from emp";
			ResultSet rs = sta.executeQuery(sql);
			//����
			while (rs.next()) {
				String name=rs.getString(1);
				System.out.println(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
