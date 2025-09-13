<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Tarefas</title>
	<style type="text/css">
		textarea {
			display: block;
			margin: 20px 10px;
		}
	</style>
</head>
<body>
	<form action="ToDoServlet" method="post">
		<label for="tarefas">Dados das Tarefas:</label>
		<textarea rows="10" cols="80" name="tarefas" id="tarefas">
		</textarea>
		<p>Padrão: ID; descrição; data;</p>
		<input type="submit" value="Enviar">
	</form>
</body>
</html>