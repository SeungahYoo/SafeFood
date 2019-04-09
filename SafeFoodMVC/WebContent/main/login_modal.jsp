<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>login</title>
<!-- SCRIPTS -->
<!-- JQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/main/js/jquery-3.3.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="${pageContext.request.contextPath}/main/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/main/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/main/js/mdb.min.js"></script>
<script type="text/javascript">
	// 로그인 버튼 클릭 listener
	function loginClick(){
    	var login_data= {
        		id : $("#loginId").val(),
            	pass : $("#loginPass").val()
        };

    	$.ajax({
            type:"POST",
            url:"/safefood/login.mvc",
            data : login_data,
            success:function(response){  
                if (response == 1) { // 로그인 성공시 
                   $("#elegantModalForm").modal("hide");
               	alert("정상적으로 로그인되었습니다!");
                   location.href = "/safefood/main.mvc";
                } else { //로그인 실패시 
                	alert("아이디나 비밀번호가 다릅니다.");
                }
            },
            error:function(xhr, status, error) {
                console.log(xhr.status + " : " + error + " : " + xhr.responseText);
            }
        });
    }
    </script>
</head>
<body>
<!-- ########################################## 로그인 모달 ########################################## -->
	
	<div class="modal fade" id="elegantModalForm" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<!--Content-->
			<div class="modal-content form-elegant">
				<!--Header-->
				<div class="modal-header text-center">
					<h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3"
						id="myModalLabel">
						<strong>Log in</strong>
					</h3>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<!--Body-->
				<div class="modal-body mx-4">
					<!--Body-->
					<div class="warning"></div>
					<div class="md-form mb-5">
						<input type="text" name = "id" id="loginId" class="form-control validate">
						<label data-error="wrong" data-success="right" for="Form-email1">Your
							ID</label>
					</div>
					<div class="md-form pb-3">
						<input type="password" name = "pass" id="loginPass"
							class="form-control validate"> <label data-error="wrong"
							data-success="right" for="Form-pass1">Your password</label>
						<p class="font-small blue-text d-flex justify-content-end">
							Forgot <a href="#" class="blue-text ml-1"> Password?</a>
						</p>
					</div>
				<div class="modal-footer mx-5 pt-3 mb-1">
					 <button class="btn btn-lg btn-primary btn-block" id="btnLogin" onclick="loginClick()">login</button>
				</div>
					
				</div>
				<!--Footer-->
				
				<div class="modal-footer mx-5 pt-3 mb-1">
					<p class="font-small grey-text d-flex justify-content-end">
						Not a member? <a href="#" class="blue-text ml-1"
							data-dismiss="modal" data-toggle="modal"
							data-target="#modalRegisterForm"> Sign Up</a>
					</p>
				</div>
			</div>
			<!--/.Content-->
		</div>
	</div>
	<!-- ########################################## 로그인 모달 끝 ########################################## -->
</body>
</html>