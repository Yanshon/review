package cn.dw.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1:获取查询的关键字keyword
		String keyword =request.getParameter("keyword");
		//2:调用业务逻辑（此处不需要添加%%）
		ArrayList<Product> proList =new ArrayList<Product>();
		proList=productService.queryByName(keyword);
		
		request.setAttribute("proList",proList);
//		for (Product temp:proList) {
//			System.out.println(temp);
//		//3:跳转查询页面,然后显示数据
//		response.sendRedirect(request.getContextPath()+"/query.jsp");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/query.jsp");
		dispatcher.forward(request, response);
		
	}
		


//只能用来处理post请求
//request：
//response：
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
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
		response.sendRedirect(request.getContextPath()+"/query.jsp");
	}

}
