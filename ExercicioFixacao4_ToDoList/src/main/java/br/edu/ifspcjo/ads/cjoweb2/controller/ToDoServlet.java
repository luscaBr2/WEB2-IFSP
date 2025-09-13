package br.edu.ifspcjo.ads.cjoweb2.controller;

import java.io.IOException;
import java.util.List;

import br.edu.ifspcjo.ads.cjoweb2.model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ToDoServlet")
public class ToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ToDoServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String tarefasData = req.getParameter("tarefas");
		
		ToDoUtil util = new ToDoUtil();
		
		List<ToDo> ToDoList = util.getToDoList(tarefasData);
		
		// adiciona a lista de pessoas na requisição
		req.setAttribute("ToDoList", ToDoList);
		
		// dispachar para um JP
		RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
		dispatcher.forward(req, resp);
	}
	
}
