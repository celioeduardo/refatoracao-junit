package com.refatoracao.valor;

public class Altura {
	
	private Double altura;

	public Altura(Double altura) {
		this.altura = altura;
	}

	public Double altura() {
		return altura;
	}
	
	public Altura redefinirAltura(Double altura) {
		return new Altura(altura);
	}

}
