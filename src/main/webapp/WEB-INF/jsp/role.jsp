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
								<div class="am-input-group am-input-group-sm">
									<input class="am-form-field" name="keyWord" placeholder="请输入角色名称" type="text">
									<span class="am-input-group-btn">
									<button class="am-btn am-btn-default" type="button" id="btnsearch" onclick="search()">
										搜索
									</button> </span>
								</div>
							</div>
						</div>

						<div class="am-g" style="margin-top: 5px;">
							<div class="am-u-sm-12">
								<form class="am-form">
									<table class="am-table am-table-striped am-table-hover table-main" id="tRole">
										<thead>
											<tr>
												<th class="table-id">
													<input id="chkAll" type="checkbox">
												</th>

												<th>
													角色名称
												</th>
												<th class="table-title">
													角色描述
												</th>

												<th class="table-set">
													操作
												</th>
											</tr>
										</thead>
										<tbody id="tUser">
											<c:forEach items="${jobInfoList}" var="jobInfo">
												<tr>
													<td><input name="chks" value="${jobInfo.jobInfoId}" type="checkbox"></td>
													<td>
														<a href="javascript:void(0)">${jobInfo.jobInfoName}</a>
													</td>
													<td>
														<c:choose>
															<c:when test="${jobInfo.jobInfoName=='超级管理员'}">
																拥有大部分权限
															</c:when>
															<c:otherwise>拥有部分权限</c:otherwise>
														</c:choose>
													</td>
													<td>
														<div class="am-btn-toolbar">
															<div class="am-btn-group am-btn-group-xs">
																<button type="button" id="role" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit" onclick="updateRole(${jobInfo.jobInfoId})">
																	<span class="am-icon-pencil-square-o"></span> 编辑
																</button>
																<button type="button" onclick="sharesysfun(${jobInfo.jobInfoId});" class="am-btn am-btn-default am-btn-xs am-hide-sm-only">
																	<span class="am-icon-copy"></span> 分配权限
																</button>
																<button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="return operateRole(${jobInfo.jobInfoId})">
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

	</body>
	
	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!--<![endif]-->
	<script type="text/javascript" src="myplugs/js/plugs.js"></script>
	<script>
		$(function() {
			/* $(".btnedit").click(function() {
	
				$.jq_Panel({
					title: "修改角色",
					iframeWidth: 500,
					iframeHeight: 300,
					url: "editRole"
				});
			}); */
			
			$(".btnAdd").click(function(){
			 	
			 	$.jq_Panel({
					title: "添加角色",
					iframeWidth: 500,
					iframeHeight: 300,
					url: "editRole"
				});
			 	
			});
			
		});
		
		function sharesysfun(id){
			location.href="shareRole?jobInfoId="+id;
		}
		
		function updateRole(id){
			
			$.jq_Panel({
				title: "修改角色",
				iframeWidth: 500,
				iframeHeight: 300,
				url: "alterRole?jobInfoId="+id
			});
			
		}
		
		function operateRole(jobInfoId) {
			
			var flag = window.confirm("您真的要删除吗？");
			
			if(flag == true){
				$.ajax({
					type:"post",
					url:"operateRole?jobInfoId="+jobInfoId,
					dataType:"text",
					success:function(textStatus){
						if(textStatus == 1){
							//parent.$.jq_Panel_close();
							location.href = "role";
							alert("职位信息变更成功");
						}else if(textStatus == -1){
							alert("超级管理员不可删除");
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
				url:"searchRole",
				data:{keyWord:$("[name=keyWord]").val()},
				dataType:"json",
				success:function(msg){
					$("#tRole tbody").text("");
					$(msg).each(function(index,e){
						var des = "";
						if(e.jobInfoName=='超级管理员'){
							des = '拥有大部分权限';
						}else{
							des = '拥有部分权限';
						}
						var data = '<tr>'+
									'<td><input name="chks" value="'+e.jobInfoId+'" type="checkbox"></td>'+
										'<td>'+
											'<a href="javascript:void(0)">'+e.jobInfoName+'</a>'+
										'</td>'+
										'<td>'+des+'</td>'+
										'<td>'+
											'<div class="am-btn-toolbar">'+
												'<div class="am-btn-group am-btn-group-xs">'+
													'<button type="button" id="role" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit" onclick="updateRole('+e.jobInfoId+')">'+
														'<span class="am-icon-pencil-square-o"></span> 编辑'+
													'</button>'+
													'<button type="button" onclick="sharesysfun('+e.jobInfoId+');" class="am-btn am-btn-default am-btn-xs am-hide-sm-only">'+
														'<span class="am-icon-copy"></span> 分配权限'+
													'</button>'+
													'<button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="return operateRole('+e.jobInfoId+')">'+
														'<span class="am-icon-trash-o"></span> 删除'+
													'</button>'+
												'</div>'+
											'</div>'+
										'</td>'+
									'</tr>';
						$("#tRole tbody").append($(data));
					});
				}
			})
		}
	</script>

</html>