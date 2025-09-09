package br.edu.ifspcjo.ads.cjoweb2.project1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet1") // mapear o servlet
public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// setar a codificação de caracteres da requisição
		req.setCharacterEncoding("UTF-8");
		// obter os dados da requisição
		String name = req.getParameter("name");
		// setar  tipo de conteúdo e a codificação de caracteres da resposta
		resp.setContentType("text/html;charset=UTF-8");
		// obter o escritor da resposta
		PrintWriter writer = resp.getWriter();
		writer.println("<!DOCTYPE html>");
		writer.println("<html lang=\"pt-br\">");
		writer.println("\t<head>");
		writer.println("\t\t<meta charset=\"UTF-8\">");
		writer.println("\t\t<title>Página de boas-vindas</title>");
		writer.println("\t</head>");
		writer.println("\t<body>");
		writer.println("\t\t<h1>Seja bem-vindo(a), " + name + "</h1>");
		writer.println("\t</body");
		writer.println("</html>");
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doGet(req, resp);
	}

}