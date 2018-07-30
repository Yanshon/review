package cn.dw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dw.model.Product;
import cn.dw.service.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")// 可以接受前端请求的地址
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private  ProductService productService =new ProductService();    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();

    }
//只能用来处理get请求
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

//只能用阿里处理post请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("------doPost----");
		//1.获取前端的数据
		Product product =new Product();
		product.setName(request.getParameter("name"));
		product.setPrice(Double.parseDouble(request.getParameter("money")));
		product.setRemark(request.getParameter("remark"));
		//2.调用业务逻辑层
//		productService.save(product);
		int a=productService.save(product);
		System.out.println(a);
		//3.跳转到查询页面
		
	}

}
