<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./login" method="post">
	<h3>ID</h3><br>
    <input type="text" value="ID 입력" name="username">
    <input type="submit">
    <input type="reset"><br>
    PW <input type="password" value="PW 입력" name="password"><br>

    <!-- <img src="/images/iu.jpg"> -->

    <a href="/study_index.html">인덱스 절대경로</a>
    <a href="../study_index.html">인덱스 상대경로</a>
    </form>
</body>
</html>