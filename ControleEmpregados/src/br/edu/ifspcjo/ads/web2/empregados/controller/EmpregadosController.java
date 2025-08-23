package br.edu.ifspcjo.ads.web2.empregados.controller;

import br.edu.ifspcjo.ads.web2.empregados.model.*;
import java.util.ArrayList;
import java.util.List;

public class EmpregadosController {

    private List<Empregado> empregados;
    private static EmpregadosController instance;
    
    private EmpregadosController() {
    	this.empregados = new ArrayList<Empregado>();
    }
    
    public static EmpregadosController getInstance() {
    	if(instance == null) {
    		return new EmpregadosController();
    	}
    	return instance;
    }
    
    public List<Empregado> getEmpregados() {
		return empregados;
	}
    
    public void adicionar(Empregado empregado) {
    	empregados.add(empregado);
    }
    
    public Empregado buscarPeloNome(String nome, String sobrenome) {
    	Empregado empregado = null;
    	for(Empregado e: empregados) {
        	if(e.getNome().equalsIgnoreCase(nome) && e.getSobrenome().equalsIgnoreCase(sobrenome)) {
        		empregado = e;
        	}
        }
    	return empregado;
    }
    
}