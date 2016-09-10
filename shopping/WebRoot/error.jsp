<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String basePath=request.getContextPath(); 
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + basePath;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var i = 5;
	var timer;
	timer = setInterval(function(){
		i--;
		document.getElementById('mes').innerHTML = i;
		if(i == 0 ){
			clearTimeout(timer);
			timer = null
			
			window.top.location.href = "<%=path %>"; 
			
		}

	}, 1000);
</script>
</head>
<body>

	<h1>很遗憾，出错了.....</h1>
	<p>将在 <span id="mes">5</span> 秒钟后返回首页！</p>
	<p>如果没跳转，请<a href="<%=path %>">点击此处</a></p>
	
</body>
</html>