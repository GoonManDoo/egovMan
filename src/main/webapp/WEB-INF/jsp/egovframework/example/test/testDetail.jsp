<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link href="/css/test/test.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	#reply_btn {
		text-align: right;
	}
	
	#btn_modify {
		margin-bottom: 50px;
	}
	
	#dat {
		text-align: center;
	}
</style>
</head>
<body>
	<div class="container">
		
			<thead>
				<h1>글 상세보기 Detail</h1>
			</thead>
			<tbody>
				<form action="updateTest.do" id="viewForm" method="post"
					multiple="multiple" encType="multipart/form-data">
					<tr>
						<th>글번호:</th>
						<td><input name="testId" type="text" value="${result.testId}"
							class="form-control" readonly /></td>

					</tr>
					<tr>
						<th>제목:</th>
						<td><input type="text" value="${result.testTitle}"
							name="testTitle" class="form-control" /></td>
					</tr>
					<tr>
						<th>내용:</th>
						<td><textarea name="testContent" class="form-control"
								style="height: 200px;">${result.testContent}</textarea></td>

					</tr>
					<tr>
						<th>작성자:</th>
						<td><input name="testName" type="text" value="${result.testName}"
							class="form-control" readonly /></td>
					</tr>
					<tr>
						<c:if test="${result.fileName ne null}">
							<tr>
								<td>다운로드</td>

								<td><a href="fileDownload.do?fileName=${result.fileName}">
										<input type="text" id="asd" value="${result.fileName}"
										name="fileName" class="form-control" readonly />
										
								</a>
									<button id="asdasd" type="button" class="btn_previous">파일지우기</button>
							</tr>
						</c:if>
					</tr>
					<tr>
						<th>첨부파일:</th>
						<td><input type="file" name="uploadFiles" multiple="multiple"></td>
					</tr>
					
					<tr>
						<td colspan="2">
							<button id="btn_previous" type="button" class="btn_previous">이전</button>
							<button id="btn_delete" type="button" class="btn_previous">삭제</button>
							<button id="btn_modify" type="button" class="btn_register">수정</button>
					</tr>
				</form>
			</tbody>
		</table>
	</div>
	
	
	<!-- 댓글 -->
	<div class="container">
	<table class="table table-bordered">
		
	<h1 id="dat">댓글창</h1>
	<form action="replyUpdate.do" id="replyForm">
	<c:forEach items="${reply}" var="reply">
	<div>
	<tr>
		<th>작성자 : </th>
		<td><input type="text" value="${reply.writer }" class="form-control"/><td>
	</tr>
	</div>
		
	<div>
	<tr>
		<th>내용 : </th>
		<td><input type="text" value="${reply.content }" class="form-control"/><td>
	</tr>
	</div>
	
	<div>
	<tr>
		<th>작성일자 : </th>
		<td><fmt:formatDate value="${reply.regDate }" type="date" dateStyle="full" /><td>
	</tr>
	</div>
	
	<div>
	<tr>
		<td id="reply_btn"><button type="button" id="replyUpdateBtn" class="replyUpdateBtn">수정</button>
			               <button type="button" id="replyDeleteBtn" class="replyDeleteBtn">삭제</button></td>
	</tr>
	</div>
	</c:forEach>
	</form>
		
		<tr>
			<th></th>
			<td></td>
		</tr>
		<form action="reply.do" method="post">
		<tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" class="form-control">
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="50" name="content" class="form-control"></textarea>
			</tr>
			<tr>
				<td colspan="2">
				<input type="hidden" name="testId" value="${result.testId }" class="form-control">
				<button type="submit">댓글작성</button>
			</tr>
			
		</form>
		</table>
	</div>




</body>
<script type="text/javascript">

	<!-- 댓글 수정 버튼 -->
	$(document).on('click', '#replyUpdateBtn', function(e) {
		if (confirm("정말 수정하시겠습니까 ?") == true) {
			$("replyForm").submit();
		} else {
			return;
		}
	});
	
	/* 댓글 삭제 버튼 */
	$(document).on('click', '#replyDeleteBtn', function(e) {
		if (confirm("정말 삭제하시겠습니까 ?") == true) {
			$("#replyForm").attr("action", "replyDelete.do");
			$("#replyForm").submit();
		} else {
			return;
		}
	});
	
	
	
	//게시글 수정 버튼
	$(document).on('click', '#btn_modify', function(e) {
		if (confirm("정말 수정하시겠습니까 ?") == true) {
			$("#viewForm").submit();
			alert('수정이 완료되었습니다.');
		} else {
			return;
		}

	});
	
	//게시글 삭제 버튼
	$(document).on('click', '#btn_delete', function(e) {
		if (confirm("정말 삭제하시겠습니까 ?") == true) {
			$("#viewForm").attr("action", "deleteTest.do");
			$("#viewForm").submit();
		} else {
			return;
		}

	});

	//이전 클릭 시 testList로 이동
	$("#btn_previous").click(function javascript_onclikc() {

		$(location).attr('href', 'testList.do');

	});
	$("#asdasd").click(function javascript_onclikc() {
		$('#asd').val(null);

	});
</script>
</html>