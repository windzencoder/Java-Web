<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
	String basePath=request.getContextPath(); 
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + basePath;
%>
<html>
	<head>
		<title>美讯购物网</title>
	</head>
	<body>
		<div id="top">
			<h1>
				商品添加页面
			</h1>
			<div id="form">
				<form action="<%=basePath %>/GoodsSer" method="post">
				
					<!-- 表示当前的页面 -->
					<input type="hidden" name="status" value="saveCategory">
					
					<div id="infor">
						<div id="inputs2">
							<span>商品名称:</span>
							<span><input type="text" name="gname" id="gname" /> </span><spanid="gnameError">*</span>
						</div>
					</div>

					<div id="infor">
						<div id="inputs1">
							<span>商品单价:</span>
							<span><input type="text" name="gprice" id="gprice" /> </span><span id="gpriceError">*</span>
						</div>
					</div>

					<div id="infor">
						<div id="inputs1">
							<span>商品图片:</span>
							<span><input type="file" name="gpic" /> </span>
						</div>

						<div id="infor">
							<div id="inputs1">
								<span>是否推荐:</span>
								<input type="radio" name="giscommend" value="true"/>是 
								<input type="radio" name="giscommend" value="false" checked="checked"/>否
							</div>
							<div id="inputs2">
								<span>是否有效:</span>
								<span> 
									<input type="radio" name="gisopen" value="true" checked="checked" />是 
									<input type="radio" name="gisopen" value="false" />否
								</span>
							</div>
						</div>
						<div id="inputs2">
							<span>商品类别:</span>
							<select name="cid" id="cid">
								<c:forEach items="${applicationScope.categorys}" var="category">
									<option value="${category.cid}">${category.ctype}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div id="textarea1">
						<span id="mesage">产品描述:</span>
						<span> <textarea rows="4" cols="64" name="gremark"></textarea> </span>
					</div>

					<div id="textarea1">
						<span id="mesage">详细介绍:</span>
						<span> <textarea rows="5" cols="64" name="gxremark"></textarea> </span>
					</div>
					<input type="submit" value="添加" />
				</form>
			</div>
		</div>
	</body>
</html>
