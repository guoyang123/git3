<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  
  <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column"> 
			<form role="form" action="user/login" method="post">
				<div class="form-group">
					 <label for="exampleInputEmail1">用户名</label><input type="text" name="username" class="form-control" id="username"  />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">密码</label><input type="password" name="password" class="form-control" id="password" />
				</div>
				
			<button type="submit" class="btn btn-default">登录</button>
			</form>
		</div>
	</div>
</div>

</body>
</html>