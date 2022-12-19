<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!-- useBean: 객체생성 -->
<!-- Calculator calc = new Calculator(); -->
<jsp:useBean id="calc" class="ch07.Calculator" />

<!-- cal.setN1(request.getParmeter("n1")) -->
<!-- cal.setN2(request.getParmeter("n2")) -->
<!-- cal.setOp(request.getParmeter("op")) -->
<!-- property: 변수 혹은 *을 이용해 전체 변수를 한 번에 지정 할 수 있다. -->
<jsp:setProperty name="calc" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	결과: <%= calc.calc() %>
</body>
</html>