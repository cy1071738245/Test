<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>后台</title>
<link rel="stylesheet" href="css/amazeui.min.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/app.css">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="assets/materialize/css/materialize.min.css" media="screen,projection" />
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/custom-styles.css" rel="stylesheet" />

<style>
.admin-main {
	padding-top: 0px;
}
.admin-parent {
	height: 47.4px;
	font-size: 16px;
	padding-top: 1px;
	padding-bottom: 4px;
}
</style>
</head>

<body>


	<header class="am-topbar am-topbar-inverse admin-header">
		<div class="am-topbar-brand">
			<strong>后台</strong> <small>管理系统</small>
		</div>
		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
			data-am-collapse="{target: '#topbar-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>
		<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

			<ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
				<li>
					<a class="dropdown-button waves-effect waves-dark" href="#" data-activates="dropdown1"><i class="fa fa-user fa-fw"></i> <b>${employee.employeeNickname}</b> <i class="material-icons right">arrow_drop_down</i></a>
				</li>
			</ul>
			<ul id="dropdown1" class="dropdown-content">
				<li>
					<a href="logout"><i class="fa fa-sign-out fa-fw"></i> 注销</a>
				</li>
			</ul>
		</div>
	</header>

	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
			<div class="am-offcanvas-bar admin-offcanvas-bar">
				<ul class="am-list admin-sidebar-list">
					<li class="admin-parent"><a class="am-cf" style="text-decoration: none;" href="admin-index.html"
						target="right"><span class="am-icon-file"></span> 首页<span
							class="am-icon-angle-right am-fr am-margin-right"></span> </a></li>
							
					<c:forEach items="${employee.jobInfo.authorityJobList}" var="authorityJob">
						<li class="admin-parent"><a class="am-cf" style="text-decoration: none;" href="${authorityJob.authority.urlCode}"
							target="right"><span class="am-icon-file"></span> ${authorityJob.authority.authorityName}<span
								class="am-icon-angle-right am-fr am-margin-right"></span> </a></li>
					</c:forEach>
					
				</ul>
				<div class="am-panel am-panel-default admin-sidebar-panel">
					<div class="am-panel-bd">
						<p>
							<span class="am-icon-bookmark"></span> 公告
						</p>
						<p>欢迎使用管理系统</p>
					</div>
				</div>

			</div>
		</div>
		<!-- sidebar end -->

		<!-- content start -->
		<div class="admin-content">
			<div class="admin-content-body">
				<iframe src="" width="100%" height="1100" name="right"
					style="border: none;">
				</iframe>
			</div>
		</div>

	</div>
	<!-- content end -->

	</div>

	<a href="#"
		class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
		data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

	<footer>
		<hr>
		<p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under
			MIT license.</p>
	</footer>

</body>

<!--[if lt IE 9]>
		<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
		<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
		<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
		<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="js/jquery-1.11.3.min.js"></script>
<!--<![endif]-->
<script src="js/amazeui.min.js"></script>
<script src="js/app.js"></script>
<script type="text/javascript" src="myplugs/js/plugs.js"></script>
<script type="text/javascript">
	//添加编辑弹出层
	function updatePwd(title, id) {
		$.jq_Panel({
			title : title,
			iframeWidth : 500,
			iframeHeight : 300,
			url : "updatePwd"
		});
	}
</script>

<script src="assets/materialize/js/materialize.min.js"></script>

</html>