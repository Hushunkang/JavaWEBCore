<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="login" method="post">
		username: <input type="text" name="username"/>
		password: <input type="password" name="password"/>
		
		<br/>
		<br/>
		
		interesting:
		<input type="checkbox" name="interesting" value="reading"/>Reading
		<input type="checkbox" name="interesting" value="game"/>Game
		<input type="checkbox" name="interesting" value="party"/>Party
		<input type="checkbox" name="interesting" value="shopping"/>Shopping
		<input type="checkbox" name="interesting" value="sport"/>Sport
		<input type="checkbox" name="interesting" value="tv"/>TV
		
		<input type="submit" value="Submit"/>
	</form>

</body>
</html>