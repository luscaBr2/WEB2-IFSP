import javax.swing.JOptionPane;

public class SegundoPrograma {
	public static void main(String[] args) {
		
		int numero1, numero2, soma;
		
		numero1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro: "));

		numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro: "));
		
		soma = numero1 + numero2;
		
		JOptionPane.showMessageDialog(null, "Soma = " + soma);
	}
}
