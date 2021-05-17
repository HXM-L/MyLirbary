<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入馆指南</title>
<style>
html{
	width:100%;
	height:100%;
	background-image: url("./IMG/bg.jpg");
	background-repeat:no-repeat;
	background-size:100% 100%;
}
body{
	width:100%;
	height:100%;
	margin:0px;
	background-color:rgba(255,255,255,0.5);
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
.nav{
	width:70%;
	height:80%;
	margin:20px auto;
	background-color:rgba(255,255,255,0.6);
}
.nav>ul{
	width:95%;
	margin:0px auto;
	padding:0px;
	/* background-color:rgba(128,205,75,1.0); */
}
.nav>ul>li{
	display:inline-block;
	width:25%;
	height:35px;
	list-style: none;
	line-height:35px;
	font-size:29px;
	font-family:"kaiti";
	font-weight:700;
	margin:-0px;
	margin-right:-9px;
	text-align:center;	
	background-color:rgba(128,205,75,1.0);
	user-select: none;
	transition:all 1s;
}
.nav>ul>li:not(:last-child){	/*除去最后一个孩子*/
	border-right:2px white solid;
}
.nav>ul>li a{
	text-decoration: none;
}
.nav>ul>li:hover{
	text-decoration: underline;
	background-color:rgba(223,220,37,1.0);
	cursor: pointer;
}
.nav>ul>li a:hover{
	text-decoration: underline;
}
#liSelect{
	background-color:rgba(223,220,37,1.0);
}
.time{
	box-sizing:border-box;
	width: 80%;
	height: 75%;
	margin:50px auto;
	padding:0px;
	border: 2px solid blue;
	border-radius: 20px;
}
.time>ul>li{
	box-sizing:border-box;
	width:360px;
	float:left;
	list-style: none;
	font-size:20px;
	line-height:30px;
	verticle-align:middle;
	margin-top: 12px;
	margin-bottom: 20px;
	margin-right:45px;
	padding-top:2px;
	padding-left:60px;
	border: 1px solid black;
}
.time>ul>li:nth-of-type(1){
	background-image: url("./IMG/house.png");
	background-repeat:no-repeat;
	background-size: auto 75%;
	background-position: 1% 55%;
	 /* background-color: red; */
}
.time>ul>li:nth-of-type(2){
	background-image: url("./IMG/things.png");
	background-repeat:no-repeat;
	background-size: auto 90%;
	/* background-color: red; */
}
.time>ul>li:nth-of-type(3){
	background-image: url("./IMG/net.png");
	background-repeat:no-repeat;
	background-size: auto 90%;
	/* background-color: red; */
}
.time>ul>li:nth-of-type(4){
	background-image: url("./IMG/power.png");
	background-repeat:no-repeat;
	background-size: auto 90%;
	/* background-color: red; */
}
.time>ul>li:nth-of-type(5){
	background-image: url("./IMG/pronto.png");
	background-repeat:no-repeat;
	background-size: auto 90%;
	/* background-color: red; */
}
.time>ul>li:nth-of-type(6){
	background-image: url("./IMG/drink.png");
	background-repeat:no-repeat;
	background-size: auto 90%;
	/* background-color: red; */
}
.time>ul>li:nth-of-type(7){
	background-image: url("./IMG/certificates.png");
	background-repeat:no-repeat;
	background-size: auto 90%;
	/* background-color: red; */
}
.time>ul>li:nth-of-type(8){
	background-image: url("./IMG/tell.png");
	background-repeat:no-repeat;
	background-size: auto 90%;
	/* background-color: red; */
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
	function jumpURL(){
		var myLis=document.querySelectorAll("div[class='nav']>ul>li");
		console.log(myLis);
		location.href = "AentryGuide.jsp";
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
	<div class="nav">
		<ul>
			<li><a  href="AentryGuide.jsp">服务时间</a></li>
			<li><a  href="AentryGuide2.jsp">交通指南</a></li>
			<li id="liSelect"><a  href="AentryGuide3.jsp">入馆须知</a></li>
			<li><a  href="AentryGuide4.jsp">无线使用</a></li>
		</ul>
		<div class="time">
			<ul>
				<li>请注意仪表着装，衣冠整洁得体，言谈举止文明。</li>
				<li>随身携带的书包及其他物品可免费寄存，贵重物品请随身携带。</li>
				<li>阅览室内请保持安静，移动通讯设备请置于静音状态。</li>
				<li>请在指定区域内使用电源，勿擅自外接电源或充电。</li>
				<li>禁止在馆区内吸烟,携带易燃、易爆、有毒等危险品入馆。</li>
				<li>请勿在阅览区内饮食、喝有色和含糖饮料。</li>
				<li>请遵守公共秩序和图书馆相关管理规定，自觉维护阅读环境。</li>
				<li>咨询电话:0571-87988700<br/>投诉建议:0571-87988569</li>
			</ul>
		</div>
	</div>
	
</body>
</html>