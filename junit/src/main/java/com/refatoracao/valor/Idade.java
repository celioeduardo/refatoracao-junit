package com.refatoracao.valor;

public class Idade {
	private int idade;

	public Idade(int idade) {
		super();
		this.idade = idade;
	}
	
	public Idade(int mes, int ano) {
		idade = 2014 - ano;
	}

	public int idade(){
		return idade;
	}

}
