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
			.admin-main{
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
						<form class="am-form am-form-horizontal" id="operateDepartForm" action="#" method="post" style="padding-top: 30px;">
							<input value="${param.departmentId}" name="departmentId" type="hidden">
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
									部门名称
								</label>
								<div class="am-u-sm-9">
									<input id="departmentName" required="required" placeholder="请输入部门名称" name="departmentName" type="text" onblur="return checkDepartName()">
									<small id="name">输入部门名称。</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
									部门描述
								</label>
								<div class="am-u-sm-9">
									<textarea cols="50" placeholder="可不输入" name="departmentDesc"></textarea>
									<small>部门描述。</small>
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input id="addRole" class="am-btn am-btn-success" value="编辑部门" type="button" onclick="return operateDepart()">
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
		function operateDepart() {
			
			var departmentName = $("#departmentName").val();
			
			if(departmentName == ""){
				alert("部门名称不能为空");
				return false;
			}
			
			$.ajax({
				type:"post",
				url:"operateDepart",
				data:$('#operateDepartForm').serialize(),
				dataType:"text",
				success:function(textStatus){
					if(textStatus == 1){
						parent.location.href = "depart";
						alert("部门信息变更成功");
					}else{
						alert("部门信息变更失败");
					}
				}
			})
		}
		
		function checkDepartName() {
			
			$.ajax({
				url:"checkDepartName",
				data:{departmentName:$("[name=departmentName]").val()},
				dataType:"text",
				success:function(textStatus){
					if(textStatus == 1){
						$("#name").text("部门名重复");
						$("#departmentName").val("");
						return false;
					}else{
						$("#name").text("输入部门名称。");
					}
				}
			});
			
		}
	</script>
	
</html>
