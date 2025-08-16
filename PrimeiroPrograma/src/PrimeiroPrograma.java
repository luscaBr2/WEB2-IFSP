import java.util.Scanner;

public class PrimeiroPrograma {
	public static void main(String[] args) {
		
		// instanciar um objeto da classe Scanner
		Scanner teclado = new Scanner(System.in);
		
		// declarar variaveis necessárias
		int numero1, numero2, soma;

		System.out.print("Digite o primeiro numero inteiro: ");
		numero1 = teclado.nextInt();
		
		System.out.print("Digite o segundo numero inteiro: ");
		numero2 = teclado.nextInt();
		
		soma = numero1 + numero2;
		System.out.println("Soma = " + soma);
		
		teclado.close();
	}
}
