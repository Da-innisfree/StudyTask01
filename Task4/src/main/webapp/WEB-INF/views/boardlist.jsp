<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board List</title>
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<table class="table">
<thead>
	<tr>
	<th scope="col">#</th>
	<th scope="col">제목</th>
	<th scope="col">작성자</th>
	<th scope="col">작성 시간</th>
	</tr>
</thead>
<tbody>
<c:forEach var="list" items="${boardList}">

</c:forEach>
	<tr>
	<td scope="row">${list.bno }</th>
	<td scope="row">${list.title }</th>
	<td scope="row">${list.writer }</th>
	<td scope="row">${list.regDate }</th>
	</tr>
 </tbody>

</table>

</body>
</html>
