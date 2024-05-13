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

	<input type="text" id="title" name="title" placeholder="제목">
	<input type="text" id="detail" name="detail" >
	
	<input type="submit" value="글쓰기">
</body>
<jsp:include page="/footer" />
</html>