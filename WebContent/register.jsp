<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<script src="./js/jquery-3.6.0.min.js"></script>
<script src="./js/jquery.validate.js"></script>
<style>
.error {
	color: #FF0000;
}
.registtable{
	width: 800px;
}
.tfist{
	width: 180px;
}
</style>
<script>
	/* $.validator.setDefaults({
		submitHandler : function() {
			alert("submitted!");
		}
	}); */

	$().ready(function() {
		//自定义校验方法,验证身份证位数是否合法
		$.validator.addMethod("cartlength", function(value, element, params) {
			if (value.length != params[0] && value.length != params[1]) {
				return false;
			}
			return true;
		});
		//15位身份证号码必须是全数字
		$.validator.addMethod("cart15", function(value, element, params) {
			var reg = /^[0-9]{15}$/;
			if (value.length == 15) {
				return reg.test(value);
			}
			return true;
		});
		//18位身份证号码必须是已x结尾
		$.validator.addMethod("cart18", function(value, element, params) {
			var reg = /^[0-9]{16}[0-9]x$/;
			if (value.length == 18) {
				return reg.test(value);
			}
			return true;
		});
		$("#emForm").validate({
			//规则
			rules : {
				//不能为空
				realyName : "required",
				userName : {
					//不能为空
					required : true,
					//长度为5-8个字节
					rangelength : [ 5, 8 ]
				},
				pwd : {
					required : true,
					rangelength : [ 6, 12 ]
				},
				pwd1 : {
					required : true,
					rangelength : [ 6, 12 ],
					//确认密码要和密码一致
					equalTo : "#pwd"
				},
				sex : "required",
				age : {
					required : true,
					//年龄的值在1-150
					range : [ 1, 150 ],
					//年龄必须是整数
					digits : true
				},
				edu : "required",
				birthday : {
					required : true,
					//先校验日期的有效性,再校验日期格式
					date : true,
					dateISO : true,
				},
				hobby : "required",
				email : {
					required : true,
					email : true
				},
				cart : {
					required : true,
					cartlength : [ 15, 18 ],
					cart15 : true,
					cart18 : true
				}
			},
			//错误提示信息
			messages : {
				realyName : "请输入您的真实姓名!",
				userName : {
					required : "登录名不能为空!",
					rangelength : "登录名长度为5-8个字节!"
				},
				pwd : {
					required : "密码不能为空!",
					rangelength : "密码长度为6-12个字节!"
				},
				pwd1 : {
					required : "密码不能为空",
					rangelength : "密码长度为6-12个字节!",
					equalTo : "密码和确认密码不一致!"
				},
				sex : "请选择性别!",
				age : {
					required : "年龄不能为空!",
					//年龄的值在1-150
					range : "年龄必须是1-150岁之间!",
					//年龄必须是整数
					digits : "年龄必须是整数!"
				},
				edu : "请选择学历!",
				birthday : {
					required : "出生日期不能为空!",
					date : "日期不合法!",
					dateISO : "必须符合日期格式yyyy-MM-dd或yyyy/MM/dd!",

				},
				hobby : "至少选择一项兴趣爱好!",
				email : {
					required : "email不能为空!",
					email : "email格式错误"
				},
				cart : {
					required : "请输入身份证号码!",
					cartlength : "身份证号码必须是15或者18位!",
					cart15 : "15位身份证号码必须是全数字!",
					cart18 : "18位身份证号码必须是已x结尾!"
				}
			}
		});
	});
	<%String error = (String) request.getAttribute("error");%>
	function error(){
		var error = '<%=error%>';
		if (error != "null") {
			alert(error);
		}
	}
</script>
</head>
<body  onload="error()">
	<div id="main">
		<form class="cmxform" id="emForm" method="post" action="Register.do">
			<table border="" cellspacing="0" cellpadding="5" align="center" class="registtable">
				<thead align="center" bgcolor="#00FFFF">
					<tr>
						<th colspan="2">读者信息注册</th>
					</tr>
				</thead>
				<tfoot align="center">
					<tr>
						<td colspan="2"><input type="submit" value="提交" /></td>
					</tr>
				</tfoot>
				<tbody align="left">
					<tr>
						<td class="tfist">真实姓名:</td>
						<td><input type="text" name="realyName" id="" value="" /></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="password" name="pwd" id="pwd" value="" /></td>
					</tr>
					<tr>
						<td>确认密码:</td>
						<td><input type="password" name="pwd1" id="" value="" /></td>
					</tr>
					<tr>
						<td>性别:</td>
						<td><input type="radio" name="sex" id="" value="male" />男 <input
							type="radio" name="sex" id="" value="female" />女 <label
							id="sex-error" class="error" for="sex"></label> <!-- 
								 <label for="sex" generated="true" class="error">请选择性别</label>
								 不满足校验规则,表单校验插件会定义一个lable标签,标签中显示错误信息
								 也可以自定手动定义
								 for="sex": 通过name属性值sex找到要校验的标签
								 generated="true"
								 	写上:就会自动在messages中获取填写的错误提示信息
								 	不写:就默认使用label标签中的错误信息
								 --></td>
					</tr>
					<tr>
						<td>年龄:</td>
						<td><input type="text" name="age" id="" value="" /></td>
					</tr>
					<tr>
						<td>你的身份:</td>
						<td><select name="identityId">
								<option value="">-请选择你的身份-</option>
								<option value="2">学生</option>
								<option value="3">老师</option>
								<option value="4">校外人员</option>
						</select></td>
					</tr>
					<tr>
						<td>出生日期:</td>
						<td><input type="text" name="birthday" id="" value="" /></td>
					</tr>
					<tr>
						<td>兴趣爱好:</td>
						<td><input type="checkbox" name="hobby" id="" value="1" />乒乓球
							<input type="checkbox" name="hobby" id="" value="3" />羽毛球 <input
							type="checkbox" name="hobby" id="" value="4" />上网 <input
							type="checkbox" name="hobby" id="" value="5" />旅游 <input
							type="checkbox" name="hobby" id="" value="6" />购物 <label
							id="hobby-error" class="error" for="hobby"></label></td>
					</tr>
					<tr>
						<td>电话:</td>
						<td><input type="text" name="phone" id="" value="" /></td>
					</tr>
					<tr>
						<td>电子邮箱:</td>
						<td><input type="text" name="email" id="" value="" /></td>
					</tr>
					<tr>
						<td>身份证号码(15-18位):</td>
						<td><input type="text" name="cart" id="" value="" /></td>
					</tr>
					<tr>
						<td>备注:</td>
						<td><input type="text" name="remarks" id="" value="" /></td>
					</tr>
				</tbody>

			</table>

		</form>
	</div>
</body>
</html>