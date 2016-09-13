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
    
    <title>添加用户</title>
    
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
#txt{
			width:100%;
			height: 200px;
		}
		#txt{
			width: 100%;
	height: 100px;
		}
    </style>
    <script type="text/javascript">
    
    /* 输入验证 */
    	function check(){
    		var num=document.getElementById("num").value;
    		if(num == "" || num == null)
    		{
    			alert("学号不能为空！");
    			return false;
    		}
    		var name=document.getElementById("name").value;
    		if(name =="" || name == null)
    		{
    			alert("姓名不能为空！");
    			return false;
    		}
    		var pwd=document.getElementById("pwd").value;
    		if(pwd  =="" || pwd == null)
    		{
    			alert("密码不能为空！");
    			return false;
    		}
    		var repwd=document.getElementById("repwd").value;
    		if(repwd!=pwd)
    		{
    			alert("两次密码不一样！");
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
    	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
             <td height="30px" width="100%">
				<table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				   <tr>
					<td bgcolor="#353c44" width="100%" height="24px">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr >
								<td width="18px" valign="bottom">
									<img src="images/tb.gif" width="14px" height="14px" />
								</td>
								<td valign="bottom">
									<span class="style1" >添加用户</span>
								</td>
							</tr>
						</table>
					</td>
					</tr>
				</table>
			</td>
          </tr>
           
          <tr>
          		<td>
          			<!-- 对应的action -->
          			<s:form action="useraction" theme="simple">
          			
					<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
					<tr height="50px">
						<td bgcolor="#ffffff" align="center" width="60px">
							<div class="style2">学号：</div>
						</td >
						<td bgcolor="#ffffff"  width="60px">
							<div class="style2">
								<s:textfield id="num" name="num" theme="simple"></s:textfield>
							</div>
						</td >
					</tr>
					<tr>
						<td bgcolor="#ffffff" align="center" width="150px">
							<div class="style2">姓名：</div>
						</td >
						<td bgcolor="#ffffff"  width="150px">
							<div class="style2">
								<s:textfield id="name" name="name" theme="simple"></s:textfield>
							</div>
						</td >
					</tr>
					<tr>
						<td bgcolor="#ffffff" align="center" width="200px">			
							 <div class="style2">密码：</div>
						</td>
 						<td bgcolor="#ffffff" width="200px">			
							 <div class="style2">
								<s:password id="pwd" name="pwd" theme="simple"></s:password>
							 </div>
						</td>
					</tr>
						<tr>
						<td bgcolor="#ffffff" align="center" width="200px">			
							 <div class="style2">重复密码：</div>
						</td>
						<td bgcolor="#ffffff" width="200px">			
							 <div class="style2">
								<s:password id="repwd" name="repwd" theme="simple"></s:password>
							 </div>
						</td>
					</tr>
					<tr height="50px">
						<td colspan="2" bgcolor="#ffffff" align="center">
							<div class="style2">
							
							<!-- action对应的方法 -->
							 <s:submit value="提交" method="addUser" theme="simple" onclick="return check();"></s:submit>
							 </div>
						</td>
					</tr>
					</table>
					</s:form>
				</td>
          
          </tr> 
        </table>
    
  </body>
</html>
