<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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
	href="${pageContext.request.contextPath}/resources/css/boardCss.css"
	rel="stylesheet">
</head>
<body class="container">
	<div>
		<button type="button" class="btn btn-warning" onclick="showList()">리스트로
			돌아가기</button>
	</div>
	<div class="container" style="margin: 10px 0;">
		<div>
			<span><strong>제목</strong></span><input value="${thisBoard.title }"
				readonly="readonly">
		</div>
		<br>
		<div>
			<span><strong>작성자</strong></span><input value="${thisBoard.writer }"
				readonly="readonly"> <span><strong>
					&nbsp등록일시</strong></span><input value="${thisBoard.regDate }" readonly="readonly">
		</div>
		<c:if test="${! empty thisBoard.editor}">
			<div>
				<span><strong>수정자</strong></span><input value="${thisBoard.editor }"
					readonly="readonly"> <span><strong>수정 일시</strong></span><input
					value="${thisBoard.updateDate }" readonly="readonly">
			</div>
		</c:if>
	</div>

	<div class="container">
		<div>
			<span><strong>내용</strong></span>
		</div>
		<div>
			<textarea class="form-control" id="floatingTextarea2" name="Bcontext"
				style="height: 200px" readonly="readonly"><c:out
					value="${thisBoard.context }" /></textarea>
		</div>

		<div>
			<button class="btn btn-outline-primary  btn-sm"
				onclick="updatePage()">수정하기</button>
			<button class="btn btn-outline-primary  btn-sm"
				onclick="deleteBoard()">삭제하기</button>
		</div>
	</div>
	<div class="container" style="margin: 20px 0;">
		<div class="header">
			<strong>Replys</strong>
		</div>
		<div>
			<dl id="chat">
			</dl>
		</div>
	</div>
	<div class="container">
		<form id="replyForm">
			<input type="hidden" name="bno" value="${thisBoard.bno}"> <input
				type="hidden" name="writer"
				value="<sec:authentication property='principal.username'/>">
			<div>
				<span><strong>Comments</strong></span> <span id="cCnt"></span>
			</div>
			<div>
				<span><textarea class="form-control"
						placeholder="Leave a comment here" id="floatingTextarea3"
						name="context" style="height: 180px; width: 70%;"></textarea></span> <span><button
						type="button" class="btn btn-info" onclick="regComment()">댓글
						등록하기</button></span>
			</div>
		</form>
	</div>

	<script>
		$(function() {
			showComments();
		});
		
		/* 댓글 등록하기 */
		function regComment() {
			var replyForm = $('#replyForm').serialize();
			console.log(replyForm);

			$.ajax({
				type : 'POST',
				url : "/crizen/writereply.do",
				data : replyForm,
				success : function(res) {
					if (res == "success") {
						showComments();
						$('#floatingTextarea3').val("");
					}
				},
				error : function(error) {
					console.log("error" + error);
				}
			});

		}
		
		
		function deleteComment(event) {
			var comment = event.target.value;
			console.log(comment);		
			$.ajax({
				type : 'GET',
				url : "/crizen/removeReply.do?rno="+comment,
				success : function(res) {	
					if (res == "success") {
						showComments();		
					}
					
				},
				error : function(error) {
					console.log("error" + error);
				}
			});
			
		}
		
	

		/* 댓글 조회하기 */
		function showComments() {
			$.ajax({
				type : 'GET',
				url : "/crizen/readreplys.do?bno=${thisBoard.bno}",
				success : function(list) {
					var str="";
					if(list==null || list.length ==0){
						str += "<dt><strong class='primary-font'>댓글이 없습니다.</strong></dt>";
						$("#chat").html(str);
						return;
					}
					for(var i=0, len=list.length ||0 ; i<len ; i++){
						str+="<dt><strong class='primary-font'>"+list[i].writer+"</strong></dt>";
						str+="<dt><small class='pull-right text-muted'>"+list[i].regDate+"</small></dt>";
						str+="<dd><p>"+list[i].context +"</p></dd>";
						str+="<button type='button' class='btn btn-sm' value='"+list[i].rno+"' id='deleteComment' onclick='deleteComment(event)'>삭제</button>"
					}
								
					$("#chat").html(str);
				},
				error : function(error) {
					console.log("error" + error);
				}
			});
		}

		/* 리스트로 돌아가기 */
		function showList() {
			location.href = "${path}/crizen/boardList.do";
		}

		/* 게시물 수정 페이지로 이동 */
		function updatePage() {
			location.href = "${path}/crizen/updateView.do?bno=${thisBoard.bno}";
		}

		/* 게시물 삭제하기 */
		function deleteBoard() {
			var deleteValue = confirm('정말 삭제하시겠습니까?');
			if (deleteValue) {
				window.location.href = "${path}/crizen/remove.do?bno=${thisBoard.bno}";
			} else {
				return false;
			}
		}


	</script>
</body>
</html>
