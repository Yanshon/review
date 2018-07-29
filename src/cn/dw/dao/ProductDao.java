package cn.dw.dao;

import java.io.DataOutput;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import javax.print.attribute.standard.RequestingUserName;

import com.mysql.jdbc.UpdatableResultSet;

import cn.dw.model.Product;
import cn.dw.utils.JdbcUtils;

public class ProductDao extends BaseDao{
	
	public int update (Product product) {
		// ? 称为占位符
		String sql = "update product set name = ?,price = ?,remark = ? where id = ?";
		int result=super.executeUpdate(sql,new Object[] {product.getName(),product.getPrice(),product.getRemark(),product.getId()});
		return result;
	}
	
	public int delete(int id) {

		// ? 称为占位符
		String sql = "delete from product where id = ?";
		int result=super.executeUpdate(sql, new Object[] {id});
		return result;
	}
	
	
	public int save (Product product) {

		
		String sql ="insert into product (name,price,remark) values (?,?,?)";
		int result = super.executeUpdate(sql, new Object[] {
		product.getName(),product.getPrice(),product.getRemark() } );
		return result;
	}

	
	public static void main(String[] args) {
		ProductDao Dao = new ProductDao();
//		int result = Dao.delete(3);
//		System.out.println(result);
//		Product product = new Product();
//		product.setName("插入1");
//		product.setPrice(2400.00);
//		product.setRemark("插入备注");
//		int result2=Dao.save(product);
//		System.out.println(result2);
		Product product2 = new Product();
		product2.setName("插入2");
		product2.setPrice(1100.00);
		product2.setRemark("插入备注2");
		product2.setId(16);
		int result3=Dao.update(product2);
		System.out.println(result3);
//		Product product = new Product();
//		product.setName("笔记本电脑");
//		product.setPrice(4500.00);
//		product.setRemark("商品备注！");
//		ProductDao dao = new ProductDao();
//		int result = dao.save(product);
//		System.out.println("result:" + result);
////		int result2 = dao.delete(2);
////		System.out.println("result:" + result2);
//		Product product2 = new Product();
//		product2.setName("苹果手机");
//		product2.setPrice(9000.00);
//		product2.setRemark("更新");
//		product2.setId(3);
//		int result3 = dao.update(product2);
//		System.out.println("result:" + result3);
		
		
		
		
		
	}
}
