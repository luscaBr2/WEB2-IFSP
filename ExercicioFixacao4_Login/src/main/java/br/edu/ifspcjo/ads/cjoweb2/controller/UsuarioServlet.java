package br.edu.ifspcjo.ads.cjoweb2.controller;

import java.io.IOException;

import br.edu.ifspcjo.ads.cjoweb2.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {	
	
	public UsuarioServlet() {
		super();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail("usuario@gmail.com");
		usuario.setSenha("123");
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		// adiciona a lista de pessoas na requisição
		req.setAttribute("usuario", usuario);
		req.setAttribute("email", email);
		req.setAttribute("senha", senha);
		
		// dispachar para um JP
		RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
		dispatcher.forward(req, resp);
	}

}
