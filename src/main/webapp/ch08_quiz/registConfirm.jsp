<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>고객 목록</h2>
	<hr>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>고객등급</th>
		</tr>
		
		<c:forEach var="r" varStatus="i" items="${regists}">
			<tr>
				<td>${i.count}</td>
				<td><a href="/jsp_study/rcontrol?action=info&id=${r.id}">${r.name}</a></td>
				<td>${r.phone}</td>
				<td>${r.grade}${r.kgrade}</td>
			</tr>
		</c:forEach>	
	</table>
	
	<h3><a href="/jsp_study/rcontrol?action=confirm&grade=${r.grade}">등급확인</a></h3>
</body>
</html>