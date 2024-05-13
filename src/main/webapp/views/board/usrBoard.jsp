<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/header" />
<script src="/resources/script/validation-cancel.js"></script>
</head>
<body>

	<c:if test="${empty board }">
		<c:redirect url="login"></c:redirect>
	</c:if>
	
	<button>글쓰기</button>
</body>
<jsp:include page="/footer" />
</html>