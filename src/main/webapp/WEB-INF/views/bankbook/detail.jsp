<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<%BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail"); %>
	
	<%if(bankBookDTO != null){ %>
<table border="1">
	<thead>
		<tr>
			<th>BookNum</th><th>BookName</th><th>BookRate</th><th>BookSale</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><%=bankBookDTO.getBookNum() %></td>
			<td><%=bankBookDTO.getBookName() %></td>
			<td><%=bankBookDTO.getBookRate() %></td>
			<td><%=bankBookDTO.getBooksale() %></td>
		</tr>
	</tbody>
</table>
	<%}else{ %>
	<h3>Data가 없다</h3>
	<%} %>
	

</body>
</html>