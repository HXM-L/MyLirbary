<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.*"%>
<%@page import="dao.impl.*"%>
<%@page import="bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理图书</title>
<style>
#header {
	width: 101%;
	height: 50px;
	background-color: #def3fe;
	border-bottom: #7f9db9 1px solid;
	margin-left: -7px;
	margin-top: -7px;
}

.clearFix: {
	display: inline-block;
}

#headertext {
	height: 50px;
	text-align: left;
	font-size: 25px;
	font-weight: bold;
	line-height: 50px;
	float: left;
	padding-left: 5px;
	font-family: 楷体_GB2312
}

.fr {
	float: right;
	margin-right: -65px;
	margin-top: 9px;
	width: 20%;
}

.redlink {
	color: #ff0000;
	text-decoration: none;
}

#headermenu {
	height: 25px;
	text-align: right;
	line-height: 25px;
	padding-right: 20px;
	float: right;
}

#pagemenu {
	height: 30px;
	line-height: 30px;
	background-color: #00A5EC;
	text-aligin: left;
	padding-left: 30px;
	font-size: 13px
}

#search {
	width: 101%;
	overflow: hidden;
	background: #4DA8A9;
	color: #FFF;
	margin-left: -7px;
	margin-top: -7px;
	overflow: hidden;
}

.select {
	font-size: 13px;
	color: #000000;
	text-decoration: none;
	float: left;
	margin-left: 20px
}

.demo {
	background: rgba(255, 255, 255, 0.1);
}

a:hover {
	color: blue;
}

.Notice {
	color: #000;
	line-height: 30px;
}

.unlogin {
	color: red;
	text-decoration: none;
}

#UserMaster {
	min-height: 450px;
	height: auto;
	min-width: 780px;
	width: 100%;
	float: left;
}

.clearFix {
	display: block;
}

#UserMasterLeft {
	min-width: 160px;
	width: 160px;
	float: left;
	boder-right-style: solid;
	border-right-width: 1px;
	border-color: #ddd;
	height: 100%;
	background-color: #def3fe;;
	text-align: left;
	font: 12px Arial, Helvetica, sans-serif;
	color: #333;
	margin-left: -8px;
}

#UserMasterLeft .userinfo {
	border-bottom: 2px solid #ddd;
	display: block;
	padding: 15px 10px 0px 10px;
	text-align: left;
	font-size: 18px;
	font-weight: 500;
	height: 32px;
}

#userpagemenu {
	width: 220px !important;
	line-height: 80px;
	text-align: left;
	padding-left: 10px;
	padding-right: 10px;
	font-size: 12px;
	height: 100%;
	margin-left: -70px;
}

.select {
	font-size: 16px;
	color: #000000;
	text-decoration: none;
	float: left;
	margin-left: 20px
}

#content {
	min-height: 500px;
	height: auto;
	text-align: left;
}

#UserMasterRight {
	width: 76;
	float: left;
	padding: 10px;
}

h1.userpagetitle {
	font-size: 14px;
	padding-bottom: 12px;
	margin-bottom: 15px;
	padding-right: 4px;
	padding-left: 10px;
	color: #333;
	line-height: 16px;
	height: 16px;
	border-bottom: 1px solid #ddd;
}

#userInfoContent {
	margin-left: 10px;
}

#userInfoContent .infoline {
	text-align: left;
	margin-bottom: 20px;
	margin-left: 60px;
}

#userInfoContent .infoline .infoleft {
	width: 30%;
}

#userInfoContent .infoline .inforight {
	margin-left: 15px;
}
</style>
<script type="text/javascript">
	var userID="";
	var userName="";
	var userPwd="";
	function exit() {
		location.href = "exit.do";
	}
	function getDay(id,name,pwd,flag) {
		userID=id;
		userName=name;
		userPwd=pwd;
		console.log(id) 
		console.log(name) 
		console.log(pwd) 
		let today = "";
		let arry = [ '日', '一', '二', '三', '四', '五', '六' ];
		let now = new Date();
		let year = now.getFullYear(); //年
		let month = now.getMonth() + 1; //月
		let day = now.getDate(); //日
		let week = now.getDay(); //获取当前星期X(0-6,0代表星期天)
		today += year + "年" + month + "月" + day + "日 星期" + arry[week];
		/* document.getElementById("day").value = today; */
		document.getElementById("day").innerHTML = today;
	}
	<%String error = (String) request.getAttribute("updateFlag");%>
	function error(){
		var error = '<%=error%>';
		if (error != "null") {
			alert(error);
		}
	}
</script>
</head>
<body
	onload="getDay('${id}','${User.name}','${User.password}',${isFlag}),error()">
	<div id="header">
		<div id="headertext">岭南师范学院图书馆书目检索系统</div>
		<div>
			<div class="fr">
				&nbsp;&nbsp;<a href=" ">English</a><span>|</span> <a
					href="login.jsp" class="unlogin">退出</a> <span>|</span> <a href=" ">检索历史</a>
				<br> 今天是<span id="day" value=""></span>

			</div>
		</div>
	</div>
	<div id="search">
		<ul style="list-style: none;">
			<li><a href="editBooks.jsp" class="select">图书管理</a></li>
			<li><a href="editBookType.jsp" class="select">图书分类管理</a></li>
			<li><a href="admin.jsp" class="select">图书借阅信息</a></li>
			<li><a href="returnInfo.jsp" class="select">报表导出</a></li>
			<li><a href="admin.jsp" class="select">购置图书</a>
		</ul>
	</div>
	<div id="content" class="clearFix">
		<div id="UserMaster" class="clearFix">
			<div id="UserMasterLeft">
				<div class="userinfo">
					欢迎您，${User.name}
					<div id="userpagemenu">
						<ul style="list-style-type: none">
							<li><a class="select" href="admin.jsp">个人信息&nbsp;&nbsp;&nbsp;</a>
							</li>
							<li><a class="select" href="updatePassword.jsp">修改密码</a></li>
							<li><a class="select" href="orderhistory.jsp">预约图书信息</a></li>
							<li><a class="select" href="borrowing.jsp">当前借阅情况和续借</a></li>
							<li><a class="select" href="urgeReturn.jsp">催还图书信息</a></li>
							<li><a class="select" href="booksborrowedhistory.jsp">我的借阅历史</a>
							</li>
							<li><a class="select" href="#">退出登录</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div id="UserMasterRight">
				<form id="aspnetForm" action="bookAdd.do" method="post">
					<h1 class="userpagetitle">添加图书信息</h1>
					<div id="userInfoContent">
						<div class="infoline">
							<span class="infoleft">图书ID号:</span> <span class="inforight">
								<input class="input" type="text" placeholder="请输入图书ID号"
								name="bookid" required="required" autofocus="autofocus"/>
							</span>
						</div>
						<div class="infoline">
							<span class="infoleft">图书名:</span> <span class="inforight">
								<input class="input" type="text" placeholder="请输入图书名"
								name="bookName" required="required"/>
							</span>
						</div>
						<div class="infoline">
							<span class="infoleft">作者名</span> <span class="inforight"><input
								class="input" type="text" placeholder="请输入作者名" name="author" /></span>
						</div>
						<div class="infoline">
							<span class="infoleft">出版社日期:</span> <span class="inforight"><input
								class="input" type="text" placeholder="出版日期" name="publishDate" /></span>
						</div>
						<div class="infoline">
							<span>数量</span> <span class="inforight"><input
								class="input" type="text" placeholder="数量" name="number" /></span>
						</div>
						<div class="infoline">
							<span class="infoleft">图书类型：</span> <span class="inforight">
								<select style="height: 38px" name="type">
									<option>请选择</option>
									<c:forEach var="item" items="${typeList}">
								       <option value="${item.typeId}">${item.name}</option>
								    </c:forEach>
							</select>
							</span>
						</div>
						<div class="infoline">
							<span>简介:</span> <span class="inforight"><input
								class="input" type="text" placeholder="简介" name="introd" /></span>
						</div>
						<div class="infoline">
							<span>出版社:</span> <span class="inforight"><input
								class="input" type="text" placeholder="出版社" name="publish" /></span>
						</div>
						<div class="infoline">
							<span class="infoleft"> <input type="submit" value="添加" /></span>
							<span class="inforight"><input type="reset" value="取消" /></span>
						</div>

					</div>
				</form>
			</div>
		</div>

	</div>

</body>
</html>