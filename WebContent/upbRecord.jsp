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
<title>修改借阅记录</title>
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
	width: 1200px;
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

.tbhead {
	text-align: center;
}

#dialog {
	clear: both;
	position: relative;
	width: 1600px;
	height: 800px;
	left: -170px;
	top: -295px;
	background-color: rgba(176, 176, 176, 0.7);
	z-index: 5;
	display: block;
}

#dialog>div {
	position: absolute;
	width: 1200px;
	height: 620px;
	background-color: white;
	left: 200px;
	top: 150px;
	border: 2px;
}

table>tbody tr>td {
	margin: 0px auto;
	padding: 2px 0px 2px 2px;
}

table>tbody tr>td>input {
	width: 160px;
	height: 20px;
}

.inputFlag {
	width: 50px;
}
input[type=submit],input[type=button]{
	width: 40px;
	text-align: center;
	-webkit-user-select: none; /* Chrome/Safari/Opera */
}
</style>
<script type="text/javascript" src="./js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	var userID = "";
	var userName = "";
	var userPwd = "";
	function exit() {
		location.href = "exit.do";
	}
	function getDay(id, name, pwd) {
		userID = id;
		userName = name;
		userPwd = pwd;
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
		document.getElementById("day").value = today;
		document.getElementById("day").innerHTML = today;
	}
</script>
</head>
<body onload="getDay('${id}','${User.name}','${User.password}')">
	<div id="header">
		<div id="headertext">岭南师范学院图书馆书目检索系统</div>
		<div>
			<div class="fr">
				&nbsp;&nbsp;<a href=" ">English</a><span>|</span> <a
					href="login.jsp" class="unlogin">退出</a> <span>|</span> <a href=" ">检索历史</a>
				<br> 今天是<span id="day"></span>
			</div>
		</div>
	</div>
	<div id="search">
		<ul style="list-style: none;">
			<li><a href="editBooks.jsp" class="select">图书管理</a></li>
			<li><a href="editBookType.jsp" class="select">图书分类管理</a></li>
			<li><a href="borrowRecord.jsp" class="select"
				onclick="searchRecord()">图书借阅信息</a></li>
			<li><a href="returnInfo.jsp" class="select">报表导出</a></li>
			<li><a href="buyBook.jsp" class="select">购置图书</a>
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
							<li><a class="select" href="updatePwd.jsp">修改密码</a></li>
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
				<h1 class="userpagetitle">修改借阅记录</h1>
				<form action="UpdateRecord.do" method="post">
					<table cellpadding="" border="1" width="1300px" cellspacing="0">
						<thead class="tbhead">
							<tr>
								<th>借阅记录号</th>
								<th>图书ID号</th>
								<th>图书名称</th>
								<th>读者账号</th>
								<th>借阅日期</th>
								<th>还书日期</th>
								<th>续借</th>
								<th>超期</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="text" name="recordID"
									value="${recoed.borrRecordId}" autofocus="autofocus" /></td>
								<td><input type="text" name="bookID"
									value="${recoed.bookid}" /></td>
								<td><input type="text" name="bookName"
									value="${recoed.bookName}" /></td>
								<td><input type="text" name="borrowerId"
									value="${recoed.borrowerId}" /></td>
								<td><input type="text" name="borrTime"
									value="${recoed.borrTime}" /></td>
								<td><input type="text" name="returnTime"
									value="${recoed.returnTime}" /></td>
								<td><input type="text" name="aginBorr" class="inputFlag"
									value="${recoed.aginBorr}" /></td>
								<td><input type="text" name="overTime" class="inputFlag"
									value="${recoed.overTime}" /></td>
								<td><input type="submit" value="确定"/>
								<a href="borrowRecord.jsp"><input type="button" value="取消" /></a></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>