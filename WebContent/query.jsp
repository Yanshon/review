<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>查询商品页面</title>
</head>
<body>
	<form action="/Review_01/ProductServlet" method="get">
		商品名称:<input type="text" name="keyword"><br></br>
		<button type="submit">提交商品</button>
	</form>
	<table width=600 border="1">
		<tr>
			<th>编码</th>
			<th>名称</th>
			<th>价格</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
	
	<c:forEach items="${requestScope.proList}" var ="product">
	<tr>
	<td>${num.count}</td>
	<td>${product.name}</td>
	<td>${product.price}</td>
	<td>${product.remark}</td>	
	<td>删除|更新</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>
