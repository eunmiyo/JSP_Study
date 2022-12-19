<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="regist" class="ch07.com.dao.Member"/>
<jsp:setProperty name="regist" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>유효성 검사</h3>
	
	<%= regist.getEmail() %>
	<%= regist.getPhone() %>
		</br>
	<%= regist.result() %>
</body>
</html>