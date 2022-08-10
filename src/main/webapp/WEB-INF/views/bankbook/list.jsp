<%@page import="java.util.ArrayList"%>
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
	<h1>BankBook List</h1>
	<!-- /bankbook/list -->
	<a href="./detail">Detail</a>
	
	<table border="1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th><th>Sale</th>
			</tr>
		</thead>
		<tbody>
			<!-- <tr>
				<td>Name1</td>
				<td>0.012</td>
			</tr>
			<tr>
				<td>Name2</td>
				<td>3.14</td>
			</tr> -->
			<%ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("list"); %>
			<% for(BankBookDTO bankBookDTO : ar){ %>
				<tr>
					<td><a href ="detail?bookNum=<%= bankBookDTO.getBookNum()%>"><%=bankBookDTO.getBookName() %></a></td>
					<td><%=bankBookDTO.getBookRate() %></td>
					<td><%=bankBookDTO.getBooksale() %></td>
				</tr>
			<% } %>
		</tbody>
	
	</table>
	
	<a href="add">상품등록</a>
	
	

</body>
</html>