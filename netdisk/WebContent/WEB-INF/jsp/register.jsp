<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>用户注册</title>
		<link type="text/css" rel="stylesheet" href="css/style.css" />
		<s:head theme="ajax" />
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
		<div style="margin-top: 20px; margin-left: 20px; font-size: 20px; height: 50px">
				用户注册界面
		</div>
		单击此处<a href="login_page.action">登录</a>
			<FONT color="red"><s:actionerror /> </FONT>
			<s:form action="register">
				<s:textfield label="用户名" cssClass="input_list" name="user"
					required="true" value="" />
				<s:password label="密码" name="password" cssClass="input_list"
					required="true" />
				<s:password label="请再次输入密码" name="repassword" cssClass="input_list"
					required="true" />
				<s:textfield label="姓名" cssClass="input_list" name="xm"
					 value="" />
				<s:textfield label="邮箱地址" name="email" cssClass="input_list"
					 value="" />
				<s:textfield label="电话" cssClass="input_list" name="phone" value="" />
				<s:textfield label="QQ" cssClass="input_list" name="qq" value="" />

				<s:textfield label="验证码" name="validationCode" cssClass="input_list"
					required="true" value="" />
				<s:submit value="注册" />
			</s:form>
			用户验证码：
			<img id="img_validation_code" src="validate_code.action" />
			<a href="#" onClick="refresh()">重新获得验证码</a>			
		</center>
	</body>
</html>
