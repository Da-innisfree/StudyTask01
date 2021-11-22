<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board List</title>
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/login.css"
	rel="stylesheet">
</head>

<body class="container">

	<div class="sidenav">
		<div class="login-main-text">
			<button type="button" class="btn btn-link"
				onclick="location.href ='${path}/crizen/hello.do'">메인 페이지로
				돌아가기</button>
			<h1>
				비밀번호 변경 페이지<br>
			</h1>
			<h4>
				<c:out value="${msg}" />
			</h4>
		</div>
	</div>
	<div class="main">
		<div class="col-md-6 col-sm-12">
			<div class="login-form">

				<form method="post" action="/crizen/chgpw.do" id="chgpw">
					<div class="form-group">
						<label>User Name</label> <input type="text" class="form-control"
							placeholder="User Name" id="username" name="username">
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" placeholder="숫자+영문+특수문자 포함 8자리 이상"
							id="password" name="password" onkeyup="enterkeyComment()">
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" placeholder="숫자+영문+특수문자 포함 8자리 이상"
							id="dupassword" name="dupassword" onkeyup="enterkeyComment()">
					</div>
					<button type="submit" class="btn btn-secondary" id="chgpwBtn">등록하기</button>
				</form>
			</div>
			<button type="button" class="btn btn-link"
				onclick="location.href ='${path}/crizen/signUp.do'">사용자
				등록하기</button>
			<button type="button" class="btn btn-link"
				onclick="location.href ='${path}/crizen/login.do'">로그인 하기</button>

		</div>
	</div>
	<script>
		var reg = "/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/";
		$('#chgpwBtn')
				.click(
						function checkPW(e) {
							e.preventDefault();

							var pw = $('#password').val();
							var pw2 = $('#dupassword').val();
							const result = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/
									.test(pw);
							console.log(result);

							if (pw.length < 8 || pw2.length < 8) {
								alert("비밀번호 8자 이상 입력해주세요.");
								return;
							} else if (!(pw == pw2)) {
								alert("비밀번호가 일치하지 않습니다.");
								return;
							} else if (!result) {
								alert("형식을 맞춰주세요.");
								return;
							}
							document.getElementById('chgpw').submit();

						});

		function enterkeyComment() {
			if (window.event.keyCode === 13) {
				// 엔터키가 눌렸을 때 실행할 내용
				checkPW();
			}
		}
	</script>
</body>
</html>
