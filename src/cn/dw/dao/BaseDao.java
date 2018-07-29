package cn.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.dw.utils.JdbcUtils;

//此类存放共性代码
public class BaseDao {

protected int  executeUpdate(String sql,Object[] param) {
	
	// TODO Auto-generated method stub
	JdbcUtils utils = new JdbcUtils(); 	
	Connection conn=null;
	conn=utils.getConnection();
	System.out.println(conn);
	PreparedStatement pre =null;
	
	try {
		pre=conn.prepareStatement(sql);
		for(int i=0;i<param.length;i++) {
			pre.setObject(i+1, param[i]);
		}
		return pre.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException();		
		}
		finally {
			System.out.println("无论是否抛出异常,此代码块都会执行,一般用来释放资源");
			try {
				pre.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
}
	
	

	
}
