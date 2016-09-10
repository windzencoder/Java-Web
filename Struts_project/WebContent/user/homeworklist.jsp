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
	margin-left: 5px;
	margin-right: 5px;
}
    </style>
   <script type="text/javascript">
	function checklogin(frame){
		
	
		//	var file=document.getElementById("homeworkfile");
			if(frame.uploadFile.value=="")
			{
				alert("请选择上传文件");	
				return false;
			}
	
		
		return true;
	}
</script>
  </head>
  
  <body >
  
  	<s:if test="#lst==null">
  		<center>
  			<font color="#ff0000" size="12px">暂无作业</font>
  		</center>
  	</s:if>
  	<s:else>
  		<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#a8c7ce">
						<tr>
							<td bgcolor="d3eaef" align="center">
								<div class="style2">
									编号
								</div>
							</td>
							<td bgcolor="d3eaef" align="center" width="200px">
								<div class="style2">
									名称
								</div>
							</td>
							<td bgcolor="d3eaef" align="center">
								<div class="style2">
									是否交作业
								</div>
							</td>
							<td bgcolor="d3eaef" align="center">
								<div class="style2">
									下载作业
								</div>
							</td>
							<td bgcolor="d3eaef" align="center">
								<div class="style2">
									上传作业
								</div>
							</td>

							<%
							//	int pagecode = Integer.parseInt(request.getParameter("pagecode"));
								int num = 1;//(pagecode - 1) * 10 + 1;
							%>
					</tr>
							<s:iterator var="homework" value="#lst">
								<tr>
									<td bgcolor="#ffffff" align="center">
										<div class="style3"><%=num++%></div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#homework.name"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:if test="#homework.ishashomework==0">
												<font color="#ff0000">未交作业</font>
											</s:if>
											<s:else>
												已交
											</s:else>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
									<div class="style3">
										<s:a action="userhomework!homeworkDownload.action">
											下载
											<s:param name="id">${homework.id}</s:param>
										</s:a>
									</div>
									</td>
										<td bgcolor="#ffffff" align="center">
									<div class="style3">
									<s:form action="userhomework" enctype="multipart/form-data" onsubmit="return checklogin(this);">
										<s:file name="uploadFile" theme="simple" id="homeworkfile" label="选择文件"></s:file>
										<s:hidden name="id" value="%{#homework.id}"></s:hidden>
										<s:hidden value="%{#session.id}" id="uid" name="uid"></s:hidden>
										<s:submit method="upLoad" value="提交" ></s:submit>
										 
									</s:form>
										
									</div>
									</td>
								</tr>
								
							</s:iterator>
					</table>  
					 <s:if test="#request.pages>1">
    	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
         
          <tr>
          		<td>
				</td>
          </tr>  
          
          <tr>
          	 <tr>
             <td height="30px;">
          	<table width="100%" border="0" cellspacing="0" cellpadding="0">
          	   <tr>
          	   		<td>         	   		  
          	   		</td>
          	   		<td width="600px">
          	   		 <div align="right" style="margin-right:20px;">
          	   		 
          	   		 
          	   		 	
					<s:a href="userhomework!showHomeworkList.action?pagecode=1">
						首页
					</s:a>
					
					<s:if test="#request.pagecode!=1">

					    <s:a href="userhomework!showHomeworkList.action?pagecode=%{#request.pagecode-1}">
						
						上一页   </s:a>
					</s:if>
					
					  目前第
					<s:property value="#request.pagecode"/> 页   
					
					 <s:if test="#request.pagecode<#request.pages">
					  
					    <s:a href="userhomework!showHomeworkList.action?pagecode=%{#request.pagecode+1}">
					 	
					 	下一页</s:a>
					 </s:if>
					 

					<s:a targets="right" href="userhomework!showHomeworkList.action?pagecode=%{#request.pages}">
						最后一页
					</s:a>
          	   		</div>
          	   		</td>
          	   </tr>
          	</table>
            </td>         
          </tr> 
        </table>
    </s:if>
  		
  	</s:else>
  
  
 
  
  </body>
</html>
