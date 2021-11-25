<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.javaex.vo.*"%>
<!DOCTYPE HTML>

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
						<h1>장바구니</h1>
					</header>

					<div class="table-wrapper">
						<table>
							<thead>
								<tr>
									<th>[]</th>
									<th>이미지</th>
									<th>상품 정보</th>
									<th>수량</th>
									<th>적립금</th>
									<th>배송비</th>
									<th>가격</th>
									<th>선택</th>

								</tr>
							</thead>
							<tbody>

								<tr>
									<th><input type="radio"></th>
									<th>~</th>
									<th>치마</th>
									<th>1개</th>
									<th>100원</th>
									<th>2000천원</th>
									<th>18000원</th>
									<th><input type="button" value="주문하기"></th>

								</tr>
								<tr>
								<td colspan="6"></td>
								<td>상품 구매 금액[] + 배송비 [] = []원</td>
								</tr>

								<!--<c:forEach items="${list}" var="vo">
									<tr>
										<th></th>
										<th>~</th>
										<th>1개</th>
										<th>100원</th>
										<th>2000천원</th>
										<th>18000원</th>
										<th><input type="button"  value="작성하기"></th>

									</tr>
								</c:forEach>-->
							</tbody>
							
						</table>
					</div>
					<div class="col-12">
										<ul class="actions">
											<li>선택 상품</li>
											<li><input type="button" value="삭제"></li>
											<li><input type="button" value="전체 비우기"></li>
											
										</ul>
										</div>
					<div class="table-wrapper">
						<table>
							<thead>
								<tr>
									<th>총 상품 금액</th>
									<th>총 배송비</th>
									<th>총 할인 금액</th>
									<th>결제 예정 금액</th>
								</tr>
							</thead>
							<tbody>

								<tr>
									<th>18000원</th>
									<th>+ 2000원</th>
									<th>0원</th>
									<th>=20000원</th>

								</tr>
							</tbody>
							
							
						</table>
						
						<div class="col-12">
										<ul class="actions" style = "">
											
											<li><input type="button" value="전체 상품 주문"></li>
											<li><input type="button" value="선택 상품 주문"></li>
											
										</ul>
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