<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>课程介绍</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/css.css" type="text/css" rel="stylesheet">	
	<SCRIPT src="js/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
	<SCRIPT src="js/base.js" type=text/javascript></SCRIPT>
	  <style type="text/css">
	  	#leftup{
	  		font:bold;
	  		font-size: 14px;
	  	}
	  	#content{
	  		padding-top:5px;
	  		
	  		border-top: 1px solid #3366CC;
	  		border-bottom: 1px solid #3366CC;
	  		margin-left: 10px;
	  		margin-right: 10px;
	  		padding-bottom:10px;
	  		font-size:14px;
	  	}
	  	#pic{
	  		margin-top: 20px;
	  	}
	  	#picture{
	  		border-top: 1px solid #3366CC;
	  		border-bottom: 1px solid #3366CC;
	  		padding-top:5px;
	  		padding-bottom:5px;
	  	}
	  	
	  </style>
	  <script type="text/javascript">
	  	function ptn(){
	  		
	  		alert("hello");
	  	}
	  </script>
  </head>

  <body>
	<div id="leftup">
	课程介绍>>
	</div>
	<br/>
	<!-- 显示内容 -->
	<div id="content">
		<s:property value="#description"/>
	</div>
  </body>
</html>
