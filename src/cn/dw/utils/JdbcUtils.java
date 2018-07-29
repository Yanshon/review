package cn.dw.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

	private static JdbcUtils utils3;


	static {
		System.out.println("---------static--------");
		try {
			System.out.println("1");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("2");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("3");
			throw new RuntimeException();		}
	
		
	}
	
	public Connection getConnection() {
		
		try {
			System.out.println("4");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("5");
			throw new RuntimeException();	
		}
	}
	
	
	public static void main (String[] agrs) {		
		JdbcUtils utils = new JdbcUtils(); 	
		Connection conn=null;
		conn=utils.getConnection();
		System.out.println(conn);		
	}
	
}
