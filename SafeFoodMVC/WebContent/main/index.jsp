<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>건강한 삶을 응원합니다!</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="${pageContext.request.contextPath}/resources/css/mdb.min.css"
	rel="stylesheet">
<!-- Your custom styles (optional) -->
<link
	href="${pageContext.request.contextPath}/resources/css/style.min.css"
	rel="stylesheet">
<style type="text/css">
html, body, header, .carousel {
	height: 60vh;
}

@media ( max-width : 740px) {
	html, body, header, .carousel {
		height: 100vh;
	}
}

@media ( min-width : 800px) and (max-width: 850px) {
	html, body, header, .carousel {
		height: 100vh;
	}
}

@media ( min-width : 800px) and (max-width: 850px) {
	.navbar:not	(
		.top-nav-collapse
	){
		background:#929FBA	
		!important;
	}
}
</style>
</head>

<body>

	<header>
		<jsp:include page="/header/header.jsp"></jsp:include>
		<!--Carousel Wrapper-->
		<div style="position: relative;">

			<div id="carousel-example-1z"
				class="rgba-black-light carousel slide carousel-fade"
				data-ride="carousel">
				<!--Indicators-->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-1z" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-1z" data-slide-to="1"></li>
					<li data-target="#carousel-example-1z" data-slide-to="2"></li>
					<li data-target="#carousel-example-1z" data-slide-to="3"></li>
				</ol>
				<!--/.Indicators-->

				<!--Slides-->
				<div class="carousel-inner" role="listbox">
					<div class="view carousel-item active"
						style="background-image: url('https://www.lifelinescreening.com/-/media/project/life-line-screening/life-line-screening/6-health-education/articles/diet-and-nutrition/fruits-and-vegetables.jpg?h=1432&la=en&w=2000&hash=6F18108BB5E8283BFD9577DA563347457A3B114A'); background-repeat: no-repeat; background-size: cover;">

					</div>
					<div class="view carousel-item"
						style="background-image: url('https://www.castlighthealth.com/wp-content/uploads/2018/03/HealthyFood.jpg'); background-repeat: no-repeat; background-size: cover;">

					</div>
					<div class="view carousel-item"
						style="background-image: url('http://www.tossd.co.za/Portals/65/Tossd-Salad-Bar.jpg?ver=2018-07-02-113317-257'); background-repeat: no-repeat; background-size: cover;">

					</div>
					<div class="view carousel-item"
						style="background-image: url('https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/background-healthy-food-for-heart-healthy-food-diet-royalty-free-image-876656666-1553267997.jpg'); background-repeat: no-repeat; background-size: cover;">

					</div>
				</div>

			</div>
			<!-- Mask & flexbox options-->
			<!-- Content -->
			<!-- Content -->
			<div
				class="view mask rgba-black-light d-flex justify-content-center align-items-center"
				style="position: absolute; width: 100%; z-index: 10; top: 0px;">
				<div
					class="text-center white-text mx-5 wow fadeIn justify-content-center align-items-center"
					style="position: absolute; width: 100%; z-index: 10; top: 170px; text-align: center; margin: 0px auto;">
					<h1 class="mb-4">
						<strong>건강한 삶을 위한 Safe Food project!</strong>
					</h1>

					<p>
						<strong>당신의 건강한 삶을 응원합니다.</strong>
					</p>

					<p class="mb-4 d-none d-md-block">
						<strong>Made by Dongik & Geuntae & Seungah.</strong>
					</p>

					<div class="md-form" style="margin: 0px auto; width: 500px">
						<input type="text" id="mainSearch" class="form-control"
							style="color: white; width: 500px;"> <label
							for="mainSearch" style="color: white;">식품 검색</label>
					</div>

				</div>
			</div>
		</div>
	</header>

	<!--Main layout-->
	<main>
	<div class="container">

		<!--Section: Main info-->
		<section class="mt-5 wow fadeIn" id="mainList">
			<c:forEach items="${mainList}" var="f">
				<div class="row">
					<div class="col-md-4 mb-2">
						<img src="${pageContext.request.contextPath}/resources/${f.image}"
							class="img-fluid z-depth-1-half">
					</div>
					<div class="col-md-6 mb-4">
						<h3 class="h3 mb-3">
							<a href="/safefood/detail.mvc?code=${f.code}">${f.name}</a>
						</h3>
						<hr>
						<p>${f.maker}</p>
						<hr>
						<p>${f.material}</p>
						<hr>
						<a target="_black" class="addFood btn btn-blue btn-md" onclick="addFood(${f.code},'${f.name}')"> <i
                            class="fas fa-download ml-1"></i>추가
                        </a> <a target="_black" class=" btn btn-blue btn-md"> <i
							class="fas fa-download ml-1"></i>찜
						</a>
					</div>
				</div>
			</c:forEach>
		</section>
		<!--Section: Main info-->

		<hr class="my-5">

	</div>
	</main>
	<!--Main layout-->

	<!--Footer-->
	<footer class="page-footer text-center font-small mt-4 wow fadeIn">

		<!--Call to action-->
		<div class="pt-4">
			<a class="btn btn-outline-white"
				href="https://mdbootstrap.com/docs/jquery/getting-started/download/"
				target="_blank" role="button">Download MDB <i
				class="fas fa-download ml-2"></i>
			</a> <a class="btn btn-outline-white"
				href="https://mdbootstrap.com/education/bootstrap/" target="_blank"
				role="button">Start free tutorial <i
				class="fas fa-graduation-cap ml-2"></i>
			</a>
		</div>
		<!--/.Call to action-->

		<hr class="my-4">

		<!--Copyright-->
		<div class="footer-copyright py-3">
			© 2019 Copyright: <a
				href="https://mdbootstrap.com/education/bootstrap/" target="_blank">
				MDBootstrap.com </a>
		</div>
		<!--/.Copyright-->

	</footer>
	<!--/.Footer-->

	<!-- ########################## Modal part start ########################## -->
     <jsp:include page="register_modal.jsp"></jsp:include><!-- 회원가입 모달 -->
     <jsp:include page="search_modal.jsp"></jsp:include><!-- 회원조회 모달 -->
     <jsp:include page="login_modal.jsp"></jsp:include><!-- 로그인 모달 -->
     <jsp:include page="modify_modal.jsp"></jsp:include><!-- 회원관리 모달 -->
     <jsp:include page="withdraw_confirm_modal.jsp"></jsp:include><!-- 회원탈퇴 확인 모달 -->
     <!-- ########################## Modal part end ########################## -->

	<!-- SCRIPTS -->
	<!-- JQuery -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/mdb.min.js"></script>
	<!-- Initializations -->
	<script type="text/javascript">
		$(document).ready(function() {
			// Animations initialization
			new WOW().init();
			// 식품 검색 기능
			$('#mainSearch').keydown(function(key) {
				if (key.keyCode == 13) {
					var keyword = $(this).val();
					location.href = '/safefood/foodSearch.mvc?word=' + keyword;
				} // end of if
			}); // end of keydown
		});// end of ready
		
		// 식품 섭취 '추가'버튼 클릭 listener
		function addFood(code, name) {
			$.ajax({
				url : '/safefood/addFood.mvc?code=' + code,
				type : 'get',
				success : function(result) {
					console.log(result)
					if (result == 1) {
						alert(name + '이(가) 추가되었습니다');
					} else if (result == 2) {
						alert('로그인하세요');
					}
				},
				error : function(jqXhr, textStatus, errorThrown) {
					console.log(errorThrown);
				}
			});
		}
	</script>
</body>

</html>
