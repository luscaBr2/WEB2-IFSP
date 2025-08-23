
/*
Escreva um programa que simule um gerenciador de sons de instrumentos. Inicialmente,
os seguintes instrumentos devem ser considerados: guitarras, baterias e pianos. Todos os
instrumentos devem fornecer um método chamado tocar(), responsável em simular o
som de cada tipo de instrumento. Crie uma janela gráfica que permita ao usuário digitar
o nome de um instrumento e clicar em um botão. Como resposta, o programa deverá
fazer o instrumento tocar (exibindo na tela uma mensagem de simulação). Use o conceito
de interfaces para resolver esse problema.
 */

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
    	String escolha;
        do {
        	escolha = JOptionPane.showInputDialog("O que deseja tocar?\nGuitarras, bateria ou piano?\nEscreva \"sair\" para encerrar.");

            if (escolha.equalsIgnoreCase("sair"))
                return; 
            
            Instrumento instrumento = new Instrumento(escolha);

            JOptionPane.showMessageDialog(null, instrumento.tocar());
        }while(!escolha.equalsIgnoreCase("sair"));
    }
}

