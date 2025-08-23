package br.edu.ifspcjo.ads.web2.empregados.model;

public class Empregado {
    
    private String nome;
    private String sobrenome;
    private double salario;
    
    public Empregado(String nome, String sobrenome, double salario){
        setSobrenome(sobrenome);
        setNome(nome);
        setSalario(salario);
    }
    
    public void setNome(String nome){
        if(nome != null && !nome.equalsIgnoreCase(this.sobrenome)){
            this.nome = nome;
        }else{
            this.nome = ""; // valor default
        }
    }
    
    public void setSobrenome(String sobrenome){
        if(sobrenome != null){
            this.sobrenome = sobrenome;
        }else{
            this.sobrenome = ""; // valor default
        }
    }
    
    public void setSalario(double salario){
        if(salario > 0){
            this.salario = salario;
        }else{
            this.salario = 0; // valor default
        }
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getSobrenome(){
        return sobrenome;
    }
    
    public double getSalario(){
        return salario;
    }
     
    @Override
    public String toString(){
        return "{Nome completo: " + this.nome + " " + this.sobrenome +
                " - Salário: R$ " + String.format("%.2f", this.salario) + "}\n";
    }

}
