<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="myplugs/css/checkbox.css">
	</head>

	<body>

		<div class="panel panel-default" style="margin: 40px;margin-top: 70px;">
			<div class="panel-header">
				分配权限
			</div>
			<div class="panel-body">
				<div id="dvpagecontent" style="padding: 10px; width: 80%; margin: 0px auto;">
					<div class="content-box">
						<div class="content-box-content">
							<form id="assignAuthorityForm" action="#" method="post" onsubmit="return false">

								<input name="jobInfoId" value="${param.jobInfoId}" type="hidden">

								<c:forEach items="${distributionRightsList}" var="distributionRights">
									<div style="overflow: hidden; margin: 20px auto;">
										<span class="parentChk spcheckbox">
											<input value="1" name="first" class="subchk" type="checkbox">&nbsp;
											<label class="labelfor">
												${distributionRights.first.authorityName}
											</label>
										</span>
	
										<div style="margin: 40px auto 10px 30px; clear: both; overflow: hidden;width:800px;">
	
											<c:forEach items="${distributionRights.second}" var="secondRight">
												<div style="width: 195px; padding: 5px; float: left;">
													<span class="childChk spcheckbox" id="s${secondRight.authorityId}">
														<input value="${secondRight.authorityId}" name="second" class="subchk" type="checkbox">&nbsp;&nbsp;
														<label class="labelfor">
															${secondRight.authorityName}
														</label>
													</span>
		
												</div>
												<div style="float: left; margin: 5px; border-right: 1px solid #efefef; padding: 10px;">
		
												</div>
											</c:forEach>
	
										</div>
									</div>
								</c:forEach>
								<input type="hidden" id="isClick" value="0">
								<input style="display: inline-block; margin-bottom: 0; padding: .5em 1em; vertical-align: middle; font-size: 1.0rem; font-weight: 400; line-height: 1.2; text-align: center; white-space: nowrap; background-image: none; border: 1px solid transparent; border-radius: 0; color: #fff; background-color: #5eb95e; border-color: #5eb95e;" value="分配权限" type="submit" onclick="assignAuthority()">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>

	<script src="js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		$(function() {
			//父级选中 子集联动
			$(".parentChk")
				.click(function() {
					$("#isClick").val(1);
					if(!$(this).hasClass("spcheckbox")) { //如果取消
						$(this).next().find(".childChk,.childchildChk").removeClass(
							"spcheckboxCheck");
						$(this).next().find(".childChk,.childchildChk").addClass("spcheckbox");
						$(this).next().find(".subchk").removeAttr("checked");
						$(this).removeClass("spcheckboxCheck");
						$(this).addClass("spcheckbox");
						$(this).children(0).removeAttr("checked");
					} else {
						$(this).next().find(".childChk,.childchildChk").removeClass(
							"spcheckbox");
						$(this).next().find(".childChk,.childchildChk").addClass(
							"spcheckboxCheck");
						$(this).next().find(".subchk").attr("checked",
							"checked");
						$(this).removeClass("spcheckbox");
						$(this).addClass("spcheckboxCheck");
						$(this).children(0).attr("checked", "checked");
					}
				});

			$(".childChk").click(function() {
				$("#isClick").val(1);
				if($(this).hasClass("spcheckbox")) { //如果子元素取消选中
					var part = $(this).parent().parent();
					part.siblings().removeClass("spcheckbox");
					part.siblings().addClass("spcheckboxCheck");
					part.siblings().find(".subchk").attr("checked", "checked");
					$(this).removeClass("spcheckbox");
					$(this).addClass("spcheckboxCheck");
					$(this).children(0).attr("checked", "checked");
				} else {
					var part = $(this).parent().parent();
					$(this).removeClass("spcheckboxCheck");
					$(this).addClass("spcheckbox");
					$(this).children(0).removeAttr("checked");
					if(part.find(".spcheckboxCheck").length == 0) {
						part.siblings().removeClass("spcheckboxCheck");
						part.siblings().addClass("spcheckbox");
						part.siblings().find(".subchk").removeAttr("checked");
					}
				}
			}); //---------------//子集选中或者取消 父级联动选中或者取消

			$(".childchildChk").click(function() {
				$("#isClick").val(1);
				if($(this).hasClass("spcheckbox")) {
					var part = $(this).parent().parent();
					$(this).removeClass("spcheckbox");
					$(this).addClass("spcheckboxCheck");
					$(this).children(0).attr("checked", "checked");
				} else {
					$(this).removeClass("spcheckboxCheck");
					$(this).addClass("spcheckbox");
					$(this).children(0).removeAttr("checked");
				}
			});
		});
	</script>

	<script type="text/javascript">
		$(function() {
			$.ajax({
				url:"checkAuthority",
				data:{jobInfoId:$("[name=jobInfoId]").val()},
				dataType:"text",
				success:function(authorityIdStr){
					if(authorityIdStr!=null){
						var arr = authorityIdStr.split(',');
						for (x in arr)
						{
							var id = arr[x];
							var part = $("#"+id).parent().parent();
							part.siblings().removeClass("spcheckbox");
							part.siblings().addClass("spcheckboxCheck");
							part.siblings().find(".subchk").attr("checked", "checked");
							$("#"+id).removeClass("spcheckbox");
							$("#"+id).addClass("spcheckboxCheck");
							$("#"+id).children(0).attr("checked", "checked");
						}
					}
				}
			})
		});
		
		function assignAuthority() {
			var isClick = $("#isClick").val();
			if(isClick == 1){
				$.ajax({
					type:"post",
					url:"assignAuthority",
					data:$('#assignAuthorityForm').serialize(),
					dataType:"text",
					success:function(textStatus){
						if(textStatus == 1){
							alert("权限修改成功");
							location.reload(true);
						}else if(textStatus == 0){
							alert("超级管理员权限修改成功");
							setInterval(relogin, 500);
						}else if(textStatus == -1){
							alert("超级管理员基本权限不可修改");
							location.reload(true);
						}else{
							alert("权限修改失败");
							location.reload(true);
						}
					}
				})
			}else{
				alert("权限并未做修改");
			}
		}
		
		function relogin() {
			parent.location.href="logout";
			alert("管理员权限发生变化，请重新登录！");
		}
	</script>

</html>