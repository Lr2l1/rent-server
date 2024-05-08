<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/header" />
<script src="/resources/script/validation-cancel.js"></script>
</head>
<body>

	<c:if test="${empty user }">
		<c:redirect url="/viewAll"></c:redirect>
	</c:if>
	<button onclick="location.href='/updateUser'">회원정보수정</button>
	<button onclick="location.href='/deleteUser'">회원탈퇴</button>
	<button onclick="location.href='/deleteUser'">예약확인</button>
	<button onclick="location.href='/deleteUser'">예약취소</button>
</body>
<jsp:include page="/footer" />
</html>