<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${empty member}">
	<a href="./member/login">Login</a>
	<a href="./member/join">Join</a>
</c:if>

<c:if test="${not empty member}">
	<a href="#">Logout</a>
	<a href="#">MyPage</a>
</c:if>

<a href="./bankbook/list">상품리스트</a>
<a href="/bankbook/add">Add</a>
<a href="/member/search">Search</a>


</body>
</html>
