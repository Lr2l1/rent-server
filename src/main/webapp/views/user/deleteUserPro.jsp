<%@page import="rentServer.user.UserRequestDto"%>
<%@page import="rentServer.user.UserResponseDto"%>
<%@page import="rentServer.user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");

	UserDao userDao = UserDao.getInstance();

	String password = request.getParameter("password");
	UserResponseDto user = (UserResponseDto) session.getAttribute("usr");

	String id = user.getId();

	UserRequestDto userDto = new UserRequestDto();
	userDto.setPassword(password);

	boolean result = userDao.deleteUser(userDto);
	
	if(result) {
		session.removeAttribute("user");
		response.sendRedirect("/");
	} else {	
		response.sendRedirect("/deleteUserForm");
	}

	%>
</body>
</html>