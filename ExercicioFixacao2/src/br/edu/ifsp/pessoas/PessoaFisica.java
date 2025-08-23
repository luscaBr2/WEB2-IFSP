package br.edu.ifsp.pessoas;

public class PessoaFisica extends Pessoa {
	private int cpf;
	
	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public PessoaFisica(int cpf, String nome, String logradouro, String bairro, String cidade, int numero) {
		super(nome, logradouro, bairro, cidade, numero);
		this.cpf = cpf;
	}
	
	public String tostring() {
		return "[PessoaFísica | "
				+ "CPF = " + this.getCpf() + " | "
				+ "Logradouro = "+this.getLogradouro()+" | "
				+ "Bairro = "+this.getBairro()+" | "
				+ "Cidade = "+this.getCidade()+" | "
				+ "Número = "+this.getNumero()+" | ";
	}

}
