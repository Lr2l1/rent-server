<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon"
	href="https://em-content.zobj.net/source/twitter/376/skateboard_1f6f9.png">
<link rel="stylesheet" href="/resources/style/grid.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<header>
		<h1>나리렌트카</h1>
		<c:choose>
			<c:when test="${empty user }">
				<button onclick="location.href='/logout'">로그아웃</button>
			</c:when>
			<c:otherwise>
				<button onclick="location.href='/login'">로그인</button>
			</c:otherwise>
		</c:choose>

         <button onclick="location.href='/viewAll'">차량조회</button>
         <button onclick="location.href='/mainMyPage'">마이페이지</button>
         <button onclick="location.href='/userBoard'">문의하기</button>
         <button onclick="location.href='/announcement'">공지사항</button>

	</header>
</body>
</html>