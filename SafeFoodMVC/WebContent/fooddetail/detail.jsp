<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8" import="mvc.vo.Food"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>식품 상세 정보</title>
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

 <jsp:include page="/header/header2.jsp"></jsp:include>
  
  <!--Main layout-->
  <main class="mt-5 pt-4">
    <div class="container dark-grey-text mt-5">

      <!--Grid row-->
      <div class="row wow fadeIn">

        <!--Grid column-->
        <div class="col-md-6 mb-4">

          <img src="${pageContext.request.contextPath}/resources/${food.image}" class="img-fluid" alt="">

        </div>
        <!--Grid column-->

        <!--Grid column-->
        <div class="col-md-6 mb-4">

          <!--Content-->
          <div class="p-4">

            <span style="font-size: 30px;font-weight: bold;">${food.name }</span>
           	 	<%
            	if(request.getAttribute("food") != null && ((Food)request.getAttribute("food")).getAllergy().length() > 0){
            	%>
	              <a href="">
	                <span class="badge red mr-1">알레르기 성분 포함</span>
	              </a>
              <%} else if(request.getAttribute("food") != null && ((Food)request.getAttribute("food")).getAllergy().length() == 0) {%>
	              <a href="">
	                <span class="badge blue mr-1">알레르기 성분 미포함</span>
	              </a>
              <%} %>
            <hr>

            <p class="lead font-weight-bold">제조사</p>
            <p>${food.maker}</p>
            <p class="lead font-weight-bold">원재료</p>
            <p>${food.material}</p>
            <p class="lead font-weight-bold">알레르기 성분</p>
            <%if(request.getAttribute("food") != null && ((Food)request.getAttribute("food")).getAllergy().length() > 0){ %>
            	<p>${food.allergy}</p>
            <%}else {%>
				<p>해당없음</p>
				<%} %>
          </div>
          <!--Content-->

        </div>
        <!--Grid column-->

      </div>
      <!--Grid row-->

      <hr>
      
      <!--Grid row-->
      <div class="row wow fadeIn">
       <!--Grid column-->
        <div class="col-lg-6 col-md-6 mb-4">
          <!--Card-->
          <div class="card"onload="alarmTest()">
            <!-- Card header -->
            <div class="card-header" >식품영양 분석 차트</div>
            <!--Card content-->
            <div class="card-body">
              <canvas id="doughnutChart"></canvas> <!-- 차트 삽입 부분 -->
              	<input type="text" style="display: none;" value="${food.calory}" id="calory">
              	<input type="text" style="display: none;" value="${food.carbo}" id="carbo">
              	<input type="text" style="display: none;" value="${food.protein}" id="protein">
              	<input type="text" style="display: none;" value="${food.fat}" id="fat">
              	<input type="text" style="display: none;" value="${food.sugar}" id="sugar">
              	<input type="text" style="display: none;" value="${food.natrium}" id="natrium">
            </div>
          </div>
          <!--/.Card-->
        </div>
        <!--Grid column-->
        
         <!--Grid column-->
        <div class="col-md-6 mb-4">
          <!--Card-->
          <div class="card">
            <!-- Card header -->
            <div class="card-header">식품영양 분석표</div>
            <!--Card content-->
            <div class="card-body">
              <!-- Table  -->
              <table class="table table-hover">
                <!-- Table head -->
                <thead class="blue lighten-4">
                  <tr>
                    <th>Element</th>
                    <th>Data</th>
                  </tr>
                </thead>
                <!-- Table head -->

                <!-- Table body -->
                <tbody>
                  <tr>
                    <td>일일제공량</td>
                    <td>${food.supportpereat}</td>
                  </tr>
                  <tr>
                    <td>칼로리</td>
                    <td>${food.calory}</td>
                  </tr>
                  <tr>
                    <td>탄수화물</td>
                    <td>${food.carbo}</td>
                  </tr>
                  <tr>
                    <td>단백질</td>
                    <td>${food.protein}</td>
                  </tr>
                  <tr>
                    <td>지방</td>
                    <td>${food.fat}</td>
                  </tr>
                  <tr>
                    <td>당류</td>
                    <td>${food.sugar}</td>
                  </tr>
                  <tr>
                    <td>나트륨</td>
                    <td>${food.natrium}</td>
                  </tr>
                </tbody>
                <!-- Table body -->
              </table>
              <!-- Table  -->
            </div>
          </div>
          <!--/.Card-->
        </div>
        <!--Grid column-->
       </div>
    </div>
  </main>
  <!--Main layout-->

  <!--Footer-->
  <footer class="page-footer text-center font-small mt-4 wow fadeIn">

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
    	var NUTR_CONT1 = $("#calory").val(); // 칼로리
		var NUTR_CONT2 = $("#carbo").val(); // 탄수화물
		var NUTR_CONT3 = $("#protein").val(); // 단백질
		var NUTR_CONT4 = $("#fat").val(); // 지방
		var NUTR_CONT5 = $("#sugar").val(); // 당류
		var NUTR_CONT6 = $("#natrium").val(); // 나트륨
		makeDoughnutChart(NUTR_CONT1,NUTR_CONT2,NUTR_CONT3,NUTR_CONT4,NUTR_CONT5,NUTR_CONT6);
	});// end of ready
    
	function makeDoughnutChart(NUTR_CONT1,NUTR_CONT2,NUTR_CONT3,NUTR_CONT4,NUTR_CONT5,NUTR_CONT6){
		 //doughnut
	    var ctxD = document.getElementById("doughnutChart").getContext('2d');
	    var myLineChart = new Chart(ctxD, {
	      type: 'doughnut',
	      data: {
	        labels: ["칼로리", "탄수화물", "단백질", "지방", "나트륨", "당류"],
	        datasets: [{
	          data: [NUTR_CONT1, NUTR_CONT2, NUTR_CONT3, NUTR_CONT4, NUTR_CONT6, NUTR_CONT5],
	          backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#4D5360", "#2E9AFE","#40FF00"],
	          hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#0040FF","#31B404"]
	        }]
	      },
	      options: {
	        responsive: true
	      }
	    });
	}

  </script>
</body>

</html>
