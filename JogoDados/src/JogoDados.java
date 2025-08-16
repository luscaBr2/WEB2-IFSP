import java.util.Random;

import javax.swing.JOptionPane;

public class JogoDados {
	
	public static void main(String[] args){
		//instanciar um objeto de classe Random
		Random geradorAleatorios = new Random();
		// declarar variaveis
		int D1, D2, soma, tentativa, aposta, opc;
		boolean acertou;
		// repeticao do jogo
		do {
			//lançar os dados
			D1 = geradorAleatorios.nextInt(6)+1;
			D2 = geradorAleatorios.nextInt(6)+1;
			//calcular a soma dos dados
			soma = D1 + D2;
			System.out.println("D1 = " + D1 + "D2 = " + D2 + "SOMA = " + soma );
			//variavel acertou
			acertou = false;
			//inicializar tentativas com valor 3
			tentativa = 3;
			while(!acertou && tentativa > 0) {
				aposta = Integer.parseInt(JOptionPane.showInputDialog("digite sua aposta: "));
				if (aposta > 12) {
					JOptionPane.showMessageDialog(null, "TU É BURRO MLK, PORRA");
				}
				tentativa--;
				if(aposta == soma) {
					acertou = true;
				}else {
					JOptionPane.showMessageDialog(null, "voce errou! voce ainda tem: " + tentativa);
				}
			}
			if(acertou) {
				JOptionPane.showMessageDialog(null, "BOAAAAA CARALHOOOO!!");
			} else {
				JOptionPane.showMessageDialog(null, "JA ERA FIH!");
			}
			//perguntar-se o user deseja jogar novamente
			opc = JOptionPane.showInternalConfirmDialog(null, "deseja jogar novamente");
			
		}while(opc == 0);
	}
}
