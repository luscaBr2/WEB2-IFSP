<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List, br.edu.ifspcjo.ads.cjoweb2.model.Person"
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Lista das pessoas cadastradas</title>
</head>
<body>
	
	<%
		// aqui dentro só pode código java, igual no <?php ?>
		List<Person> peopleList = (List<Person>)request.getAttribute("peopleList");
	%>
	
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>CPF</th>
				<th>Email</th>
			</tr>
		<thead>
		
		<tbody>
			<%
				for(Person person: peopleList) {
			%>
				<tr>
					<td><%= person.getName() %></td>
					<td><%= person.getCpf() %></td>
					<td><%= person.getEmail() %></td>
				</tr>	
			<%
				}
			%>
		</tbody>
	
	</table>
</body>
</html>