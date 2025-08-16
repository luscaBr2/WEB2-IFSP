
/*
 2. Escreva uma classe que represente datas, compostas por dia, mês e ano. Para que uma
data seja instanciada, é necessário que se definam valores para o dia (1-30), mês (1-12)
e ano (>= 1900). Uma vez instanciada, uma data pode ser modificada a qualquer
momento. Observe que, em nenhum momento, uma data poderá assumir algum valor
inválido para o dia, mês ou ano. Crie uma classe que efetue as seguintes tarefas:
a. Instancie uma data com base em valores predefinidos para dia, mês e ano.
b. Modifique a data instanciada a partir de dados lidos do usuário para dia, mês e
ano. Após a modificação, imprima a nova data no formato “dd/mm/aaaa”.
Observe que a impressão da data nesse formato requer que a classe de datas
forneça a string necessária. Use a classe JOptionPane para efetuar a leitura.
 */

import javax.swing.JOptionPane;

public class Data {
	private int dia, mes, ano;	
	
	public int getDia() {
		return this.dia;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public static void main(String[] args) {
		int dia, mes, ano;
		
		do {
			dia = Integer.parseInt(JOptionPane.showInputDialog("Digite um dia: (1 a 30)"));
			
			if(dia > 30 || dia < 0) 
				JOptionPane.showMessageDialog(null, "Insira um dia entre 0 e 30");
			
		} while(dia > 30 || dia <= 0);
		
		do {
			mes = Integer.parseInt(JOptionPane.showInputDialog("Digite um mês: (1 a 12)"));
			
			if(mes > 30 || mes < 0) 
				JOptionPane.showMessageDialog(null, "Insira um mês entre 1 e 12");
			
		} while(mes > 12 || mes <= 0);
		
		do {
			ano = Integer.parseInt(JOptionPane.showInputDialog("Digite um ano: (maior do que 1899)"));
			
			if(ano < 1900) 
				JOptionPane.showMessageDialog(null, "Insira um ano maior que 1899");
			
		} while(ano < 1900);
		
		Data data = new Data(dia, mes, ano);
		
		JOptionPane.showMessageDialog(null, "Data inserida: " + data.getDia() + "/" + data.getMes() + "/" + data.getAno());
		
		do {
			
			dia = Integer.parseInt(JOptionPane.showInputDialog("Digite outro dia: (1 a 30)"));
			
			if(dia > 30 || dia < 0) 
				JOptionPane.showMessageDialog(null, "Insira um dia entre 0 e 30");
			
		} while(dia > 30 || dia <= 0);
		
		data.setDia(dia);
		
		do {
			mes = Integer.parseInt(JOptionPane.showInputDialog("Digite outro mês: (1 a 12)"));
			
			if(mes > 30 || mes < 0) 
				JOptionPane.showMessageDialog(null, "Insira um mês entre 1 e 12");
			
		} while(mes > 12 || mes <= 0);
		
		data.setMes(mes);
		
		do {
			ano = Integer.parseInt(JOptionPane.showInputDialog("Digite outro ano: (maior do que 1899)"));
			
			if(ano < 1900) 
				JOptionPane.showMessageDialog(null, "Insira um ano maior que 1899");
			
		} while(ano < 1900);
		
		data.setAno(ano);
		
		JOptionPane.showMessageDialog(null, "Nova Data inserida: " + data.getDia() + "/" + data.getMes() + "/" + data.getAno());
		
	}
}
