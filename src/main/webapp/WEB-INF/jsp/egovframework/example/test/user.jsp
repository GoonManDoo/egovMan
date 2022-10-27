<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> FOR User MEMBERS! </h1>
	<c:if test="${not empty pageContext.request.userPrincipal}">
		<p> Session On </p>
	</c:if>
	<c:if test="${empty pageContext.request.userPrincipal}">
		<p> Session Out </p>
	</c:if>
	<p> 반갑다 ${pageContext.request.userPrincipal.name}야 </p>
	<a href="${pageContext.request.contextPath}/logout.do">Log Out</a>
</body>
</html>