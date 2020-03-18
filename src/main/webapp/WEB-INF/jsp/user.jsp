<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>员工管理</title>

		<link rel="stylesheet" href="css/amazeui.min.css">
		<link rel="stylesheet" href="css/admin.css">
		<link rel="stylesheet" href="css/app.css">
	</head>

	<body>

		<div class="am-cf admin-main" >
			<!-- content start -->
			<div class="admin-content">
				<div class="admin-content-body">
					
					<div class="container" style="padding: 50px 10px 0px 10px">
						<div class="am-g">
							<div class="am-u-sm-12 am-u-md-6">
								<div class="am-btn-toolbar">
									<div class="am-btn-group am-btn-group-xs">
										<button type="button" class="am-btn am-btn-default btnAdd">
											<span class="icon-plus"></span> 新增
										</button>
									</div>
								</div>
							</div>
							<div class="am-u-sm-12 am-u-md-3">
								
							</div>
							
							<div class="am-u-sm-12 am-u-md-3">
								<div class="am-input-group am-input-group-sm">
									<input class="am-form-field" name="keyWord" placeholder="请输入员工姓名" type="text">
									<span class="am-input-group-btn">
									<button class="am-btn am-btn-default" type="button" id="btnsearch" onclick="search()">
										搜索
									</button> </span>
								</div>
							</div>
						</div>
						<div class="am-g" style="margin-top: -30px;">
							<div class="am-u-sm-12">
								<form class="am-form" action="user/delAll.action">
									<table class="am-table am-table-striped am-table-hover table-main" id="tUser">
										<thead>
											<tr>
												<th class="table-check">
													<input id="chkAll" type="checkbox">
												</th>
												<th class="table-id">
													ID
												</th>
												<th>
													用户名
												</th>
												<th class="table-title">
													昵称
												</th>
												<th>
													职位
												</th>
												<th>
													部门名称
												</th>
												<th>
													电话
												</th>
												<th class="table-set">
													操作
												</th>
											</tr>
										</thead>
										<tbody id="tUser">
											<c:forEach items="${userList}" var="user">
												<tr>
													<td><input name="ids" value="1" type="checkbox"></td>
													<td>${user.employeeId}</td>
													<td>${user.employeeUsername}</td>
													<td>
														<a href="#">${user.employeeNickname}</a>
													</td>
													<td><span class="am-badge am-badge-secondary">${user.jobInfo.jobInfoName}</span></td>
													<td>${user.department.departmentName}</td>
													<td>${user.employeePhone}</td>
													<td>
														<div class="am-btn-toolbar">
															<div class="am-btn-group am-btn-group-xs">
																<button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary btnEdit" onclick="updateUser(${user.employeeId})">
																	<span class="am-icon-pencil-square-o"></span> 编辑
																</button>
																<button type="button" class="am-btn am-btn-default am-btn-xs am-hide-sm-only" onclick="return resetPassword(${user.employeeId})">
																	<span class="am-icon-copy"></span> 重置密码
																</button>
																<button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="return operateUser(${user.employeeId},${user.jobInfo.jobInfoId})">
																	<span class="am-icon-trash-o"></span> 删除
																</button>
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>

								</form>
							</div>
						</div>
					</div>

				</div>
				<!-- content end -->
			</div>
		</div>

		<!--[if lt IE 9]>
		<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
		<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
		<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
		<![endif]-->

		<!--[if (gte IE 9)|!(IE)]><!-->
		<script src="js/jquery-1.11.3.min.js"></script>
		<!--<![endif]-->
		<script type="text/javascript" src="myplugs/js/plugs.js"></script>
		<script>
			$(function() {
				$(".btnAdd").click(function() {
					$.jq_Panel({
						title: "添加用户",
						url: "addUser",
						iframeWidth: 800,
						iframeHeight: 600,
					});
				});

				/* $(".btnEdit").click(function() {
					$.jq_Panel({
						title: "编辑用户",
						url: "addUser",
						iframeWidth: 800,
						iframeHeight: 600,
					});

				}); */
			});
			
			function updateUser(id){
				
				$.jq_Panel({
					title: "编辑用户",
					iframeWidth: 800,
					iframeHeight: 600,
					url: "addUser?employeeId="+id
				});
				
			}
			
			function operateUser(employeeId,jobInfoId) {
				
				var flag = window.confirm("您真的要删除吗？");
				
				if(flag == true){
					$.ajax({
						type:"post",
						url:"operateUser?employeeId="+employeeId+"&jobInfoId="+jobInfoId,
						dataType:"text",
						success:function(textStatus){
							if(textStatus == 1){
								location.href = "user";
								alert("员工信息变更成功");
							}else if(textStatus == -1){
								alert("超级管理员不可删除")
							}else{
								alert("员工信息变更失败");
							}
						}
					})
				}else{
					return false;
				}
				
			}
			
			function resetPassword(employeeId) {
				
				var flag = window.confirm("确认重置密码为'000000'吗");
				
				if(flag == true){
					$.ajax({
						type:"post",
						url:"resetPassword?employeeId="+employeeId,
						dataType:"text",
						success:function(textStatus){
							if(textStatus == 1){
								alert("重置密码成功");
							}else{
								alert("重置密码失败");
							}
						}
					})
				}else{
					return false;
				}
				
			}
			
			function search() {
				$.ajax({
					type:"post",
					url:"searchUser",
					data:{keyWord:$("[name=keyWord]").val()},
					dataType:"json",
					success:function(msg){
						$("#tUser tbody").text("");
						$(msg).each(function(index,e){
							var data = '<tr>'+
										'<td><input name="ids" value="1" type="checkbox"></td>'+
										'<td>'+e.employeeId+'</td>'+
										'<td>'+e.employeeUsername+'</td>'+
										'<td>'+
											'<a href="#">'+e.employeeNickname+'</a>'+
										'</td>'+
										'<td><span class="am-badge am-badge-secondary">'+e.jobInfo.jobInfoName+'</span></td>'+
										'<td>'+e.department.departmentName+'</td>'+
										'<td>'+e.employeePhone+'</td>'+
										'<td>'+
											'<div class="am-btn-toolbar">'+
												'<div class="am-btn-group am-btn-group-xs">'+
													'<button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary btnEdit" onclick="updateUser('+e.employeeId+')">'+
														'<span class="am-icon-pencil-square-o"></span> 编辑'+
													'</button>'+
													'<button type="button" class="am-btn am-btn-default am-btn-xs am-hide-sm-only" onclick="return resetPassword('+e.employeeId+')">'+
														'<span class="am-icon-copy"></span> 重置密码'+
													'</button>'+
													'<button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="return operateUser('+e.employeeId+','+e.jobInfo.jobInfoId+')">'+
														'<span class="am-icon-trash-o"></span> 删除'+
													'</button>'+
												'</div>'+
											'</div>'+
										'</td>'+
									'</tr>'
							$("#tUser tbody").append($(data));
						});
					}
				})
			}
		</script>
	</body>

</html>