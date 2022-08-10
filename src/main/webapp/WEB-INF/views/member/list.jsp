<%@page import="com.iu.start.test.members.BankMembersDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>USERNAME</th><th>NAME</th><th>EMAIL</th><th>PHONE</th>
			</tr>
		</thead>
		
		<tbody>
			<%ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>)request.getAttribute("search"); %>
			<%for(BankMembersDTO bankMembersDTO: ar){ %>
				<tr>
					<td><%=bankMembersDTO.getUsername() %></td>
					<td><%=bankMembersDTO.getName() %></td>
					<td><%=bankMembersDTO.getEmail() %></td>
					<td><%=bankMembersDTO.getPhone() %></td>
				</tr>
			<%} %>
		</tbody>
	</table>

</body>
</html>