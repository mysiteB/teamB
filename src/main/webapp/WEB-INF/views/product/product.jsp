<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
						<h1>카테고리</h1>
					</header>



					<hr class="major" />

					<!-- Elements -->
					<div class="col-6 col-12-medium">


						<!-- Lists -->
						<div class="row">


							<div class="col-3 col-3-small">

								<ul>
									<a href="#" class="list-group-item">Category 1</a>
									<br>
									<a href="#" class="list-group-item">Category 2</a>
									<br>
									<a href="#" class="list-group-item">Category 3</a>
								</ul>

							</div>

							<div class="col-9 col-12-medium">


								<form method="post" action="/mysiteB/product">
									<input type="hidden" name="a" value="readProduct" />
									<div class="row">
										<div class="col-6 col-12-small">
											<span class="image fit"><img src="images/pic09.jpg"
												alt="" style="max-width: 100000px; height: auto;" /></span>
										</div>
										<div class="col-6 col-12-small">
										
											<h1>${ProductVo.proName}</h1>

											<h3>
												<b>${ProductVo.proPrice}원</b>
											</h3>


											<h3></h3>


											<section>
												<form method="post" action="#">





													<ul class="actions">

														<form method="post" action="#">
															<li><input type=button value="-"
																onClick="javascript:this.form.amount.value--;"></li>
															<input style="text-align: center; width: 100px" type=text
																name=amount value=1> <input type=button
																value="+" onClick="javascript:this.form.amount.value++;">
														</form>
													</ul>

													<ul class="actions">
														<li><input type="submit" value="장바구니" class="primary" /></li>
														<li><input type="reset" value="구매하기" /></li>
													</ul>

												</form>
											</section>

										</div>

									</div>
							</div>


						</div>

						<hr class="major" />
						<!-- 
						<div class="table-wrapper">
							<table class="alt">
								<thead>
									<tr>
										<th>상품상세</th>
										<th>상품평</th>
										<th>상품문의</th>
										<th>배송/교환/반품 안내</th>
									</tr>
								</thead>


							</table>
						</div>
						 -->


						<div class="row" style="text-align: center">
							<!-- Break -->
							<div class="col-4 col-12-medium">
								<a href="#" class="list-group-item"><b>상품상세</b></a>
							</div>
							<div class="col-4 col-12-medium">
								<a href="/mysiteB/product?a=productReview&pageNum=${ProductVo.proNo}" class="list-group-item"><b>상품평</b></a>
							</div>
							<div class="col-4 col-12-medium">
								<a href="/mysiteB/product?a=productInquiry&pageNum=${ProductVo.proNo}" class="list-group-item"><b>상품문의</b></a>
							</div>
							

						</div>
						
						

						<div class="row"></div>
						
						<hr class="major" />

					</div>


					<p>Nunc lacinia ante nunc ac lobortis. Interdum adipiscing
							gravida odio porttitor sem non mi integer non faucibus ornare mi
							ut ante amet placerat aliquet. Volutpat eu sed ante lacinia
							sapien lorem accumsan varius montes viverra nibh in adipiscing
							blandit tempus accumsan.</p>


				</div>

				<section class="split">
						
				</section>
				<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>


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