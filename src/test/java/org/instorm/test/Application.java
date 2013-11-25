package org.instorm.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class Application {

	@Bean
	MessageService mockMessageService() {
		return new MessageService() {
			public String getMessage() {
				return "Hello World!";
			}
		};
	}
	@Test
	public void testSpring() {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				Application.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
	}
	@Test
	public void testOracle(){
		try {
			String result = "";
			String sql = "select * from t_pm_user"; 
			String url ="jdbc:oracle:thin:@192.168.0.3:1521:orcl";
			String username = "scott"; // 用户名
			String password = "tiger"; //密码
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
			Connection conn =DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while ( rs.next() )
			{
				result += "\n 第一个字段内容：" +rs.getString(0) + "<BR>";
			}
			rs.close(); // 关闭结果集
			stmt.close(); // 关闭执行语句对象
			conn.close(); // 关闭与数据库的连接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
