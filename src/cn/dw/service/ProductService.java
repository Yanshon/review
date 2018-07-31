package cn.dw.service;

import java.util.ArrayList;

import cn.dw.dao.ProductDao;
import cn.dw.model.Product;
//业务逻辑 --> 数据访问层
public class ProductService {

	ProductDao productDao = new ProductDao();

	public ArrayList<Product> queryByName(String keyword) {
		return productDao.queryByName(keyword);
	}

	public int save(Product product) {
		return productDao.save(product);

	}

	public int delete(int id) {
		return productDao.delete(id);
	}

	public Product getById(int id) {
		return productDao.getById(id);
	}

	public int update(Product product) {
		return productDao.update(product);
	}
}
