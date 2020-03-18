<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Login</title>

		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="assets/materialize/css/materialize.min.css" media="screen,projection" />
		<!-- Bootstrap Styles-->
		<link href="assets/css/bootstrap.css" rel="stylesheet" />
		<!-- FontAwesome Styles-->
		<link href="assets/css/font-awesome.css" rel="stylesheet" />
		<!-- Morris Chart Styles-->
		<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
		<!-- Custom Styles-->
		<link href="assets/css/custom-styles.css" rel="stylesheet" />
		<!-- Google Fonts-->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
		<link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css">
	</head>

	<body style="background-color: white;">
		
		<div id="page-inner">
			<div class="row">
				<div class="col-lg-4"></div>
				<div class="col-lg-4" style="margin-top: 150px;">
					<div class="card">
						<div class="card-action" style="text-align: center;">
							<h3>登录</h3>
						</div>
						<div class="card-content">
							<form class="col s12" action="loginVerify" method="post">
								<div class="row" style="text-align: center;">
									<c:choose>
										<c:when test="${msg!=null}">
											<p id="msg" style="color: red;text-align: center;">${msg}</p>
										</c:when>
									</c:choose>
									<div class="input-field col s12" style="text-align: left;">
										<input id="icon_prefix" type="text" class="validate" name="username">
										<label for="icon_prefix">username</label>
									</div>
									<div class="input-field col s12" style="text-align: left;">
										<input id="icon_telephone" type="password" class="validate" name="password">
										<label for="icon_telephone">password</label>
									</div>
									<input type="submit" class="waves-effect waves-light btn" value="登录" onclick="return check()" />
								</div>
							</form>
							<div class="clearBoth"></div>
						</div>
					</div>
				</div>
				<div class="col-lg-4"></div>
			<!-- /.row (nested) -->
			</div>
			<!-- /.panel-body -->
		</div>
		
	</body>
	
	<!-- jQuery Js -->
	<script src="assets/js/jquery-1.10.2.js"></script>

	<!-- Bootstrap Js -->
	<script src="assets/js/bootstrap.min.js"></script>

	<script src="assets/materialize/js/materialize.min.js"></script>

	<!-- Metis Menu Js -->
	<script src="assets/js/jquery.metisMenu.js"></script>
	<!-- Morris Chart Js -->
	<script src="assets/js/morris/raphael-2.1.0.min.js"></script>
	<script src="assets/js/morris/morris.js"></script>

	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>

	<script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>

	<!-- Custom Js -->
	<script src="assets/js/custom-scripts.js"></script>

	<script type="text/javascript">
		function check() {
			
			var username = $("[name=username]").val();
			var password = $("[name=password]").val();
			
			if(username == null || username == ""){
				$("#msg").text("用户名不能为空");
				return false;
			}else if(password == null || password == ""){
				$("#msg").text("密码不能为空");
				return false;
			}
			
		}
	</script>

</html>