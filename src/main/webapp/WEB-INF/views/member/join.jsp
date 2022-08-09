<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join" method="post">
ID <input type="text" value="id를 입력하세요" name="username">
    <input type="reset"><br>
    PW <input type="password" value="pw를 입력하세요" name="password">
    <input type="reset"><br>
    NAME <input type="text" value="이름을 입력하세요" name="name"><br>
    <!-- 성별을 고르세요 남<input type="radio" name="r1"> 여<input type="radio" name="r1"><br> -->
    <!-- AGE <input type="text"><br> -->
    EMAIL <input type="email" name="email"><br>
    PHONE <input type="tel" name="phone"><br>
    <input type="submit" value="SUBMIT">
</form>
</body>
</html>