<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<!--
	Forty by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Elements - Forty by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
	<link rel="stylesheet" href="assets/css/noscript.css" />
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">
<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<!-- Main -->
		<div id="main" class="alt">

			<!-- One -->
			<section id="one">
				<div class="inner">
					<header class="major">
						<h1>회원 가입</h1>
					</header>



					<hr class="major" />

					<!-- Elements -->
					<div class="row gtr-200">
						<div class="col-6 col-12-medium">

							<!-- Form -->
							<h3>Form</h3>

							<form method="post" action="/mysiteB/user">
							<input type="hidden" name="a" value="join" />
								<div class="row gtr-uniform">
									<div class="col-6 col-12-xsmall">
										<input type="text" name="memname" id="demo-name" value=""
											placeholder="Name" />
									</div>
									<div class="col-6 col-12-xsmall">
										<input type="text" name="memid" id="demo-email" value=""
											placeholder="id" />
									</div>

									<div class="col-6 col-12-xsmall">
										<input type="password" name="mempass" id="demo-name"
											value="" placeholder="password" />
									</div>
									<div class="col-6 col-12-xsmall">
										<input type="password" name="mempass_confirm" id="demo-email"
											value="" placeholder="password 확인" />
									</div>

									<div class="col-4 col-12-small">
										<input type="radio" id="demo-priority-low"
											name="demo-priority" checked> <label
											for="demo-priority-low">여성</label>
									</div>
									<div class="col-4 col-12-small">
										<input type="radio" id="demo-priority-normal"
											name="demo-priority"> <label
											for="demo-priority-normal">남성</label>
									</div>
									<div class="col-6 col-12-xsmall">
										<input type="text" name="memphone" id="demo-name" value=""
											placeholder="phone" />
									</div>
									<div class="col-6 col-12-xsmall">
										<input type="text" name="memadd" id="demo-name" value=""
											placeholder="address" />
									</div>



									<div class="col-12">
										<select name="demo-category" id="demo-category">
											<option value="">- 지역 -</option>
											<option value="1">Manufacturing</option>
											<option value="1">Shipping</option>
											<option value="1">Administration</option>
											<option value="1">Human Resources</option>
										</select>
									</div>


									<div class="col-12">
										<ul class="actions">
											<li><input type="text" value="우편 주소 찾기"
												class="primary" /></li>
											<li></li>
											<li><input type="reset" value="Clear" /></li>
										</ul>
									</div>
									
									
									<div class="col-12">
										<ul class="actions">
											<li><input type="submit" value="등록"
												class="primary" /></li>
										</ul>
									</div>
									

								</div>
							</form>

						</div>
					</div>

				</div>
			</section>

		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>