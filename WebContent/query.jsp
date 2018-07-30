<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>添加商品页面</title>
</head>
<body>
	<form action="/Review_01/ProductServlet" method="post">

		商品名称:<input type="text" name="name"></input><br></br> 商品价格:<input
			type="text" name="money"></input><br></br> 商品备注:
		<textarea rows="5" cols="30" name="remark"></textarea>
		<br></br>
		<button type="submit">提交商品</button>

	</form>



</body>
</html>