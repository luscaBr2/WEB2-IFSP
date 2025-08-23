package br.edu.ifsp.pessoas;

import javax.swing.JOptionPane;

/*
Defina um pacote chamado br.edu.ifsp.pessoas que contenha classes para representar
pessoas físicas e pessoas jurídicas. Sabe-se que toda pessoa física possui nome, CPF e
endereço. Toda pessoa jurídica possui nome, CNPJ e endereço. Um endereço deve
armazenar logradouro, número, bairro e cidade. Independentemente do tipo, para que
uma pessoa seja instanciada, todos os seus dados devem ser definidos por classes
clientes. Crie um método que retorne todos os dados, na forma de uma string, tanto para
pessoas físicas quanto para pessoas jurídicas. Considere a reutilização de código nesse
exercício.
 */

public class Principal {
	public static void main(String[] args) {
		
		int tipoPessoa;
		
		do {
			tipoPessoa = Integer.parseInt(JOptionPane.showInputDialog("Selecione o tipo de pessoa: \n1 - Física\n2 - Jurídica"));
			if (tipoPessoa <= 0 || tipoPessoa > 2)
				JOptionPane.showMessageDialog(null, "Insira 1 ou 2!");
		} while (tipoPessoa <= 0 || tipoPessoa > 2);
		
		String nome, logradouro, bairro, cidade;
		int numero;
		
		nome = JOptionPane.showInputDialog("Insira seu nome: ");
		logradouro = JOptionPane.showInputDialog("Insira seu logradouro: ");
		bairro = JOptionPane.showInputDialog("Insira seu bairro: ");
		cidade = JOptionPane.showInputDialog("Insira sua cidade: ");
		numero = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da sua casa: "));
		
		if (tipoPessoa == 1) {
			int cpf = Integer.parseInt(JOptionPane.showInputDialog("Insira seu CPF(apenas numeros): "));
			PessoaFisica usuario = new PessoaFisica(cpf, nome, logradouro, bairro,  cidade, numero);
			JOptionPane.showMessageDialog(null, "Dados inseridos: \n" + usuario.tostring());
		}
		
		if (tipoPessoa == 2) {
			int cnpj = Integer.parseInt(JOptionPane.showInputDialog("Insira seu CNPJ(apenas numeros): "));
			PessoaJuridica usuario = new PessoaJuridica(cnpj, nome, logradouro, bairro,  cidade, numero);
			JOptionPane.showMessageDialog(null, "Dados inseridos: \n" + usuario.tostring());
		}
		
		
	}
}
