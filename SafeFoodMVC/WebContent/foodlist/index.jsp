<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>식품 정보 목록</title>
<!-- Font Awesome -->
<link rel="stylesheet"	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="${pageContext.request.contextPath}/resources/css/mdb.min.css" rel="stylesheet">
<!-- Your custom styles (optional) -->
<link href="${pageContext.request.contextPath}/resources/css/style.min.css" rel="stylesheet">
</head>

<body>

  <!--Main Navigation-->
  <header>
   
    <jsp:include page="/header/header2.jsp"></jsp:include>

  </header>
  <!--Main Navigation-->

  <!--Main layout-->
  <main class="mt-5 pt-5">
    <div class="container">

     <h1>식품 정보 목록</h1>

      <hr class="my-5">

      <!--Section: Cards-->
      <section class="text-center" id = "mainList">

      </section>
      <!--Section: Cards-->

    </div>
  </main>
  <!--Main layout-->

  <!--Footer-->
  <footer class="page-footer text-center font-small mdb-color darken-2 mt-4 wow fadeIn">

    <!--Call to action-->
    <div class="pt-4">
      <a class="btn btn-outline-white" href="https://mdbootstrap.com/docs/jquery/getting-started/download/" target="_blank"
        role="button">Download MDB
        <i class="fas fa-download ml-2"></i>
      </a>
      <a class="btn btn-outline-white" href="https://mdbootstrap.com/education/bootstrap/" target="_blank" role="button">Start
        free tutorial
        <i class="fas fa-graduation-cap ml-2"></i>
      </a>
    </div>
    <!--/.Call to action-->

    <hr class="my-4">

    <!-- Social icons -->
    <div class="pb-4">
      <a href="https://www.facebook.com/mdbootstrap" target="_blank">
        <i class="fab fa-facebook-f mr-3"></i>
      </a>

      <a href="https://twitter.com/MDBootstrap" target="_blank">
        <i class="fab fa-twitter mr-3"></i>
      </a>

      <a href="https://www.youtube.com/watch?v=7MUISDJ5ZZ4" target="_blank">
        <i class="fab fa-youtube mr-3"></i>
      </a>

      <a href="https://plus.google.com/u/0/b/107863090883699620484" target="_blank">
        <i class="fab fa-google-plus-g mr-3"></i>
      </a>

      <a href="https://dribbble.com/mdbootstrap" target="_blank">
        <i class="fab fa-dribbble mr-3"></i>
      </a>

      <a href="https://pinterest.com/mdbootstrap" target="_blank">
        <i class="fab fa-pinterest mr-3"></i>
      </a>

      <a href="https://github.com/mdbootstrap/bootstrap-material-design" target="_blank">
        <i class="fab fa-github mr-3"></i>
      </a>

      <a href="http://codepen.io/mdbootstrap/" target="_blank">
        <i class="fab fa-codepen mr-3"></i>
      </a>
    </div>
    <!-- Social icons -->

    <!--Copyright-->
    <div class="footer-copyright py-3">
      © 2019 Copyright:
      <a href="https://mdbootstrap.com/education/bootstrap/" target="_blank"> MDBootstrap.com </a>
    </div>
    <!--/.Copyright-->

  </footer>
  <!--/.Footer-->
  
<!-- SCRIPTS -->
<!-- JQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mdb.min.js"></script>
  <!-- Initializations -->
  <script type="text/javascript">
    // Animations initialization
    new WOW().init();

	$(document).ready(function(){
		// main page data load
		$.ajax( {
			url : '/safefood/xml/safeFood_foodInfo.xml',			
			dataType : 'xml',			
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",  

			success : function( result ) {//result:서버에서 온 xml data
				if ( $(result).find('food').length > 0 ) {//find(): xml문서 안에서 원하는 태그 찾기
					var row = $('<div class="row mb-4 wow fadeIn"></div>');
					$(result).find('food').each(function(index) {//each(): 찾은  book 태그 각각에 대하여 반복작업 수행
				        if((index & 1) == 0){
				        	row = $('<div class="row mb-4 wow fadeIn"></div>');
				        }
						
						var col = $('<div class="col-md-6 mb-4"></div>');
						var card = $('<div class="card"></div>');
						// image set
						var cardImgDiv = $('<div class="view overlay"></div>');
						var img = $('<img src="../resources/' + $(this).find('image').text() + '" class="card-img-top" alt="">');
						var imgLinkA = $('<a href="/safefood/detail.mvc?code=' + $(this).find('code').text() + '" target="_blank"></a>');
						var imgLinkDiv = $('<div class="mask rgba-white-slight"></div>');
						imgLinkA.append(imgLinkDiv);
						cardImgDiv.append(img);
						cardImgDiv.append(imgLinkA);
						// content set
						var cardBodyDiv = $('<div class="card-body">');
						var nameTag = $('<h4 class="card-title">' + $(this).find('name').text()+ '</h4>');
						var materialTag = $('<p class="card-text"> ' + $(this).find('material').text() + '</p>');
						var icon = $('<i class="fas fa-download ml-2"></i>');
						var addButton = $('<a target="_blank" class="btn btn-blue btn-md">추가</a>');
						addButton.append(icon);
						var jjimButton = $('<a target="_blank" class="btn btn-blue btn-md">찜</a>');
						jjimButton.append(icon);
						
						cardBodyDiv.append(nameTag);
						cardBodyDiv.append(materialTag);
						cardBodyDiv.append(addButton);
						cardBodyDiv.append(jjimButton);
						
						card.append(cardImgDiv);
						card.append(cardBodyDiv);
						
						col.append(card);
						row.append(col);
						// 2개씩 추가
						if((index & 1) == 1)
							$('#mainList').append(row);
					});
					
				}
			} // end of success
		});	// end of ajax		
		
	
	});// end of ready
  </script>
</body>

</html>
