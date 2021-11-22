<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html class="h-100">
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>CRIZEN SOLUTION TASK01</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.1/examples/cover/">


<!-- Bootstrap core CSS www.localhost:8080/webapp -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>


<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/cover.css"
	rel="stylesheet">
</head>
<body class="d-flex h-100 text-center text-white bg-dark">

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="mb-auto">
			<div>
				<h3 class="float-md-start mb-0">SOLUTION</h3>
				<sec:authorize access="isAnonymous()">
					<button
						class="btn btn-sm btn-secondary fw-bold border-white bg-white"
						onclick="goLogin()">로그인/사용자 등록하기</button>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<button id="logoutBtn"
						class="btn btn-sm btn-secondary fw-bold border-white bg-white">로그아웃
						하기</button>
				</sec:authorize>
			</div>
		</header>

		<main class="px-3">
			<h1 id="hello"></h1>
			<p class="lead" id="time"></p>
			<p class="lead">
				<a href="${path }/crizen/boardList.do" target="_blank"
					class="btn btn-lg btn-secondary fw-bold border-white bg-white">게시판
					보러가기</a>
			</p>
		</main>

		<footer class="mt-auto text-white-50">
			<p>
				Cover template for <a href="https://getbootstrap.com/"
					class="text-white">Bootstrap</a>, by <a
					href="https://twitter.com/mdo" class="text-white">@mdo</a>.
			</p>
		</footer>
	</div>

	<script type="text/javascript">
		myTimer();

		setInterval(function() {
			myTimer()
		}, 1000);

		function myTimer() {
			var date = new Date();
			var year = date.getFullYear();
			var month = (date.getMonth() + 1);
			var day = date.getDate();
			var hour = date.getHours();
			var minute = date.getMinutes();
			var second = date.getSeconds();

			month = month >= 10 ? month : '0' + month;
			day = day >= 10 ? day : '0' + day;
			hour = hour >= 10 ? hour : '0' + hour;
			minute = minute >= 10 ? minute : '0' + minute;
			second = second >= 10 ? second : '0' + second;
			document.getElementById("time").innerHTML = year + "-" + month
					+ "-" + day + " " + hour + ":" + minute + ":" + second;

			var comment = hour >= 0 && hour < 12 ? "좋은 아침!" : hour >= 12
					&& hour < 18 ? "활기찬 오후!" : "잘자요!";
			document.getElementById("hello").innerHTML = comment;
		}

		function goLogin() {
			location.href = "${path}/crizen/login.do";
		}

		$('#logoutBtn').click(function doLogout(e) {
			e.preventDefault();
			
			var logoutValue = confirm("정말 로그아웃 하시겠습니까?");
			if (logoutValue) {
				window.location.href = "${path}/crizen/logout.do";
			} else {
				return false;
			}
		});
	</script>

</body>
</html>
