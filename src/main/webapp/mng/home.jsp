<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品后台管理页面</title>
</head>
<frameset  rows="20%,60%,20%" frameborder="no">
   <frame  src="header.jsp"/>
    <frameset cols="30%,70%">
      <frame src="menu.jsp"/>
      <frame name="content" src="product/product.jsp"/>
    </frameset>
    <frame src="footer.jsp"/>
 
</frameset>
</html>