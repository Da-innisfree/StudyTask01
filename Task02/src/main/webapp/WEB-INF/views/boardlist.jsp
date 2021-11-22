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
<link
	href="${pageContext.request.contextPath}/resources/css/boardlistCss.css"
	rel="stylesheet">
</head>
<body>
	<header class="container">
		<h1>게시판</h1>
		<button class="btn btn-sm btn-link" onclick="goMain()">메인페이지로
			돌아가기</button>
	</header>
	<div class="container" style="display: flex;">
		<form id="searchForm" action="/crizen/search.do" method="get">
			<label for="type">검색 조건 : </label> <select name="type" id="search"
				onchange="addTextBox()">
				<option value="">--검색</option>
				<option value="W" ${type=='W'? 'selected':'' }>작성자</option>
				<option value="T" ${type=='T'? 'selected':'' }>제목</option>
				<option value="C" ${type=='C'? 'selected':'' }>내용</option>
				<option value="D" ${type=='D'? 'selected':'' }>작성 일자</option>
				<option value="TC" ${type=='TC'? 'selected':'' }>제목+내용</option>
			</select> <span id="textbox"> </span>
			<button class="btn btn-warning btn-sm" id="searchBtn">검색하기</button>
		</form>
	</div>

	<div class="container">
		<button class="btn btn-primary btn-sm" onclick="showList()">전체
			리스트 보기</button>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성 날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty boardList}">
					<tr>
						<td scope="row">게시물이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach var="list" items="${boardList}">
					<tr>
						<td scope="row"
							onclick="location.href='${path}/crizen/board.do?bno=${list.bno}'">${list.bno }</td>
						<td scope="row"
							onclick="location.href='${path}/crizen/board.do?bno=${list.bno}'">${list.title }</td>
						<td scope="row"
							onclick="location.href='${path}/crizen/board.do?bno=${list.bno}'">${list.writer }</td>
						<td scope="row"
							onclick="location.href='${path}/crizen/board.do?bno=${list.bno}'">${list.regDate }</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<button type="button" class="btn btn-warning" onclick="writePage();">새
			글 쓰기</button>
	</div>

	<script>
		$(function() {
			addTextBox();
		});

		/* 리스트로 돌아가기 */
		function showList() {
			location.href = "${path}/crizen/boardList.do";
		}

		/* 작성 페이지로 이동 */
		function writePage() {
			location.href = "${path}/crizen/writeBoard.do";
		}

		/* 조건 검색어 입력 */
		$('#searchBtn').click(function searchBoard(e) {
			e.preventDefault();

			var type = $('#search').val();
			var keyword = $('#keyword').val();

			if (type == "" || search == "")
				alert("검색 조건과 검색어를 입력해주세요!!");
			else
				document.getElementById('searchForm').submit();

		});

		/* 메인페이지로  돌아가기 */
		function goMain() {
			location.href = "${path}/crizen/hello.do";
		}

		/* 검색 조건에 따른 input 변경 */
		function addTextBox() {
			var type = $('#search').val();

			var type1 = "<input type='date' name='keyword' id='keyword' />";
			var type2 = "<input type='text' name='keyword' id='keyword' value='${keyword }' />";

			if (type == "D")
				$('#textbox').html(type1);
			else
				$('#textbox').html(type2);
		}
	</script>
</body>
</html>
