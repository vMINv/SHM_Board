<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<!-- 메인 -->
	<h1>게시판</h1>
	<!-- 게시물 목록 -->
	<table>
		<tr>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${list }" var="board">
			<tr>
				<td><a href="/boards/board?id=${board.id }">${board.title }</a></td>
				<td>${fn:split(board.regDate,' ')[0] }</td>
			</tr>
		</c:forEach>
	</table>
	<!-- END 게시물 목록 -->
	<button onclick="location.href='/boards/newBoard'">글 작성</button>
	<!-- 메인 -->
</body>
</html>