<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	    <link rel="stylesheet" href="css/amazeui.min.css">
		<link rel="stylesheet" href="css/admin.css">
		<link rel="stylesheet" href="css/app.css">
		<style>
			.admin-main{
				padding-top: 0px;
			}
			.am-form-group{
				margin-bottom: 1.7rem;
				
			}
		</style>
	</head>
	<body>
		<div class="am-cf admin-main" >
			<!-- content start -->
			<div class="admin-content">
				<div class="admin-content-body" >
					<div class="am-g" >
						<form class="am-form am-form-horizontal" id="updatePasswordForm" style="margin-left: -300px; margin-top: 80px; padding-top: 30px;"
							 action="#" method="post" onsubmit="return false" data-am-validator>
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">新密码 </label>
								<div class="am-u-sm-9">
									<input type="password" id="password" placeholder="请输入新密码" name="password" required> 
									<small>输入新密码。</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">重复密码</label>
								<div class="am-u-sm-9">
									<input type="password" id="rePassword" placeholder="请输入重复密码" name="rePassword"  data-equal-to="#doc-vld-pwd-1"  required> 
									<small>输入重复密码。</small>
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input type="submit" class="am-btn am-btn-success" value="修改密码" onclick="return updatePassword()" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
	
	<script src="js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="myplugs/js/plugs.js"></script>
	<script type="text/javascript">
		function updatePassword() {
			
			var password = $("#password").val();
			var rePassword = $("#rePassword").val();
			
			if(password == ""){
				alert("新密码不能为空");
				return false;
			}
			if(rePassword == ""){
				alert("密码确认不能为空");
				return false;
			}
			if(password != rePassword){
				alert("密码确认错误");
				$("#rePassword").val("");
				return false;
			}
			
			var flag = window.confirm("确认修改密码吗");
			
			if(flag == true){
				$.ajax({
					type:"post",
					url:"updatePassword",
					data:$('#updatePasswordForm').serialize(),
					dataType:"text",
					success:function(textStatus){
						if(textStatus == 1){
							parent.location.href = "index";
							alert("密码修改成功");
						}else{
							alert("密码修改失败");
						}
					}
				})
			}else{
				$("#password").val("");
				$("#rePassword").val("");
				return false;
			}
			
		}
	</script>
	
</html>
