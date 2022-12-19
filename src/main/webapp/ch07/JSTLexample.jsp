
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL 종합예제</h2>
	<hr>
	
	<h3>set, out</h3>
	<!-- pageScope영역에 저장된다 -->
	<c:set var="product1" value="<b>애플 아이폰</b>" /> <!-- 태그 -->
	<c:set var="product2" value="삼성 갤럭시 노트" /> <!-- 문자열 -->
	<c:set var="intArray" value="${[1,2,3,4,5]}" /> <!-- 배열{배열이름,저장}, 오류무시해도됨 -->
	
	<p>
	product1(jstl):
	<!-- ${product1}: $붙여줘야 값이 출력 -->
	<!-- default="Not registered": 출력하는 값이 없을때 -->
	<!-- escapeXml="true": 태그랑 문자 출력, "false": defalult이고, 태그안 문자만 출력 -->
	<c:out value="${product1}" default="Not registered" escapeXml="false"></c:out>
	</p>
	
	<p> product1(el):${product1} </p> <!-- escapeXml="false" -->
	<p> intArray[2]: ${intArray[2]}</p> <!-- 배열에서 인덱스2번 값 출력 -->
	<hr>
	
	<h3>foreach배열 출력</h3>
	<ul>
		<!-- for(int num : intArray) -->
		<!-- varStatus : 인덱스, 몇 번 반복됐는지 횟수 확인 -->
		<c:forEach var="num" varStatus="i" items="${intArray}">
			<li> ${i.index} : ${num} </li>
		</c:forEach>
	</ul>
	<hr>
	
	<h3>if</h3> <!-- else는 지원하지 않음 -->
	<c:set var="checkout" value="true" />
	<!-- if(checkout == true) -->
	<!-- test: jstl에서 쓰이는 비교 -->
	<c:if test="${checkout}"> 
		<p>주문제품 : ${product2} </p>
	</c:if>
	
	<!-- if(checkout != true) -->
	<c:if test="${!checkout}"> 
		<p>주문제품 : 주문제품 아님 </p>
	</c:if>
	
	<!-- empty: product2에 값이 들어가 있는지 아닌지 체크한다 -->
	<c:if test="${!empty product2}" >
		<b>${product2} 이미 있음!</b>
	</c:if>
	<hr>
	
	<h3>choose, when, otherwise</h3>
	<!-- if~elseif문 또는 switch문과 같은 형식 -->
	<c:choose>
		<c:when test="${checkout}">
			<p>주문제품 : ${product2} </p>
		</c:when>
		<c:otherwise>
			<p>주문제품 아님</p>
		</c:otherwise>
	</c:choose>
	<hr>
	
	<h3>for Tokens</h3>
	<!-- items: 저장될 값들, delims: 구분자 -->
	<c:forTokens var="city" items="Seoul | Tokyo | New York | Toronto" delims="|" varStatus="i">
		<!-- ${i.first}:인덱스가 첫번째이면 true 반환 -->
		<!-- if(i.first == true) -->
		<c:if test="${i.first}"> 도시목록 : </c:if> 
		${city}
		<!-- ${!i.last}:인덱스가 마지막이 아니면 실행 -->
		<!-- if(i.last != true) -->
		<c:if test="${!i.last}">,</c:if>
	</c:forTokens>
</body>
</html>