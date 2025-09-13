<%@page import="br.edu.ifspcjo.ads.cjoweb2.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<title>Resultado do login</title>
</head>
<body>
	<%
		Usuario usuario = (Usuario)request.getAttribute("usuario");
		String email = (String)request.getAttribute("email"); 
		String senha = (String)request.getAttribute("senha"); 
	%>

	<c:choose>
		<c:when test="${email == usuario.getEmail() && senha == usuario.getSenha()}">
			<p>Bem vindo, logado com sucesso :)</p>
		</c:when>
		<c:otherwise>
			<c:out value="Email ou senha incorretos"></c:out>
		</c:otherwise>
	</c:choose>
	
	<br>
	<p>Email inserido: <%=email %></p>
	<p>Senha inserida: <%=senha %></p>
	
	<br>
	<p>Email correto: <%=usuario.getEmail() %></p>
	<p>Senha inserida: <%=usuario.getSenha() %></p>
	
	
</body>
</html>