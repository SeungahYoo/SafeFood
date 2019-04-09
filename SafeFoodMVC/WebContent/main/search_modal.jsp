<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>search</title>
</head>
<body>
 <!-- ########################################## 회원 조회 모달 ########################################## -->
	<div class="modal fade" id="modalRegisterForm2" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">

				<!--Navbar-->
				<nav
					class="navbar navbar-expand-lg navbar-dark teal lighten-2 mb-4 modal-header">

					<!-- Navbar brand -->
					<a class="navbar-brand" href="#">회원 조회</a>

					<!-- Collapsible content -->
					<div class="collapse navbar-collapse" id="navbarSupportedContent">

						<!-- Search form -->
						<form class="form-inline ml-auto" action="/safefood/memberSearch.mvc" method="post">
							<div class="md-form my-0">
								<input class="form-control mr-sm-2" type="text" name="id"
									placeholder="Search" aria-label="Search">
									<input type="submit" class="btn btn-deep-blue" value="검색">
								
							</div>
						</form>
					</div>
					<!-- Collapsible content -->

				</nav>
				<!--/.Navbar-->

				<div class="modal-body mx-3">
					<div class="md-form mb-5">
						<i class="fas fa-user prefix grey-text"></i> <input type="text"
							disabled="disabled" id="orangeForm-name"
							class="form-control validate"> <label data-error="wrong"
							data-success="right" for="orangeForm-name">${m.name}</label>
					</div>
					<div class="md-form mb-5">
						<i class="fas fa-pen prefix grey-text"></i> <input type="text"
							disabled="disabled" id="orangeForm-email"
							class="form-control validate"> <label data-error="wrong"
							data-success="right" for="orangeForm-email">${m.id}</label>
					</div>
					<div class="md-form mb-5">
						<i class="fas fa-pen prefix grey-text"></i> <input type="text"
							disabled="disabled" id="orangeForm-email"
							class="form-control validate"> <label data-error="wrong"
							data-success="right" for="orangeForm-email">${m.address}</label>
					</div>
					<div class="md-form mb-5">
						<i class="fas fa-pen prefix grey-text"></i> <input type="text"
							disabled="disabled" id="orangeForm-email"
							class="form-control validate"> <label data-error="wrong"
							data-success="right" for="orangeForm-email">${m.tel}</label>
					</div>
					<div>
						<i class="fas fa-check prefix grey-text">알레르기</i>
						<c:forEach items="${m.allergies}" var="cur">
							${cur}
						</c:forEach>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ########################################## 회원 조회 모달 끝 ########################################## -->
</body>
</html>