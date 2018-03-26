<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <h1>添加商品</h1>
  
  <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="product.do" method="post">
				<div class="form-group">
					 <label for="exampleInputEmail1">所属类别</label>
				     <select name="category_id" >
				      <c:forEach items="${cates}" var="cate">
				       <option value="${cate.id }">${cate.name }</option>
				      </c:forEach>
				     </select>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">商品名称</label>
					 <input type="text" class="form-control" id="name" name="name" />
				</div>
			<div class="form-group">
					 <label for="exampleInputPassword1">商品标题</label>
					 <input type="text" class="form-control" id="subtitle" name="subtitle" />
				</div>
				
				<div class="form-group">
					 <label for="exampleInputPassword1">价格</label>
					 <input type="text" class="form-control" id="price" name="price" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">库存</label>
					 <input type="text" class="form-control" id="stock" name="stock" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">状态</label>
					  <select name="status" >
				      <option value="1">在售</option>
				       <option value="2">下架</option>
				      <option value="3">已删除</option>
				     </select>
					 
				</div>
				<input   type="hidden" name="operationtype" value="1"/>
				<button type="submit" class="btn btn-default">添加商品</button>
			</form>
		</div>
	</div>
</div>
   

</body>
</html>