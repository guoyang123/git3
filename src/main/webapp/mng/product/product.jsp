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
 <h1>商品列表</h1>
 
   
   
   <a href="product.do?operationtype=1">添加商品</a>

	<table>
		<tr>
			<th>商品编号</th>
			<th>所属类别</th>
			<th>商品名称</th>
			<th>标题</th>
			<th>价格</th>
			<th>库存</th>
			<th>状态</th>
			<th>添加时间</th>
			<th>用户操作</th>
		</tr>
		<c:forEach items="${pageModel.data}" var="pro">
  
			<tr>
				<td>${pro.id}</td>
				<td>${pro.category_id}</td>		
				<td>${pro.name}</td>		
				<td>${pro.subtitle}</td>		
				<td>${pro.price}</td>		
				<td>${pro.stock}</td>		
				<td>${pro.status}</td>
				<td>${pro.create_time}</td>					
				<td>
				 <a href="delemp.do?empno=${emp.empno}">删除</a> 
				 <a href="update.do?empno=${emp.empno}">修改</a>
				 <a href="#">添加到购物车</a>
				</td>
			</tr>
		</c:forEach>
	</table>
    
    <c:forEach  var="pageNo" begin="1" end="${pageModel.totalPage}"  step="1">
     
      <a href="empbypage.do?pageNo=${pageNo}">${pageNo}</a>
     
    </c:forEach>
     

   
 
</body>
</html>