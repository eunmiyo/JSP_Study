<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="gugudan" class="ch07.com.dao.GuGuDan" />
<jsp:setProperty name="gugudan" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>구구단 출력하기</h2>
	
	<%= gugudan.process(5) %>
	
</body>
</html>