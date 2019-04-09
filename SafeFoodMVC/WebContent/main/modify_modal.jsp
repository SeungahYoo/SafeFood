<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>modify</title>

</head>
<body>
<!-- ########################################## 회원수정 모달  ########################################## -->
	<div class="modal fade" id="modalRegisterForm3" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<form action="/safefood/memberModify.mvc" method="post">
				<div class="modal-content">
					<div class="modal-header text-center">
						<h4 class="modal-title w-100 font-weight-bold">회원 수정</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body mx-3">
						<div class="md-form mb-5">
							<i class="fas fa-user prefix grey-text"></i> <input type="text"
								name="name" id="orangeForm-name" class="form-control validate" value="${m.name}">
							<label data-error="wrong" data-success="right"
								for="orangeForm-name">${m.name }</label>
						</div>
						<div class="md-form mb-5">
							<i class="fas fa-pen prefix grey-text"></i> <input type="text"
								name="id" id="orangeForm-email" class="form-control validate" disabled="disabled" value="${m.id}">
							<label data-error="wrong" data-success="right"
								for="orangeForm-email">${m.id }</label>
						</div>
						<div class="md-form mb-4">
							<i class="fas fa-lock prefix grey-text"></i> <input
								type="password" id="orangeForm-pass" name="password" value="${m.password}"
								class="form-control validate"> <label data-error="wrong"
								data-success="right" for="orangeForm-pass">${m.password }</label>
						</div>
						<div class="md-form mb-4">
							<i class="fas fa-home prefix grey-text"></i> <input type="text"
								name="address" id="orangeForm-pass" value="${m.address}"
								class="form-control validate"> <label data-error="wrong"
								data-success="right" for="orangeForm-pass">${m.address }</label>
						</div>
						<div class="md-form mb-4">
							<i class="fas fa-phone prefix grey-text"></i> <input type="text"
								name="tel" id="orangeForm-pass" class="form-control validate" value="${m.tel}">
							<label data-error="wrong" data-success="right"
								for="orangeForm-pass">${m.tel }</label>
						</div>
						<div>
							<div class="md-form mb-4">
								<i class="fas fa-check prefix grey-text"></i> <input type="text"
									id="orangeForm-pass" disabled="disabled"
									class="form-control validate"> <label
									data-error="wrong" data-success="right" for="orangeForm-pass">알레르기: 
									<c:forEach items="${m.allergies}" var="cur">
										${cur}
									</c:forEach>
						</label>
							</div>
							<div>
								<input type="checkbox" id="대두" name="allergies" value="대두"
									checked> <label for="대두">대두</label>
							</div>
							<div>
								<input type="checkbox" id="땅콩" name="allergies" value="땅콩"
									checked> <label for="땅콩">땅콩</label>
							</div>
							<div>
								<input type="checkbox" id="우유" name="allergies" value="우유"
									checked> <label for="우유">우유</label>
							</div>
							<div>
								<input type="checkbox" id="게" name="allergies" value="게" checked>
								<label for="게">게</label>
							</div>
							<div>
								<input type="checkbox" id="새우" name="allergies" value="새우"
									checked> <label for="새우">새우</label>
							</div>
							<div>
								<input type="checkbox" id="참치" name="allergies" value="참치"
									checked> <label for="참치">참치</label>
							</div>
							<div>
								<input type="checkbox" id="연어" name="allergies" value="연어"
									checked> <label for="연어">연어</label>
							</div>
							<div>
								<input type="checkbox" id="쑥" name="allergies" value="쑥" checked>
								<label for="쑥">쑥</label>
							</div>
							<div>
								<input type="checkbox" id="소고기" name="allergies" value="소고기"
									checked> <label for="소고기">소고기</label>
							</div>
							<div>
								<input type="checkbox" id="닭고기" name="allergies" value="닭고기"
									checked> <label for="닭고기">닭고기</label>
							</div>
							<div>
								<input type="checkbox" id="돼지고기" name="allergies" value="돼지고기"
									checked> <label for="돼지고기">돼지고기</label>
							</div>
							<div>
								<input type="checkbox" id="복숭아" name="allergies" value="복숭아"
									checked> <label for="복숭아">복숭아</label>
							</div>
							<div>
								<input type="checkbox" id="민들레" name="allergies" value="민들레"
									checked> <label for="민들레">민들레</label>
							</div>
							<div>
								<input type="checkbox" id="계란흰자" name="allergies" value="계란흰자"
									checked> <label for="계란흰자">계란흰자</label>
							</div>
						</div>
					</div>
					<div class="modal-footer d-flex justify-content-center">
						<input type="submit" class="btn btn-deep-orange" value="수정">
						<input type="text" name="Signup" value="Signup" style="display: none">
					</div>
					
                            <p class="font-small grey-text d-flex justify-content-end">
						회원 탈퇴 하고 싶으십니까? <a href="#" class="blue-text ml-1"
							data-dismiss="modal" data-toggle="modal"
							data-target="#modalwithdraw">회원 탈퇴</a>
					</p>  
				</div>
			</form>
		</div>
	</div>
	<!-- ########################################## 회원가입 모달 끝 ########################################## -->

</body>
</html>