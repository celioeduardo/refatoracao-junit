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

	public boolean menorQue(Double peso) {
		return this.peso < peso;
	}

	public boolean maiorQue(double peso) {
		return this.peso > peso;
	}
	
	public String pesoComoString() {
		return  String.valueOf(peso);
	}

}
