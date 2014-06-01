package com.refatoracao.valor;

public class Pessoa {
	private Nome nome;
	private Idade idade;
	private Peso peso;
	private Altura altura;
	
	public Pessoa(String primeiroNome, String sobrenome) {
		this.nome = new Nome(primeiroNome, sobrenome);
	}

	public Pessoa(String primeiroNome, String sobrenome, int idade) {
		this.nome = new Nome(primeiroNome, sobrenome);
		this.idade = new Idade(idade);
	}

	public Pessoa(String primeiroNome, String sobrenome, int mes, int ano) {
		this.nome = new Nome(primeiroNome, sobrenome);
		this.idade = new Idade(mes, ano);
	}
	
	public Pessoa(String primeiroNome, String sobrenome, int mes, int ano, Double peso) {
		this.nome = new Nome(primeiroNome, sobrenome);
		this.idade = new Idade(mes, ano);
		this.peso = new Peso(peso);
	}
	

	public Pessoa(String primeiroNome, String sobrenome, int mes, int ano, Double peso, Double altura) {
		this.nome = new Nome(primeiroNome, sobrenome);
		this.idade = new Idade(mes, ano);
		this.peso = new Peso(peso);
        this.altura = new Altura(altura);
	}

	public String nome() {
		return nome.nome();
	}

	public String primeiroNome() {
		return nome.primeiroNome();
	}

	public String sobrenome() {
		return nome.sobrenome();
	}

	public void alterarSobrenome(String sobrenome) {
		nome = nome.alterarSobrenome(sobrenome);
	}

	public void alterarPrimeiroNome(String primeiroNome) {
		nome = nome.alterarPrimeiroNome(primeiroNome);
	}

	public void renomear(String primeiroNome, String sobrenome) {
		nome = nome.renomear(primeiroNome, sobrenome);
	}
	
	public void alterarPeso(Double quilos){
		peso = peso.alterarPeso(quilos);
	}
	
	public void redefinirAltura(Double metros) {
		altura = altura.redefinirAltura(metros);
	}
	
	public int idade() {
		return idade.idade();
	}
	
	public Double retornaPeso(){
		return peso.peso();
	} 
	
	public Double retornaAltura(){
		return altura.altura();
	}


}
