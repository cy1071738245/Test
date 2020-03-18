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
						<form class="am-form am-form-horizontal" id="operateRoleForm" action="#" method="post" style="padding-top: 30px;" onsubmit="return false">
							<input value="${param.jobInfoId}" name="jobInfoId" type="hidden">
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
									职位名称
								</label>
								<div class="am-u-sm-9">
									<input id="jobInfoName" required="required" placeholder="请输入角色名称" name="jobInfoName" type="text" onblur="return checkJobInfoName()">
									<small id="name">输入职位名称</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
									部门
								</label>
								<div class="am-u-sm-9">
									<select name="departmentId" required>
										<c:forEach items="${departmentList}" var="department">
											<option value="${department.departmentId}">
												${department.departmentName}
											</option>
										</c:forEach>
									</select>
									<small>部门</small>
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input id="addRole" class="am-btn am-btn-success" value="编辑角色" type="submit" onclick="return operateRole()">
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
		function operateRole() {
			
			var jobInfoName = $("#jobInfoName").val();
			
			if(jobInfoName == ""){
				alert("职位名称不能为空");
				return false;
			}
			
			$.ajax({
				type:"post",
				url:"operateRole",
				data:$('#operateRoleForm').serialize(),
				dataType:"text",
				success:function(textStatus){
					if(textStatus == 1){
						//parent.$.jq_Panel_close();
						parent.location.href = "role";
						alert("职位信息变更成功");
					}else{
						alert("职位信息变更失败");
					}
				}
			})
			
		}
		
		function checkJobInfoName() {
			
			$.ajax({
				url:"checkJobInfoName",
				data:{jobInfoName:$("[name=jobInfoName]").val()},
				dataType:"text",
				success:function(textStatus){
					if(textStatus == 1){
						$("#name").text("职位名重复");
						$("#jobInfoName").val("");
						return false;
					}else{
						$("#name").text("输入职位名称。");
					}
				}
			});
			
		}
		
		/* $(function() {
			$.ajax({
				url:"dropDownMenuDepart",
				dataType:"json",
				success:function(data){
					var list = eval(data);
					$.each(index,item){
						
				    }
				}
			})
		}); */
	</script>
	
</html>
