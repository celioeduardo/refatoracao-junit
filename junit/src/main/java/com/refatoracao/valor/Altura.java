package com.refatoracao.valor;

public class Altura {
	
	private Double altura;

	public Altura(Double altura) {
		this.altura = altura;
	}

	public Double altura() {
		return altura;
	}
	
	public Altura alterarAltura(Double altura) {
		return new Altura(altura);
	}
	
	public boolean menorQue(Double altura) {
		return this.altura < altura;
	}

	public boolean maiorQue(Double altura) {
		return this.altura > altura;
	}

	public String alturacomoString() {
		return String.valueOf(altura);
	}

}
