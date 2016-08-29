<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/style.css" />
		<title>用户登录</title>

	<script type="text/javascript">		 
		function refresh()
        {
            var img = document.getElementById("img_validation_code")
            img.src = "validate_code.action?" + Math.random();            
        }
		 
	</script>		
	</head>
	<body>	  
		<center>
		
			<div
				style="margin-top: 20px; margin-left: 20px; font-size: 20px; height: 50px">
				用户登录界面
			</div>
			如果您还没注册，单击此处<a href="register_page.action">注册</a>
			<FONT color="red"><s:actionerror/></FONT>
			<s:form action="login" >
				<s:textfield label="用户名"  cssClass="input_list" name="user" />
				<s:password label="密码" name="password" cssClass="input_list" />
				<s:textfield label="验证码" name="validationCode" 
					cssClass="input_list" />
				<s:submit value="登录" />
			</s:form> 
			
			用户验证码：<img id="img_validation_code" src="validate_code.action"/>
			<a href="#" onClick="refresh()">重新获得验证码</a>
			
		</center>

	</body>
</html>
