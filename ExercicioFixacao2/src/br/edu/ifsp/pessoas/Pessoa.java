package br.edu.ifsp.pessoas;

public class Pessoa {
	private String nome, logradouro, bairro, cidade;
	private int numero;
	
	public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public Pessoa(String nome, String logradouro, String bairro, String cidade, int numero) {
    	this.nome = nome;
    	this.logradouro = logradouro;
    	this.bairro = bairro;
    	this.cidade = cidade;
    	this.numero = numero;
    }
	
}
