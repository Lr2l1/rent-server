<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/style/form.css">
</head>

<c:import url="/header"></c:import>
<script src="/resources/script/validation-update.js"></script>
<body>
	<c:if test="${empty user }">
		<c:redirect url="login"></c:redirect>
	</c:if>

	<section id="root">
		<h2>회원정보 수정</h2>
		<form method="POST" action="/updateFormAction">
			<div>
				<input type="text" id="id" name="id" value="${user.id}"> <input
					type="password" id="password" name="password" placeholder="기존비밀번호">
				<input type="password" id="password-new" name="password-new"
					placeholder="새로운비밀번호"> <input type="text" id="email"
					name="email" value="${empty user.email ? '' : '${user.email}'}"
					placeholder="[선택] 이메일주소 (비밀번호 찾기 등 본인 확인용)">
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-password">* 비밀번호: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-password-new">* 새로운비밀번호: 필수
					정보입니다.</p>
				<p class="error-msg" id="error-msg-email">* 이메일: 이메일 주소가 정확한지
					확인해 주세요.</p>
			</div>
			<div>
				<input type="text" id="name" name="name" value="${user.name}"
					disabled> <input type="text" id="birth" name="birth"
					value="${user.birth}" disabled> <select id="telecom"
					name="telecom">
					<option selected disabled>통신사 선택</option>
					<option value="skt" ${user.telecom eq 'skt' ? 'selected' : '' }>SKT</option>
					<option value="kt" ${user.telecom eq 'kt' ? 'selected' : '' }>KT</option>
					<option value="lgt" ${user.telecom eq 'lgt' ? 'selected' : '' }>LGU+</option>
				</select>
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-telecom">* 통신사: 이용하는 통신사를 선택해
					주세요.</p>
				<p class="error-msg" id="error-msg-phone">* 휴대전화번호: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-phone-pattern">* 휴대전화번호:
					휴대전화번호가 정확한지 확인해 주세요.</p>
			</div>
			<input type="submit" value="회원정보수정">
		</form>
	</section>
</body>
<c:import url="/footer"></c:import>
</html>