package br.edu.ifspcjo.ads.cjoweb2.model;

import java.util.List;

public class Aluno {
	
	private String nome;
	private List<String> emails;
	private List<String> cursos;

	public List<String> getCursos() {
		return cursos;
	}

	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public Aluno(String nome, List<String> emails, List<String> cursos) {
		this.nome = nome;
		this.emails = emails;
		this.cursos = cursos;
	}
	
	
	
}
