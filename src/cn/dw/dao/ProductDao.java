package cn.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import com.mysql.jdbc.UpdatableResultSet;

import cn.dw.model.Product;
import cn.dw.utils.JdbcUtils;

public class ProductDao {
	
	public int update (Product product) {


		// ? 称为占位符
		String sql = "update product set name = ?,price = ?,remark = ? where id = ?";
		JdbcUtils jdbcUtils = new JdbcUtils();
		// 1: 获取数据库连接
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = jdbcUtils.getConnection();
			// 2: 通过connection对象生成预编译sql语句
			pre = conn.prepareStatement(sql);
			// 3: 给?赋值相应的参数(下标从1开始)
			pre.setString(1, product.getName());
			pre.setDouble(2, product.getPrice());
			pre.setString(3, product.getRemark());
			pre.setInt(4,product.getId());
			// 数据库 insert、update、delete都修改数据统称更新,此方法返回的是更新的行数
			return pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			System.out.println("无论是否抛出异常,此代码块都会执行,一般用来释放资源");
			// 4: 完成数据库连接关闭操作
			try {
				pre.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	
	
		
		
	}
	
	public int delete(int id) {

		// ? 称为占位符
		String sql = "delete from product where id = ?";
		JdbcUtils jdbcUtils = new JdbcUtils();
		// 1: 获取数据库连接
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = jdbcUtils.getConnection();
			// 2: 通过connection对象生成预编译sql语句
			pre = conn.prepareStatement(sql);
			// 3: 给?赋值相应的参数(下标从1开始)
//			pre.setString(1, product.getName());
//			pre.setDouble(2, product.getPrice());
//			pre.setString(3, product.getRemark());
			pre.setInt(1, id);
			// 数据库 insert、update、delete都修改数据统称更新,此方法返回的是更新的行数
			return pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			System.out.println("无论是否抛出异常,此代码块都会执行,一般用来释放资源");
			// 4: 完成数据库连接关闭操作
			try {
				pre.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	
	}
	
	
	public int save (Product product) {
		
		JdbcUtils utils = new JdbcUtils(); 	
		Connection conn=null;
		conn=utils.getConnection();
		System.out.println(conn);
		PreparedStatement pre =null;
		
		String sql ="insert into product (name,price,remark) values (?,?,?)";
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,product.getName());
			pre.setDouble(2,product.getPrice());
			pre.setString(3,product.getRemark());
			return pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();		
			}

			finally {
				try {
					pre.close();
					conn.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
	}

	
	public static void main(String[] args) {
		Product product = new Product();
		product.setName("笔记本电脑");
		product.setPrice(4500.00);
		product.setRemark("商品备注！");
		ProductDao dao = new ProductDao();
		int result = dao.save(product);
		System.out.println("result:" + result);
//		int result2 = dao.delete(2);
//		System.out.println("result:" + result2);
		Product product2 = new Product();
		product2.setName("苹果手机");
		product2.setPrice(9000.00);
		product2.setRemark("更新");
		product2.setId(3);
		int result3 = dao.update(product2);
		System.out.println("result:" + result3);
		
		
		
		
		
	}
}
