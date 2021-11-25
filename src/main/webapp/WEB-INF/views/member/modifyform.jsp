<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
						<h1>회원 정보 수정</h1>
					</header>

					<hr class="major" />


					<div class="row gtr-200">
						<div class="col-6 col-12-medium">

						

							<form class="form-signin" id="mypage-form" name="modifyform"
												method="get" action="/mysiteB/user">
												<input type="hidden" name="a" value="modify" /> <input
													type="hidden" name="no" value="${authUser.memId}" />

								<div class="row gtr-uniform">
									<h3>아이디*</h3>
									<div class="col-6 col-12-xsmall">
										<input type="text" name="demo-name" id="demo-name" value=""
											placeholder="id" />
									</div>
									
									<div></div>
									<h3>비밀 번호*</h3>
									<div class="col-6 col-12-xsmall">
									
										<input type="text" name="demo-email" id="demo-email" value=""
											placeholder="passowrd" />
									</div>
									
									<div></div>
									<h3>비밀 번호 확인*</h3>
									<div class="col-6 col-12-xsmall">
									
										<input type="text" name="demo-email" id="demo-email" value=""
											placeholder="passowrd" />
									</div>
									
									<div></div>
									<h3>이름*</h3>
									<div class="col-6 col-12-xsmall">
									
										<input type="text" name="demo-email" id="demo-email" value=""
											placeholder="name" />
									</div>
									
									
									<div></div>
									<h3>주소</h3>
									<div class="col-6 col-12-xsmall">
									
										<input type="text" name="demo-email" id="demo-email" value=""
											placeholder="주소" />
									</div>
									
									<div></div>
									<h3>휴대전화</h3>
									<div class="col-6 col-12-xsmall">
									
										<input type="text" name="demo-email" id="demo-email" value=""
											placeholder="phone" />
									</div>
									
									
									<!-- Break -->
									<div class="col-12">
										<select name="demo-category" id="demo-category">
											<option value="">- Category -</option>
											<option value="1">Manufacturing</option>
											<option value="1">Shipping</option>
											<option value="1">Administration</option>
											<option value="1">Human Resources</option>
										</select>
									</div>
									<!-- Break -->
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
								</div>
							</form>

							<!-- Box -->
							<h3>[선택] 개인 정보 수집 및 이용 동의</h3>
							<div class="box">
								<p>~~~~~</p>
							</div>
							<div class="row gtr-uniform">
								<div class="col-6 col-12-small">
									<input type="checkbox" id="demo-copy" name="demo-copy">
									<label for="demo-copy">동의 함</label>
								</div>
							</div>

						</div>
					</div>

				</div>
			</section>

		</div>

		<!-- Contact -->
		<section id="contact">
			<div class="inner">
				<section class="split">
					<section>
						<div class="contact-method">
							<span class="icon solid alt fa-envelope"></span>
							<h3>Email</h3>
							<a href="#">information@untitled.tld</a>
						</div>
					</section>
					<section>
						<div class="contact-method">
							<span class="icon solid alt fa-phone"></span>
							<h3>Phone</h3>
							<span>(000) 000-0000 x12387</span>
						</div>
					</section>
					<section>
						<div class="contact-method">
							<span class="icon solid alt fa-home"></span>
							<h3>Address</h3>
							<span>1234 Somewhere Road #5432<br /> Nashville, TN 00000<br />
								United States of America
							</span>
						</div>
					</section>
				</section>
			</div>
		</section>

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