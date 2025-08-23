package br.edu.ifspcjo.ads.web2.empregados.view;
import br.edu.ifspcjo.ads.web2.empregados.controller.*;
import br.edu.ifspcjo.ads.web2.empregados.model.*;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        EmpregadosController controller = EmpregadosController.getInstance();
        int opcao;
        do {
        	opcao = Integer.parseInt(JOptionPane.showInputDialog(
        			"Escolha uma opção:"
        			+ "\n1 - Adicionar um empregado"
        			+ "\n2 - Buscar um empregado pelo nome"
        			+ "\n3 - Listagem de empregados"
        			+ "\n4 - Sair"));
        	switch (opcao) {
				case 1: {
					adicionar(controller);
					break;
				}
				case 2: {
					buscarPeloNome(controller);
					break;
				}
				case 3: {
					listar(controller);
					break;
				}
				case 4: {
					break;
				}
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!");
			}
        }while(opcao != 4);
        
    }
    
    private static void listar(EmpregadosController controller) {
		JOptionPane.showMessageDialog(null, controller.getEmpregados());
	}

	public static void adicionar(EmpregadosController controller) {
    	String nome = JOptionPane.showInputDialog("Digite o nome do empregado");
    	String sobrenome = JOptionPane.showInputDialog("Digite o sobrenome do empregado");
    	double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do empregado"));
    	controller.adicionar(new Empregado(nome, sobrenome, salario));
    }
    
    public static void buscarPeloNome(EmpregadosController controller) {
    	String nome = JOptionPane.showInputDialog("Digite o nome do empregado");
    	String sobrenome = JOptionPane.showInputDialog("Digite o sobrenome do empregado");
    	Empregado empregado = controller.buscarPeloNome(nome, sobrenome);
    	if(empregado != null) {
			JOptionPane.showMessageDialog(null, empregado);
		}else {
			JOptionPane.showMessageDialog(null, "Empregado não encontrado");
		}
    }
    
}
