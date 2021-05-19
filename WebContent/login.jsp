<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎登录</title>
<style>
.alert {
	width: 100%;
	height: 48px;
	font-size: 18px;
	font-weight: bold;
	padding: 15px 10px;
	color: #FFA209;
	background-color: #fcf8e3;
	border: 1px solid #faebcc;
	border-radius: 4px;
}

.label {
	font-size: 14px;
	color: #4a4a4a;
	box-sizing: border-box;
	font-family: 'Microsoft YaHei', '微软雅黑', 'Courier New', Courier,
		monospace, sans-serif;
	margin: 0px;
	padding: 0px;
}

.input {
	width: 460px;
	height: 20px;
	padding: 15px 18px;
	border: 1px solid #ddd;
	border-radius: 4px;
}

.formitem {
	margin-top: 15px;
	box-sizing: border-box;
	font-family: 'Microsoft YaHei', '微软雅黑', 'Courier New', Courier,
		monospace, sans-serif;
	padding: 0px;
}

.login {
	width: 500px;
	height: 50px;
	font-size: 18px;
	margin-top: 20px;
	color: #fff;
	background-color: #3691da;
	border-radius: 4px;
	border: transparent;
	cursor: pointer;
}
</style>
<script type="text/javascript">
	function checkLog() {
		var id = document.getElementById("name").value;
		var pwd = document.getElementById("pwd").value;
		if (id == "") {
			alert("账号不能为空!");
			return false;
		} else if (pwd == "") {
			alert("密码不能为空!");
			return false;
		} else {
			return true;
		}
	}
	function show(str) {
		if (str != "") {
			alert(str);
		}
	}
	<%String error = (String) request.getAttribute("error");%>
	function error(){
		var error = '<%=error%>';
		if (error != "null") {
			alert(error);
		}
	}
</script>
</head>
<body onload="error()">
	<center>
		<div>
			<p style="padding: 5px 0; font-weight: 700; font-size: 16px;">SSO services authentication</p>
			<p style="font-weight: 700; font-size: 24px;">统一身份登录</p>
			<div class="alet">您即将登录：个人门户管理中心</div>
			<form action="login.do" method="post" onsubmit="return checkLog()">
				<div class="formitem">
					<p class="label"> 账户 <br /> 
					<input class="input" type="text" id="name" placeholder="请输入借书证号" name="username" required="required"/>
					</p>
				</div>
				<div>
					<p class="label">密码 <br /> 
					<input class="input" type="password" id="pwd" placeholder="请输入密码" name="password" required="required"/>
					</p>
				</div>
				<div>
					<p class="label">选择身份 <br /> 
					<input type="radio" name="status" value="1" checked="checked"/>管理员 
					<input type="radio" name="status" value="2" />学生 
					<input type="radio" name="status" value="3" />教师 
					<input type="radio" name="status" value="4" />校外人员
					</p>
				</div>
				<div>
					<input class="login" type="submit" onclick="checkLog" value="登录" />
				</div>
			</form>
			<hr />
			<a href="#" style="text-decoration: none;">忘记密码</a>
		</div>
	</center>
</body>
</html>