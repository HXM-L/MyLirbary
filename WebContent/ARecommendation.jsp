<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>读者荐购</title>
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
.main{
	box-sizing:border-box;
	margin:0px;
	padding:0px;
	width:100%;
	height: 100%;
	font-size: 15px;
	font-family: "SimSun";
	font-weight: 500;
	/* background-color: rgba(223,220,37,0.4);  */
}
.main>h4{
	margin-left: 55px;
	margin-top: 3px;
	font-size: 20px;
}
.main>hr{
	margin-top:-20px;
}
.main>span{
	margin-left: 55px;
	font-size: 18px;
}
.main>div{
	width:900px;
	margin:0px auto;
	border-top:2px dotted black;
	border-bottom:2px dotted black;
}
.main>ol{
	margin-top:0px;
	margin-left: 45px;
}
.redColor{
	color:red;
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
</script>
</head>
<body onload="getDay('${id}','${User.name}','${User.password}')">
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
	<div class="main">
		<h4>表单荐购</h4>
		<hr>
		<span>${User.name}</span>,您好!您可以通过下方的表单向图书馆推荐订购图书.推荐订购的注意事项如下:
		<ol>
			<li>推荐前请先进入馆藏检索，以了解本馆的收藏情况。</li>
			<li>为方便馆员购书，请把目录信息尽可能输入齐备。<span  class="redColor">其中打"的项目是必填项目，打的是推荐填写项目。ISSNWSSM是国际标准书例号，是采法图书的重要信息。</span>请尽可能获得SENISS%信根并输入。</li>
			<li>为了获得详细书目信息，便于馆员采选，可通过书名进行扩展检索。如:百度google豆瓣</li>
			<li>输入信息后，请按“检索馆藏"项目，确认本馆的收藏情况。</li>
		</ol>
		<div>
			<table>
				<tr>
					<td><span  class="redColor">**</span>书名:</td>
					<td><input type="text"/></td>
					<td><span  class="redColor">*</span>作者:</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td><span  class="redColor">*</span>ISBN:</td>
					<td><input type="text"/></td>
					<td><span  class="redColor">*</span>ISSN:</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>类型:</td>
					<td>
						<select>
							<option value="0">普通图书</option>
							<option value="1">连续出版物</option>
							<option value="2">非书资料</option>
							<option value="3">测绘资料</option>
							<option value="4">档案</option>
							<option value="5">乐谱</option>
							<option value="6">计算机文档</option>
							<option value="7">古籍善本</option>
						</select>
					</td>
					<td>语种:</td>
					<td>
						<select>
							<option value="0">中文</option>
							<option value="1">英文</option>
							<option value="2">日语</option>
							<option value="3">俄文</option>
							<option value="4">法文</option>
							<option value="5">其他</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>*出版社:</td>
					<td><input type="text"/></td>
					<td>出版日期:</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>推荐原因:</td>
					<td colspan="3"><textarea rows="" cols=""></textarea></td>
				</tr>
				<tr>
					<td>注释:</td>
					<td colspan="3"><textarea rows="" cols=""></textarea></td>
				</tr>
				<tr>
					<td>扩展检索:</td>
					<td colspan="3"><span class="redColor">请尽可能把目录信息输入齐备，为了获得详细书目信息，便于馆员采选，可通过书名进行扩展检索:</span>查百度google豆瓣</td>
					
				</tr>
				<tr>
					<td>希望的回复方式:</td>
					<td colspan="3">
						<input type="checkbox"/>MyLibrary
						<input type="checkbox"/>Email
						<input type="text"/>
						<input type="checkbox"/>电话
						<input type="tel"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3"><input type="button" value="检索馆藏"/>（检索管内是否有符合条件的记录。再确认是否提交）</td>
				</tr>
			</table>
		</div>
		
	</div>
	
</body>
</html>