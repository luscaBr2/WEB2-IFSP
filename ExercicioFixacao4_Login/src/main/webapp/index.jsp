<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<body>
	<form action="UsuarioServlet" method="post">
	
		<label for="email">Email:</label>
		<input type="email" placeholder="usuario@gmail.com" name="email"/> <br>
		
		<label for="senha">Senha:</label>
		<input type="password" placeholder="123" name="senha"/> <br>
		
		<input type="submit" value="Enviar">
	</form>
</body>
</html>