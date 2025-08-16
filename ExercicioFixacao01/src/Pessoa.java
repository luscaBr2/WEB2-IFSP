
/* 1)
Escreva uma classe em Java para representar pessoas. Toda pessoa possui nome e idade,
e ambos os valores são obrigatórios durante a instanciação de uma pessoa. Além disso,
para cada pessoa, deve haver uma forma para que se modifiquem e acessem seus dados
a qualquer momento. Considere o conceito de encapsulamento. Crie uma classe,
composta pelo método main(), para efetuar as seguintes tarefas:
a. Instancie uma pessoa com base em valores predefinidos para nome e idade.
b. Modifique o nome e a idade (a partir de valores predefinidos) da pessoa
instanciada, e imprima a nova idade.
 */

import java.util.Scanner;

public class Pessoa {
	private int idade;
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public Pessoa(String nome, int idade){
		this.idade = idade;
		this.nome = nome;
	}
	
	public static void main(String args[]) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Digite seu nome: ");
		String nome = teclado.next();
		
		System.out.print("\nDigite sua idade: ");
		int idade = teclado.nextInt();
		
		Pessoa usuario = new Pessoa(nome, idade);
		
		System.out.println("Nome = " + usuario.getNome() + " | Idade = " + usuario.getIdade());
		
		System.out.print("Digite outro nome: ");
		usuario.setNome(teclado.next());
		
		System.out.print("\nDigite outra idade: ");
		usuario.setIdade(teclado.nextInt());
		
		System.out.println("Valores alterados!");
		System.out.println("Nome = " + usuario.getNome() + " | Idade = " + usuario.getIdade());
		
		teclado.close();
	}
	
	
}
