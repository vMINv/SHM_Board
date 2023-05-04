<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
</head>
<body>
	<!-- 메인 -->
	<h1>게시물 등록</h1>
	<!-- 게시물 등록 폼 -->
	<form:form modelAttribute="NewBoard" action="./newBoard" method="post">
		<div class="mb-3">
			<label class="form-label">제목</label> 
			<form:input type="text" path="title" required="true" />
		</div>
		<div class="mb-3">
			<label class="form-label">내용</label>
			<form:textarea path="content" rows="3" required="true"></form:textarea>
		</div>
		<div class="row">
			<button type="submit">등록</button>
			<button onclick="location.href='/boards/list'">취소</button>
		</div>
	</form:form>
	<!-- END 게시물 등록 폼 -->
	<!-- END 메인 -->
</body>
</html>