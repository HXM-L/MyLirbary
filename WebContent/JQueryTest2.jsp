<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery引入</title>
<script type="text/javascript" src="./js/jquery-3.6.0.min.js"></script>
<style type="text/css">
#b1 {
	width: 100px;
	height: 100px;
	display: none;
	background-color: #00FFFF;
}

.dialog {
	width: 100px;
	height: 100px;
	/* display: none; */
	background-color: #00FFFF;
}
</style>
<script type="text/javascript">
	/* $(document).ready(function(){
	  $("button").click(function(){
	  $("#b1").toggle(250);
	  });
	}); */
	function fn(a) {
		$("#b1").css("display", "block");
		console.log($("#b1").html());
	}
	function fn1(a) {
		$(".dialog").toggle(250);
		console.log(a);
	}
</script>
</head>
<body>
	<form action="">
		<!-- <button onclick="fn('你好')">请点击这里，来切换不同的背景颜色</button> -->
		<input type="submit" name="" id="" value="换色" onclick="fn('你好')" />
		<div id="b1">kkkkk</div>
		<a href="" id="modify" onclick="fn1('hello')">修改</a>
		<div class="dialog"></div>
	</form>
</body>
</html>