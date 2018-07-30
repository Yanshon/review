package cn.dw.service;

import java.util.ArrayList;

import cn.dw.dao.ProductDao;
import cn.dw.model.Product;
//业务逻辑 --> 数据访问层
public class ProductService {

	ProductDao productDao=new ProductDao();	
	
	public ArrayList<Product> queryByName(String keyword){
		return productDao.queryByName(keyword);
		}
		
		public int save (Product product) {
			return productDao.save(product);
			
		}

	
}
