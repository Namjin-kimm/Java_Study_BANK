<%@page import="com.iu.start.bankbook.BankBookDTO"%>
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
	<h1>BankBook Detail</h1>
	
	<!-- /bankbook/detail -->
	<!-- link 주소는 상대경로 작 -->
	
	<!-- 상대경로 -->
	<a href="../member/login">Login</a>
	<a href="/member/login">Join</a>
	
	<%-- <%BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail"); %> --%>
	
	<%-- <%if(bankBookDTO != null){ %> --%>
<table border="1">
	<thead>
		<tr>
			<th>BookNum</th><th>BookName</th><th>BookRate</th><th>BookSale</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${requestScope.detail.getBookNum()}</td>
			<td>${requestScope.detail.bookName}</td>
			<td>${detail.bookRate}</td>
			<td>${detail.bookSale}</td>
			
			<%-- <td><%=bankBookDTO.getBookNum() %></td>
			<td><%=bankBookDTO.getBookName() %></td>
			<td><%=bankBookDTO.getBookRate() %></td>
			<td><%=bankBookDTO.getBooksale() %></td> --%>
		</tr>
	</tbody>
</table>
	<%-- <%}else{ %>
	<h3>Data가 없다</h3>
	<%} %> --%>
	<%BankBookDTO bankBookDTO = new BankBookDTO(); %>
	<a href="list">리스트보기</a>
	<a href="update?bookNum=${detail.bookNum}">수정</a>
	<a href="delete?bookNum=${detail.bookNum}">삭제</a>
	
	<c:if test="${not empty sessionScope.member}">
	<a href="../bankAccount/add.iu?bookNum=${detail.bookNum}">가입하기</a>
	</c:if>

</body>
</html>