package com.refatoracao.valor;

public class Peso {
	
	private Double peso;
	
	public Peso(Double peso){
		super();
		this.peso = peso;
	}
	
	public Double peso(){
		return peso;
	}
	
	public Peso alterarPeso(Double peso){
		return new Peso(peso);
	}
}
