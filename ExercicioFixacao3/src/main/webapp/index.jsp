<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Cursos</title>
</head>
<body>
	<form action="AlunoServlet" method="post">
		<label for="people">Nome do aluno: </label>
		<input type="text" name="nome" id="nome"> <br>
		
		<label for="people">Emails: (separados por virgula)</label>
		<input type="text" name="emails" id="emails"><br>
		
		<p>Seleciona quais cursos deseja: </p>
		
		<!-- (Curso de Bootstrap, 
		curso de Animações em CSS 3 e 
		curso de Design Patterns), -->
		
		<input type="checkbox" id="cursoBootstrap" name="cursoBootstrap" value="cursoBootstrap">
		<label for="cursoBootstrap"> Curso de Bootstrap</label><br>
		
		<input type="checkbox" id="cursoAnimacoesCSS" name="cursoAnimacoesCSS" value="cursoAnimacoesCSS">
		<label for="cursoAnimacoesCSS"> Curso de Animações em CSS 3</label><br>
		
		<input type="checkbox" id="cursoDesignPatterns" name="cursoDesignPatterns" value="cursoDesignPatterns">
		<label for="cursoDesignPatterns"> Curso de Design Patterns</label><br>
		
		<input type="submit" value="Enviar">
	</form>
</body>
</html>