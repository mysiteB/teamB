<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.javaex.dao.ReviewDaoImpl"%>
<%@page import="com.javaex.dao.ReviewDao"%>
<%@ page import="java.util.*"%>
<%
List reviewList = (List) request.getAttribute("revList");
int total_record = ((Integer) request.getAttribute("total_record")).intValue();
int pageNum = ((Integer) request.getAttribute("pageNum")).intValue();
int total_page = ((Integer) request.getAttribute("total_page")).intValue();
%>

<!DOCTYPE HTML>
<!--
	Forty by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
$(function() {
	$('#onDisplay1').click(function() {
		if($("#noneDiv1").css("display") == "none"){
			$('#noneDiv1').show();
			$('#noneDiv2').hide();
			$('#noneDiv3').hide();
		}else if ($("onDisplay1").css("display") != "none"){
			$('#noneDiv1').hide();
		}
		
	});
	$('#onDisplay2').click(function() {
		if($("#noneDiv2").css("display") == "none"){
			$('#noneDiv1').hide();
			$('#noneDiv2').show();
			$('#noneDiv3').hide();
		}else if ($("onDisplay2").css("display") != "none"){
			$('#noneDiv2').hide();
		}
		
	});
	$('#onDisplay3').click(function() {
		if($("#noneDiv3").css("display") == "none"){
			$('#noneDiv1').hide();
			$('#noneDiv2').hide();
			$('#noneDiv3').show();
		}else if ($("onDisplay3").css("display") != "none"){
			$('#noneDiv3').hide();
		}
		
	});
	

});
</script>
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


								<!-- 
								
								<p>
									<span class="image left"><img src="images/pic09.jpg" alt="" /></span>
									<h4>상품 이름</h4>
									
									<h4><b>2000원</b></h4>
									
									
									<h4> </h4>
									
									<div class="inner">
										<section>
											<form method="post" action="#">
												
												<ul class="actions">
												
													<form method="post" action="#">
														<input type=button value="-" onClick="javascript:this.form.amount.value--;">
														<input style="text-align:center" type=text name=amount value=1>
														<input type=button value="+" onClick="javascript:this.form.amount.value++;">
													</form>
													
													<li><input type="submit" value="장바구니" class="primary" /></li>
													<li><input type="reset" value="구매하기" /></li>
												</ul>
												
											</form>
										</section>
									</div>
								</p>
								
								-->



								<div class="row">
									<div class="col-6 col-12-small">
										<span class="image fit"><img src="images/pic09.jpg"
											alt="" style="max-width: 100000px; height: auto;" /></span>
									</div>
									<div class="col-6 col-12-small">
										<h1>${ProductVo.proName }</h1>

										<h3>
											<b>${ProductVo.proPrice}원</b>
										</h3>


										<h3></h3>


										<section>
											<form method="post" action="#">





												<ul class="actions">

													<form method="post" action="#">
														<li><input type=button value="-" onClick="javascript:this.form.amount.value--;"></li>
														<input style="text-align: center; width: 100px"  type=text name=amount value=1>
														<input type=button value="+" onClick="javascript:this.form.amount.value++;">
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
			
						<div class="row" style="text-align: center">
							<!-- Break -->
							<div class="col-4 col-12-medium">
								<a class="list-group-item" id = "onDisplay1" style="font-weight: bold">상품상세</a>
							</div>
							<div class="col-4 col-12-medium">
								<a class="list-group-item" id = "onDisplay2" style="font-weight: bold">상품평</a>
							</div>
							<div class="col-4 col-12-medium">
								<a class="list-group-item" id = "onDisplay3" style="font-weight: bold">상품문의</a>
							</div>
							

						</div>
						

						<div class="row"></div>
						
						<hr class="major" />

					</div>
					<div id = "noneDiv1" style="display: ;">${ProductVo.proDesc }</div>
					
					<div id = "noneDiv2" style="display: none;">
					<form id="search_form" action="" method="post">
						<input type="hidden" name="a" value="search"> 
							<select name="items" class="txt" style = "width: auto">
								<option value="인기순">인기순</option>
								<option value="신규 등록순">신규 등록순</option>
							</select>
					</form>


					<section class="split">
						<c:forEach items="${revlist}" var ="revList" >
						<section>
							<div class="contact-method">
								<span class="icon solid alt"><img src="images/사람.png"
									alt="" style="max-width: 2em; height: auto;" /></span>
								<h6>
									${revList.memId}<br>${revList.rate}&nbsp&nbsp${revList.revDate}
								</h6>
								<br>
								<div class="col-4">
									<span class="image fit"><img src="images/pic09.jpg"
										alt="" style="width: 200px; height: auto" /></span>
								</div>
								<p>${revList.content}</p>
							</div>
						</section>
						<hr class="major" />
						</c:forEach>
						
				</div>


				</div>


				


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