package br.edu.ifspcjo.ads.cjoweb2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.edu.ifspcjo.ads.cjoweb2.model.Aluno;

@WebServlet("/AlunoServlet")
public class AlunoServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	public AlunoServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String nome = req.getParameter("nome");
		String emails = req.getParameter("emails");
		
		String cursoBootstrap = req.getParameter("cursoBootstrap");
		String cursoAnimacoesCSS = req.getParameter("cursoAnimacoesCSS");
		String cursoDesignPatterns = req.getParameter("cursoDesignPatterns");
		
		String[] email = emails.split(",");
		
		List<String> listaEmails = new ArrayList<String>();
		
		for(String item : email) {
			listaEmails.add(item);
		}
		
		List<String> cursosSelecionados = new ArrayList<String>();;

		if(cursoBootstrap != null)
			cursosSelecionados.add(cursoBootstrap);
		
		if(cursoAnimacoesCSS != null)
			cursosSelecionados.add(cursoAnimacoesCSS);
		
		if(cursoDesignPatterns != null)
			cursosSelecionados.add(cursoDesignPatterns);
		
		Aluno aluno = new Aluno(nome, listaEmails, cursosSelecionados);
		req.setAttribute("aluno", aluno);		
		
		// dispachar para um JP
		RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
		dispatcher.forward(req, resp);
	}
}