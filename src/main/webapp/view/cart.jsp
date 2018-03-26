<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
 <h1>购物车列表</h1>
 
   
   
   

	<table>
		<tr>
			<th>商品编号</th>
			<th>用户名称</th>
			<th>商品名称</th>
			<th>商品数量</th>
			<th>是否选中</th>
			<th>添加时间</th>
			<th>更新时间</th>
			<th>用户操作</th>
		</tr>
		
      
		  
		<c:forEach items="${pageModel.data}" var="cart">
   
			<tr>
				<td>${cart.id}</td>
				<td>${cart.user.name}</td>		
				<td>${cart.product_id}</td>		
				<td>${cart.quantity}</td>		
				<td>${cart.checked}</td>		
				<td>${cart.create_time}</td>		
				<td>${cart.update_time}</td>
							
				<td>
				 <a href="#">删除</a> 
				 <a href="#">修改</a>
				
				</td>
			</tr>
		</c:forEach>
	</table>
    
    <c:forEach  var="pageNo" begin="1" end="${pageModel.totalPage}"  step="1">
     
      <a href="cart.do?operationtype=2&pageNo=${pageNo }&pageSize=10">${pageNo}</a>
     
    </c:forEach>
     

   
 
</body>
</html>