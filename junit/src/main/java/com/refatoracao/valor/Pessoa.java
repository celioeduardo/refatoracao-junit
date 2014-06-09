package com.refatoracao.valor;

public class Pessoa {
	private Nome nome;
	private Idade idade;
	private Peso peso;
	private Altura altura;
	private Cpf cpf;
	
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

	public Pessoa(String primeiroNome, String sobrenome, Cpf cpf) {		
		this.nome = new Nome(primeiroNome, sobrenome);
		this.cpf = cpf;
	}
	
	public Cpf cpf(){
		return cpf;
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
	
	public int idade() {
		return idade.idade();
	}
	
	public Double peso(){
		return peso.peso();
	} 
	
	public Double altura(){
		return altura.altura();
	}

	public void emagrecer(Double quilos){
		if (peso.menorQue(quilos))
			throw new IllegalArgumentException("Novo Peso " + quilos 
					+ "tem que ser menor que o anterior."+peso.pesoComoString());
		
		setPeso(peso.alterarPeso(quilos));
	}
	
	public void engordar(double novoPeso) {
		if (peso.maiorQue(novoPeso))
			throw new IllegalArgumentException("Novo Peso" + novoPeso 
					+"tem que ser maior que o anterior."+peso.pesoComoString());
		setPeso(peso.alterarPeso(novoPeso));
	}
	
	private void setPeso(Peso peso){
		if (peso == null)
			throw new IllegalArgumentException("Peso n�o pode ser nulo");
		this.peso = peso;
	}
	
	public void crescer(Double novaAltura) {
		if(altura.maiorQue(novaAltura))
			throw new IllegalArgumentException("Nova altura: " + novaAltura
					+ "tem que ser maior que altura anterior"+altura.alturacomoString());
		setAltura(altura.alterarAltura(novaAltura));
	}

	public void encolher(Double novaAltura) {
		if(altura.menorQue(novaAltura))
			throw new IllegalArgumentException("Nova altura: " + novaAltura
					+ "tem que ser menor que altura anterior" + altura.alturacomoString());
		setAltura(altura.alterarAltura(novaAltura));		
	}
	
	private void setAltura(Altura altura){
		if(altura == null)
			throw new IllegalArgumentException("Altura n�o pode ser nula");
		this.altura = altura;
	}

}
