<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
     body {
	         margin-left: 3px;
	         margin-top: 5px;
	         margin-right: 3px;
	         margin-bottom: 0px;
      }
      .style1 {
	       color: #e1e2e3;
	       font-size: 12px;
      }
    </style>
  </head>
  
  <body>
  
      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
              <td bgcolor="#353c44" width="100%">
                 <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="18px"><img src="images/tb.gif" width="14" height="14" /></td>
                        <td><span class="style1">欢迎</span></td>
                    </tr>
                 </table>
             </td>
          </tr>
      </table>
      
       <div align="center">
       		<font color="#ff0000" size="14px">
       		欢迎访问后台管理系统</font>
       </div>
  </body>
</html>
