<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>

		<link rel="stylesheet" href="css/amazeui.min.css">
		<link rel="stylesheet" href="css/admin.css">
		<link rel="stylesheet" href="css/app.css">
		<style>
			.admin-main {
				padding-top: 0px;
			}
		</style>
	</head>

	<body>

		<div class="am-cf admin-main">
			<!-- content start -->
			<div class="admin-content">
				<div class="admin-content-body">
					<div class="am-g">
						<form class="am-form am-form-horizontal" id="operateUserForm" action="#" method="post" style="padding-top: 30px;" onsubmit="return false">
							<input value="${param.employeeId}" name="employeeId" type="hidden">
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								用户名
								</label>
								<div class="am-u-sm-9">
									<input id="employeeUsername" required="required" placeholder="请输入用户名" name="employeeUsername" type="text" onblur="return checkEmployeeUsername()">
									<small id="username">输入用户名。</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								姓名
								</label>
								<div class="am-u-sm-9">
									<input id="employeeRealname" required="required" placeholder="请输入姓名" name="employeeRealname" type="text">
									<small id="realname">输入姓名。</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								昵称
								</label>
								<div class="am-u-sm-9">
									<input id="employeeNickname" required="required" placeholder="请输入昵称" name="employeeNickname" type="text" onblur="return checkEmployeeNickname()">
									<small id="nickname">输入昵称。</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								电话
								</label>
								<div class="am-u-sm-9">
									<input id="employeePhone" required="required" placeholder="请输入电话" name="employeePhone" type="text">
									<small id="phone">输入电话。</small>
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
										职位
								</label>
								<div class="am-u-sm-9">
									<select name="jobInfoId" required>
										<c:forEach items="${jobInfoList}" var="jobInfo">
											<option value="${jobInfo.jobInfoId}">
												${jobInfo.jobInfoName}
											</option>
										</c:forEach>
									</select>
									<small>职位</small>
								</div>
							</div>

							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input id="addRole" class="am-btn am-btn-success" value="提交" type="submit" onclick="return operateUser()">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>

	<script src="js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		function operateUser() {
			
			var employeeUsername = $("#employeeUsername").val();
			var employeeRealname = $("#employeeRealname").val();
			var employeeNickname = $("#employeeNickname").val();
			var employeePhone = $("#employeePhone").val();
			
			if(employeeUsername == ""){
				alert("用户名不能为空");
				return false;
			}
			if(employeeRealname == ""){
				alert("姓名不能为空");
				return false;
			}
			if(employeeNickname == ""){
				alert("昵称不能为空");
				return false;
			}
			if(employeePhone == ""){
				alert("电话不能为空");
				return false;
			}
			
			$.ajax({
				type:"post",
				url:"operateUser",
				data:$('#operateUserForm').serialize(),
				dataType:"text",
				success:function(textStatus){
					if(textStatus == 1){
						parent.location.href = "user";
						alert("员工信息变更成功");
					}else{
						alert("员工信息变更失败");
					}
				}
			})
		}
		
		function checkEmployeeUsername() {
			
			$.ajax({
				url:"checkEmployeeUsername",
				data:{employeeUsername:$("[name=employeeUsername]").val()},
				dataType:"text",
				success:function(textStatus){
					if(textStatus == 1){
						$("#username").text("用户名重复");
						$("#employeeUsername").val("");
						return false;
					}else{
						$("#username").text("输入用户名。");
					}
				}
			});
			
		}
		
		function checkEmployeeNickname() {
			
			$.ajax({
				url:"checkEmployeeNickname",
				data:{employeeNickname:$("[name=employeeNickname]").val()},
				dataType:"text",
				success:function(textStatus){
					if(textStatus == 1){
						$("#nickname").text("昵称重复");
						$("#employeeNickname").val("");
						return false;
					}else{
						$("#nickname").text("输入昵称。");
					}
				}
			});
			
		}
	</script>

</html>