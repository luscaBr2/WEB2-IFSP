<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="PersonServlet" method="post">
		<label for="people">Dados das pessoas:</label> <br>
		<textarea rows="10" cols="80" name="people" id="people"></textarea><br>
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>