<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>건강한 삶을 응원합니다!</title>
<!-- Font Awesome -->
<link rel="stylesheet"	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="${pageContext.request.contextPath}/resources/css/mdb.min.css" rel="stylesheet">
<!-- Your custom styles (optional) -->
<link href="${pageContext.request.contextPath}/resources/css/style.min.css" rel="stylesheet">
</head>

<body>

  <!-- Navbar -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
    <!-- <nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar"> -->
      <div class="container">

        <!-- Brand -->
         <img class="image" alt="ssafy" src="${pageContext.request.contextPath}/resources/img/ssafy_logo.png" style="width:60px;heigh:60px">
         <a class="navbar-brand" href="../resources/index.html"
             target="_blank">
         </a>

        <!-- Collapse -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Links -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

          <!-- Left -->
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/main.mvc">메 인
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="https://mdbootstrap.com/docs/jquery/" target="_blank">공지 사항</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/foodlist/index.jsp" target="_blank">식품 목록</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="https://mdbootstrap.com/education/bootstrap/" target="_blank">베스트 섭취량 정보</a>
            </li>
            <%if(session.getAttribute("id") != null){ %>
	            <li class="nav-item">
	              <a class="nav-link" href="/safefood/myfoodlist.mvc" target="_blank">내 섭취 정보</a>
	            </li>
            <%} %>
            <li class="nav-item">
              <a class="nav-link" href="https://mdbootstrap.com/education/bootstrap/" target="_blank">예상 섭취 정보</a>
            </li>
          </ul>

          <!-- Right -->
          <ul class="navbar-nav nav-flex-icons">
          	 <% if(session.getAttribute("id") == null){ %>
                <li style="padding:3px"class="nav-item"><a
                    href="https://github.com/mdbootstrap/bootstrap-material-design"
                    class="nav-link border border-light rounded" target="_blank"
                    data-toggle="modal" data-target="#elegantModalForm"> 로그인 </a></li>

                <li style="padding:3px" class="nav-item">
                    <div class="text-center">
                        <a href="" class="nav-link border border-light rounded"
                            target="_blank" data-toggle="modal"
                            data-target="#modalRegisterForm2"> 회원조회 </a>
                    </div>
                </li>
               <%}else{ %>
               <li style="padding:3px" class="nav-item">
                    <div class="text-center">
                        <a href="" class="nav-link border border-light rounded"
                            target="_blank" data-toggle="modal"
                            data-target="#modalRegisterForm3"> 회원관리 </a>
                    </div>
                </li>
               <li style="padding:3px"class="nav-item"><a
                   href="/safefood/logout.mvc"
                   class="nav-link border border-light rounded" target="_blank"> 로그아웃 </a></li>
               <%} %>
          </ul>

        </div>

      </div>
    </nav>
    <!-- Navbar -->


</body>
</html>