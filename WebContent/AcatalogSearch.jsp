<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>目录检索</title>
<style>
html,body{
	width: 100%;
	height: 100%;
}
body{
	width:100%;
	height:100%;
	margin:0px;
}

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
	width: 101%; overflow : hidden;
	background: #4DA8A9;
	color: #FFF;
	margin-left: -7px;
	margin-top: -10px;
	overflow: hidden;
}

.select {
	font-size: 18px;
	color: #000000;
	text-decoration: none;
	float: left;
	margin-left: 20px
}

.demo {
	background: rgba(255, 255, 255, 0.1);
}

.form-control {
	display: inline-flex;
	width: 600px;
	height: 23px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	color: #555;
	background-color: #fff;
	background-image: none;
	border: 2px solid #000;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
	margin-left: 4px;
	text-decoration: none;
}

.searchButton {
	width: 70px;
	background-color: #9DD192;
	border: none;
	color: white;
	border-radius: 4px;
	margin: 0 2px;
	display: inline-block;
	-moz-user-select: none; /*火狐*/ -webkit-user-select : none;
	/*webkit浏览器*/ -ms-user-select : none; /*IE10*/ -khtml-user-select :
	none; /*早期浏览器*/ user-select : none;
	text-align: center;
	-webkit-user-select: none; /*webkit浏览器*/
	-ms-user-select: none; /*IE10*/
	-khtml-user-select: none; /*早期浏览器*/
	user-select: none;
}

.formgroup {
	display: flex;
	flex-direction: row;
	justify-content: flex-start;
	margin-top: 5px;
}
a:hover {  color : blue ; }
.Notice{
	color:#000;
	line-height:30px;
}
.unlogin{
	color:red;
	text-decoration: none;
}
.showBooks{
	width:1300px;
	margin:10px auto;
	//background-color: yellow;
}
</style>
<script type="text/javascript">
	var userID="";
	var userName="";
	var userPwd="";
	function exit() {
		location.href = "exit.do";
	}
	function getDay(id,name,pwd) {
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
		document.getElementById("day").value = today;
		document.getElementById("day").innerHTML = today;
		
	}
	<%String error = (String) request.getAttribute("error");%>
	function error(){
		var error = '<%=error%>';
		if (error != "null") {
			alert(error);
		}
	}
	function searchBook()	/*搜索图书*/
	  {
		  var condition=document.getElementById("condition").value;
		  var keyword=document.getElementById("keyword").value;
		  if(condition=="请选择")
		  {
			  alert("请选择查询类型!");
		  }else if(keyword==""){
			  alert("请输入关键词!");
		  }
		  else
		  {
			  location.href="Searchbook.do?condition="+condition+"&keyword="+keyword;
		  }
	  }
	function addOrder(selfId,bookname,userid){
		console.log(selfId,bookname,userid);
		if(selfId!=""){
			location.href="AddOrder.do?selfId="+selfId+"&bookname="+bookname+"&userid="+userid;
		} 
		
	}
</script>
</head>
<body onload="getDay('${id}','${User.name}','${User.password}'),error()">
	<div id="header">
		<div id="headertext">岭南师范学院图书馆书目检索系统</div>
		<div>
			<div class="fr">
				&nbsp;&nbsp;<a href=" ">English</a><span>|</span>
				<a href="login.jsp" class="unlogin">退出</a>
				<span>|</span>
				<a href=" ">检索历史</a>
				<br>
				今天是<span id="day" value=""></span>

			</div>
		</div>
	</div>
	<div id="search">
		<ul style="list-style: none;">
			<li><a href="AcatalogSearch.jsp" class="select">目录检索</a></li>
			<li><a href="AentryGuide.jsp" class="select">入馆指南</a></li>
			<li><a href="AreadingGuide.jsp" class="select">读书指引</a></li>
			<li><a href="ARecommendation.jsp" class="select">读者荐购</a></li>
			<li><a href="ApersonalInfo.jsp" class="select">我的图书馆</a>
		</ul>
	</div>
	<div  style="margin-left: 300px">
		<form action="" class="formgroup" method="post">
			<select id="condition" style="height: 38px">
				<option>请选择</option>
				<option value="bookType">图书类型</option>
				<option value="author">作者名</option>
				<option value="bookName">图书名称</option>
				<option value="pusher">出版社名称</option>
			</select> 
			<input class="form-control" placeholder="请输入关键字" type="text" id="keyword" required="required">
			<input class="searchButton" type="button" value="书目检索" onclick="searchBook()"/>
		</form>
	</div>
	<div class="showBooks">
		<table class="tb" cellpadding="7" border="1" width="1250px"
					cellspacing="0">
					<thead class="tbhead">
						<tr>
							<th>书架位置</th>
							<th>图书名称</th>
							<th>图书作者</th>
							<th>图书简介</th>
							<th>图书类型</th>
							<th>出版社名称</th>
							<th>出版日期</th>
							<th>剩余数量</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="e" items="${searchList}">
							<tr>
								<td>${e.selfId}</td>
								<td>${e.bookname}</td>
								<td>${e.author}</td>
								<td>${e.introduction}</td>
								<td>${e.typename}</td>
								<td>${e.publisher}</td>
								<td>${e.publisherDate}</td>
								<td>${e.bookNum}</td>
								<td>
									<input type="button" value="预约" onclick="addOrder('${e.selfId}','${e.bookname}','${id}')" /> 
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
	</div>
</body>
</html>