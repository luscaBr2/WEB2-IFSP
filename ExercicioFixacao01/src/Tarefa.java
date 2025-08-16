
/*
3. Escreva uma classe em Java para representar tarefas. Toda tarefa possui código e título,
e ambos os valores são obrigatórios durante a instanciação de uma tarefa. Além disso,
para cada tarefa, deve haver uma forma para que se modifiquem e acessem seus dados
a qualquer momento. Considere o conceito de encapsulamento. Crie uma classe,
composta pelo método main(), para gerenciar uma lista de tarefas. Essa classe deve
possuir um menu com as seguintes opções:
a. Adicionar uma tarefa.
b. Remover uma tarefa.
c. Listar todas as tarefas.
d. Sair do programa.
Dica: Use um loop do-while para permitir que o usuário interaja com o programa até
escolher a opção de sair.
 */

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Tarefa {
	private int codigo;
	private String titulo;
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Tarefa(int codigo, String titulo) {
		this.codigo = codigo;
		this.titulo = titulo;
	}
	
	public static void main(String[] args) {
		int opcao;
		
		ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Insira uma opção: \n"
					+ "1. Adicionar uma tarefa.\r\n"
					+ "2. Remover uma tarefa.\r\n"
					+ "3. Listar todas as tarefas.\r\n"
					+ "4. Sair do programa."));
			
			switch(opcao) {
			case 1: 
				tarefas.add(new Tarefa(Integer.parseInt(JOptionPane.showInputDialog("Insira um código inteiro: ")), JOptionPane.showInputDialog("Insira o título da tarefa: ")));
				JOptionPane.showMessageDialog(null, "Tarefa incluida!");
				break;
				
			case 2:
				
				int cod = Integer.parseInt(JOptionPane.showInputDialog("Informe o código da tarefa a remover:"));
			    
			    boolean statusExclusao = tarefas.removeIf(t -> t.getCodigo() == cod);

				JOptionPane.showMessageDialog(null, ( statusExclusao == true ? "Tarefa incluida :)" : "Erro ao excluir :("));
				break;
				
			case 3:
				String listaTarefas = "";
				
				for (Tarefa tarefa: tarefas) 
					listaTarefas += tarefa.getCodigo() + " - " + tarefa.getTitulo() + "\n";
				
				JOptionPane.showMessageDialog(null, "Listagem de todas as tarefas: \n" + listaTarefas);
				break;
				
			case 4:
				JOptionPane.showMessageDialog(null, "Até mais :)");
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Insira um numero de 1 a 4");
				break;
				
			}
			
		} while(opcao != 4);
	}
	
}
