<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<script language="javascript" type="text/javascript"
			src="./js/WdatePicker.js"></script>
		<script src="./js/js.js"></script>
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
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
	background-color: #f6f6Ff;
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
	font-size: 18px;
}

.style3 a {
	color: #6A5ACD;
}
</style>
		<script type="text/javascript">
	function funsubmit() {
		document.getElementById("frm").submit();
	}

	function check2() {
		var name_id = document.getElementById("name_id");
		var price_id = document.getElementById("price_id");
		var sellPrice_id = document.getElementById("sellPrice_id");
		var discount_id = document.getElementById("discount_id");
		var storage_id = document.getElementById("storage_id");
		var tradeStartDate_id = document.getElementById("tradeStartDate_id");
		var tradeEndDate_id = document.getElementById("tradeEndDate_id");
		var consumeStartDate_id = document
				.getElementById("consumeStartDate_id");
		var consumeEndDate_id = document.getElementById("consumeEndDate_id");
		var keywords_id = document.getElementById("keywords_id");
		var description_id = document.getElementById("description_id");
		var uploadfile_id = document.getElementById("uploadfile_id");

		if (name_id.value == "") {
			alert("请输入教师名");
			return false;
		}
		if (price_id.value == "") {
			alert("请输入性别");
			return false;
		}
		if (sellPrice_id.value == "") {
			alert("请输入教师学历");
			return false;
		}
		if (discount_id.value == "") {
			alert("请输入教师职位");
			return false;
		}
		if (storage_id.value == "") {
			alert("请输入教师教育背景");
			return false;
		}
		if (tradeStartDate_id.value != repwd.value) {
			alert("请输入教师所在学院");
			return false;
		}
		if (tradeEndDate_id.value == "") {
			alert("请输入教师联系地址");
			return false;
		}
		if (consumeStartDate_id.value == "") {
			alert("请输入教师学术研究方向");
			return false;
		}
		if (consumeEndDate_id.value == "") {
			alert("请输入教师简介");
			return false;
		}

		if (keywords_id.value == "") {
			alert("请输入教师学术成就");
			return false;
		}
		if (description_id.value == "") {
			alert("请输入教师所教课程信息");
			return false;
		}

		if (uploadfile_id.value == "") {
			alert("请上传教师照片");
			return false;
		}
		return true;
	}
</script>
	</head>

	<body>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30px" width="100%">
					<table width="100%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td bgcolor="#353c44" width="100%" height="24px">
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="18px" valign="bottom">
											<img src="images/tb.gif" width="14px" height="14px" />
										</td>
										<td valign="bottom">
											<span class="style1">修改教师资料</span>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

			<s:form action="adminteacher.action" enctype="multipart/form-data"
								method="post" id="uploadfile_id">
			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="1" bgcolor="#e1e2e3">

				<tr height="50px">
					<td bgcolor="#ffffff" width="50%" align="right">
						<div class="style3">
							教师名：
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div class="style5">
							<input type="text" name="name" id="name_id" style="width: 200" />
							<font color="#CC0033 " size="2"><span id="result1"></span>
							</font><font color="red">*</font>
						</div>
					</td>
				</tr>

				<tr height="50px">
					<td bgcolor="#ffffff" width="50%" align="right">
						<div class="style3">
							性别：
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div class="style5">
							<input type="text" name="sex" id="price_id" style="width: 200" />
							<font color="#CC0033 " size="2"><span id="result2"></span>
							</font>
							<font color="red">*</font>
						</div>
					</td>
				</tr>
				<tr height="50px">
					<td bgcolor="#ffffff" width="50%" align="right">
						<div class="style3">
							学位：
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div class="style5">
							<input type="text" name="degree" id="sellPrice_id"
								style="width: 200" />
							<font color="#CC0033 " size="2"><span id="result3"></span>
							</font>
							<font color="red">*</font>
						</div>
					</td>
				</tr>
				<tr height="50px">
					<td bgcolor="#ffffff" width="50%" align="right">
						<div class="style3">
							职位：
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div class="style5">
							<input type="text" name="position" id="discount_id"
								style="width: 200" />
							<font color="#CC0033 " size="2"><span id="result4"></span>
							</font>
							<font color="red">*</font>
						</div>
					</td>
				</tr>
				<tr height="50px">
					<td bgcolor="#ffffff" width="50%" align="right">
						<div class="style3">
							教育背景：
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div class="style5">
							<input type="text" name="eduBackground" id="storage_id"
								style="width: 200" />
							<font color="#CC0033 " size="2"><span id="result5"></span>
							</font>
							<font color="red">*</font>
						</div>
					</td>
				</tr>

				<tr height="50px">
					<td bgcolor="#ffffff" width="50%" align="right">
						<div class="style3">
							所在学院：
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div class="style5">

							<input class="Wdate" type="text" name="college"
								id="tradeStartDate_id" style="width: 200" />
							<font color="#CC0033 " size="2"><span id="result6"></span>
							</font>
							<font color="red">*</font>
						</div>
					</td>
				</tr>
				<tr height="50px">
					<td bgcolor="#ffffff" width="50%" align="right">
						<div class="style3">
							联系地址:
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div class="style5">
							<input class="Wdate" type="text" name="address"
								id="tradeEndDate_id" style="width: 200" />
							<font color="#CC0033 " size="2"><span id="result7"></span>
							</font>
							<font color="red">*</font>
						</div>
					</td>
				</tr>

				<tr height="50px">
					<td bgcolor="#ffffff" width="50%" align="right">
						<div class="style3">
							学术方向：
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div class="style5">

							<input class="Wdate" type="text" name="direction"
								id="consumeStartDate_id" style="width: 200" />
							<font color="#CC0033 " size="2"><span id="result8"></span>
							</font>
							<font color="red">*</font>
						</div>
					</td>
				</tr>
				<tr height="50px">
					<td bgcolor="#ffffff" width="50%" align="right">
						<div class="style3">
							简介：
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div class="style5">

							<s:textarea type="" name="intro"
								id="consumeEndDate_id" style="width: 200" theme="simple"/>
							<font color="#CC0033 " size="2"><span id="result9"></span>
							</font>
							<font color="red">*</font>
						</div>
					</td>
				</tr>
				<tr height="50px">
					<td bgcolor="#ffffff" width="50%" align="right">
						<div class="style3">
							学术成就：
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div class="style5">
							<s:textarea name="achievement" id="keywords_id"
								style="width: 200" theme="simple"/>
							<font color="#CC0033 " size="2"><span id="result10"></span>
							</font>
							<font color="red">*</font>
						</div>
					</td>
				</tr>
				<tr height="50px">
					<td bgcolor="#ffffff" width="50%" align="right">
						<div class="style3">
							照片：
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div class="style5">
						
								<s:file name="uploadPhoto" theme="simple"/>
								
							
						
							<font color="red">*</font>
						</div>
					</td>
				</tr>
			


			</table>

			<table align="center">
				<tr>
					<td align="center">

						<s:submit type="image" src="images/admin/submit.png" id="sub"
							method="correctTeacher" theme="simple" />
						</s:form>
					</td>
				</tr>
			</table>
	</body>
</html>
