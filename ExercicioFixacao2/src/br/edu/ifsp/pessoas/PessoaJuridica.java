package br.edu.ifsp.pessoas;

public class PessoaJuridica extends Pessoa {
	
	private int cnpj;
	
	public int getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(int cpf) {
		this.cnpj = cpf;
	}
	
	public PessoaJuridica(int cnpj, String nome, String logradouro, String bairro, String cidade, int numero) {
		super(nome, logradouro, bairro, cidade, numero);
		this.cnpj = cnpj;
	}
	
	public String tostring() {
		return "[PessoaJuridica | "
				+ "CNPJ = " + this.getCnpj() + " | "
				+ "Logradouro = "+this.getLogradouro()+" | "
				+ "Bairro = "+this.getBairro()+" | "
				+ "Cidade = "+this.getCidade()+" | "
				+ "Número = "+this.getNumero()+" | ";
	}
}
