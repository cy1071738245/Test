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
	</head>

	<body>
		<div class="am-cf admin-main">
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
								<div class="am-input-group am-input-group-sm">
									<input class="am-form-field" name="keyWord" placeholder="请输入部门名称" type="text">
									<span class="am-input-group-btn">
										<button class="am-btn am-btn-default" type="button" id="btnsearch" onclick="search()">
											搜索
										</button>
									</span>
								</div>
							</div>
						</div>

						<div class="am-g" style="margin-top: -30px;">
							<div class="am-u-sm-12">
								<form class="am-form">
									<table class="am-table am-table-striped am-table-hover table-main" id="tDepart">
										<thead>
											<tr>
												<th class="table-check">
													<input id="chkAll" type="checkbox">
												</th>
												<th class="table-id">
													ID
												</th>
												<th class="table-title">
													部门名称
												</th>
												<th class="table-set">
													操作
												</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${departmentList}" var="department">
												<tr>
													<td><input name="chks" value="27" type="checkbox"></td>
													<td>${department.departmentId}</td>
													<td>${department.departmentName}</td>
													<td>
														<div class="am-btn-toolbar">
															<div class="am-btn-group am-btn-group-xs">
																<button type="button" id="depart_1" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit" onclick="updateDepart(${department.departmentId})">
																	<span class="am-icon-pencil-square-o"></span> 编辑
																</button>
																<button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only" onclick="return operateDepart(${department.departmentId})">
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
				/* $(".btnedit").click(function() {
					$.jq_Panel({
						title: "修改部门",
						iframeWidth: 500,
						iframeHeight: 300,
						url: "addDepart"
					});
				}); */
				$(".btnAdd").click(function() {

					$.jq_Panel({
						title: "添加部门",
						iframeWidth: 500,
						iframeHeight: 300,
						url: "addDepart"
					});
				});
			});
			
			function updateDepart(id) {
				$.jq_Panel({
					title: "修改部门",
					iframeWidth: 500,
					iframeHeight: 300,
					url: "addDepart?departmentId="+id
				});
			}
			
			function operateDepart(departmentId) {
				
				var flag = window.confirm("您真的要删除吗？");
				
				if(flag == true){
					$.ajax({
						type:"post",
						url:"operateDepart?departmentId="+departmentId,
						dataType:"text",
						success:function(textStatus){
							if(textStatus == 1){
								//parent.$.jq_Panel_close();
								location.href = "depart";
								alert("职位信息变更成功");
							}else if(textStatus == -1){
								alert("技术部不可删除");
							}else{
								alert("职位信息变更失败");
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
					url:"searchDepart",
					data:{keyWord:$("[name=keyWord]").val()},
					dataType:"json",
					success:function(msg){
						$("#tDepart tbody").text("");
						$(msg).each(function(index,e){
							var data = '<tr>'+
											'<td><input name="chks" value="27" type="checkbox"></td>'+
											'<td>'+e.departmentId+'</td>'+
											'<td>'+e.departmentName+'</td>'+
											'<td>'+
												'<div class="am-btn-toolbar">'+
													'<div class="am-btn-group am-btn-group-xs">'+
														'<button type="button" id="depart_1" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit" onclick="updateDepart('+e.departmentId+')">'+
															'<span class="am-icon-pencil-square-o"></span> 编辑'+
														'</button>'+
														'<button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only" onclick="return operateDepart('+e.departmentId+')">'+
															'<span class="am-icon-trash-o"></span> 删除'+
														'</button>'+
													'</div>'+
												'</div>'+
											'</td>'+
										'</tr>';
							$("#tDepart tbody").append($(data));
						});
					}
				})
			}
		</script>
	</body>

</html>