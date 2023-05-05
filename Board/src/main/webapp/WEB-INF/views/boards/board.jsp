<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물</title>
</head>
<body>
	<!-- 메인 -->
	<!-- 게시물 -->
	<h3>${board.title }</h3>
	<p>${board.content }</p>
	<small>${board.regDate }</small>
	<!-- END 게시물 -->
	<button onclick="location.href='/boards/list'">목록</button>
	<hr>
	<!-- 연관게시글 목록 -->
	<h4>연관 게시글 목록</h4>
	<table>
		<tr>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${sublist }" var="board">
			<tr>
				<td><a href="/boards/board?id=${board.id }">${board.title }</a></td>
				<td>${fn:split(board.regDate,' ')[0] }</td>
			</tr>
		</c:forEach>
	</table>
	<!-- END 연관게시글 목록 -->
	<!-- END 메인 -->
</body>
</html>