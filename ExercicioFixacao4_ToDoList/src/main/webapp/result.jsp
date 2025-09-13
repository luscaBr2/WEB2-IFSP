<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,br.edu.ifspcjo.ads.cjoweb2.model.ToDo"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<title>Lista de Tarefas Cadastradas</title>
	<link rel="stylesheet" type="text/css" href="styles.css" >
</head>
<body>
	<c:choose>
		<c:when test="${fn:length(ToDoList) > 0}">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Descrição</th>
						<th>Data</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tarefa" items="${ToDoList}" 
						varStatus="cont">
						<tr>
							<td>${tarefa.getId()}</td>
							<td>${tarefa.getDescription()}</td>
							<td>${tarefa.getDate()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<c:out value="Nenhuma tarefa cadastrada."></c:out>
		</c:otherwise>
	</c:choose>
</body>
</html>