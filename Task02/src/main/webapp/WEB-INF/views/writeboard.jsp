<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board List</title>
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/writeCss.css"
	rel="stylesheet">
</head>
<body>
	<header class="container" style="">
		<h1>게시물 작성</h1>
		<span>
			<button type="button" class="btn btn-warning btn-sm"
				onclick="showList();">리스트로 돌아가기</button>
		</span>
	</header>

	<div class="container">
		<form class="form-floating" action="/crizen/writeBoard.do"
			method="post">
			<div>
				<label for="floatingInputValue">제목</label> <input type="text"
					class="form-control" id="floatingInputValue" name="title">
			</div>
			<div>
				<label for="floatingInputValue">작성자</label> <input type="text"
					class="form-control" id="floatingInputValue" name="writer"
					value='<sec:authentication property="principal.username"/>' readonly="readonly">
			</div>
			<div class="form-floating">
				<textarea class="form-control" placeholder="Leave a comment here"
					id="floatingTextarea3" name="context" style="height: 200px"></textarea>
				<label for="floatingTextarea3">게시글을 작성해주세요.</label>
			</div>

			<div>
				<button type="submit" class="btn btn-info">작성 완료</button>
			</div>
		</form>
	</div>

	<script>
		function showList() {
			location.href = "${path}/crizen/boardList.do";
		}
	</script>
</body>
</html>
