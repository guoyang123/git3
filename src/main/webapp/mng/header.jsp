<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

                                                            
<h1>欢迎${user.name}登录！！！,<a href="${initParam.hostname}/Business/user/logout.do">退出登录</a></h1>

${cookie.token.value}


</body>
</html>