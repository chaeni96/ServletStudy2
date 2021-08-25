<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 Page</h1>
	
	<form action="./memberJoin.do" method = "post">
	
		ID <input type="text" name="id"> <br>
		password <input type="password" name="pw"><br>
		이름 <input type="text" name = "name"><br>
		phone number <input type="tel" name="phone"><br>
		email <input type="email" name = "email">
		<button>JOIN</button>
		
	</form>
</body>
</html>