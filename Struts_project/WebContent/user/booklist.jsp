<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'itemlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
     body {
	         margin-left: 3px;
	         margin-top: 0px;
	         margin-right: 3px;
	         margin-bottom: 0px;
      }
      .style1 {
	       color: #e1e2e3;
	       font-size: 12px;
	       
      }
      .style2 {
          color: #000000; 
          font-size: 12px; 
      }
      .style3 {
	       color: #344b50;
	       font-size: 12px;
		}
		.style3 a{
			color:#6A5ACD;
		}
		.style4 {
	       font-size: 12px;
	       color: #295568;
		}
				a:Link       {
			color:#0000ff;
		 font-family: "Tahoma,宋体";  text-decoration: none;}
a:visited    { color:#0000ff; font-family: "Tahoma,宋体"; text-decoration: none;}
a:hover      { color:#0000ff; font-family: "Tahoma,宋体";  text-decoration: underline;}
a:active     { color:#0000ff; "Tahoma,宋体";  text-decoration: none;}
a            { color:#0000ff; text-decoration: none; }
#banner{
	
	border: 1px solid #353c44;
	margin-bottom:20px;
	
}
    </style>
  </head>
  
  <body >
  
  	<s:if test="#lst==null">
  		<center>
  			<font color="#ff0000" size="12px">暂无参考书籍</font>
  		</center>
  	</s:if>
  	<s:else>
  		<s:iterator var="book" value="#lst">
  		<div id="banner">
  		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  				
  				<tr height="180px">
  					<td align="left">
  					<table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  						<tr height="40px">
  							<td width="100px" >书籍名称：</td>
  							<td>
  								<s:property value="#book.name"/>
  							</td>
  							
  						</tr>
  						<tr >
  							<td  valign="top">内容介绍：</td>
  							<td valign="top">
  								<s:property value="#book.description"/>
  							</td>
  						</tr>
  						
  						</table>
  					
  						
  					</td>
  					<td width="200px">
  						<img  src="<s:property value='#book.path'/>" width="100%" height="100%">
  						
  					</td>
  				</tr>
  				
  	
  				
  		</table>
  		</div>
  	</s:iterator>
</s:else>
  
  
 
  
  </body>
</html>
