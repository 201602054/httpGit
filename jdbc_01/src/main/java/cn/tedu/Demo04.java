package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class Demo04 {
	/*@ 注解,加入@Test(注解方法)就可以执行,即:单元测试
	 * 鼠标指着方法名,右击运行该方法,空白处运行的是所有的方法
	 * */
	@Test
	public void insert() {
		try(Connection conn = DBUtils.getConn()) {//资源自动关闭
			//创建sql的对象
			Statement sta=conn.createStatement();
			String sql="insert into emp(empno,ename) values(101,'Lucy')";
			//执行sql
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
			//遍历
			while (rs.next()) {
				String name=rs.getString(1);
				System.out.println(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
