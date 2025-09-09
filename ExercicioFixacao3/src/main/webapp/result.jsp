<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="br.edu.ifspcjo.ads.cjoweb2.model.Aluno"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<title>Dados cadastrados</title>
</head>
<body>

	<%
		Aluno aluno = (Aluno)request.getAttribute("aluno");
	%>
	
	<p>Nome do aluno: <%=aluno.getNome() %></p>
	
	<p>Emails:
		<ul>
		<%
			for(String email : aluno.getEmails()){
		%>
		<li>		
		<%=		email %>
		</li>
		<%
			}
		%>
		</ul>
	</p>
	
	<p>Cursos escolhidos:
		<ul>
		<%
			for(String curso : aluno.getCursos()){
		%>
		<li>		
		<%=		curso %>
		</li>
		<%
			}
		%>
		</ul>
	</p>
	
</body>
</html>