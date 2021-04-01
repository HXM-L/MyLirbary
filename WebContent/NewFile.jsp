<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery引入</title>
<script type="text/javascript" src="./js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("tr:gt(1):even").css("background-color", "#ffaa00");
		$("tr:gt(1):odd").css("background-color", "#ffaaff");
		let $selectAll = $("#selectAll");
		console.log($selectAll);
		//实现全选
		$selectAll.click(function() {
			console.log($selectAll);
			$(".itemSelect").prop("checked", $selectAll.prop("checked"));
		});
	});
</script>
</head>
<body>
	<table id="tab1" border="1" width="500" align="center" cellspacing="0"
		cellpadding="">
		<tr>
			<td colspan="5"><input type="button" name="" id="" value="删除" /></td>
		</tr>
		<tr style="background-color: aquamarine;">
			<th><input id="selectAll" type="checkbox" /></th>
			<th>分类ID</th>
			<th>分类名称</th>
			<th>分类描述</th>
			<th>分类操作</th>
		</tr>
		<tr>
			<td style="text-align: center;"><input class="itemSelect"
				type="checkbox" /></td>
			<td>1</td>
			<td>手机数码</td>
			<td>手机数码类商品</td>
			<td><a href="">修改</a>|<a href="">删除</a></td>
		</tr>
		<tr>
			<td style="text-align: center;"><input class="itemSelect"
				type="checkbox" /></td>
			<td>2</td>
			<td>手机数码</td>
			<td>手机数码类商品</td>
			<td><a href="">修改</a>|<a href="">删除</a></td>
		</tr>
		<tr>
			<td style="text-align: center;"><input class="itemSelect"
				type="checkbox" /></td>
			<td>3</td>
			<td>手机数码</td>
			<td>手机数码类商品</td>
			<td><a href="">修改</a>|<a href="">删除</a></td>
		</tr>
		<tr>
			<td style="text-align: center;"><input class="itemSelect"
				type="checkbox" /></td>
			<td>4</td>
			<td>手机数码</td>
			<td>手机数码类商品</td>
			<td><a href="">修改</a>|<a href="">删除</a></td>
		</tr>
	</table>
</body>
</html>