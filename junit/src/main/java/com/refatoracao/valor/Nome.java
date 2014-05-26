package com.refatoracao.valor;

public class Nome {
	private String primeiroNome;
	private String sobrenome;
	
	public Nome(String primeiroNome, String sobrenome){
		this.primeiroNome = primeiroNome;
		this.sobrenome = sobrenome;
	}
	
	public String nome(){
		return primeiroNome + " " + sobrenome;
	}

	public String primeiroNome() {
		return primeiroNome;
	}

	public String sobrenome() {
		return sobrenome;
	}
	
	public Nome alterarSobrenome(String sobrenome){
		return new Nome(primeiroNome(),sobrenome);
	}

	public Nome alterarPrimeiroNome(String primeiroNome) {
		return new Nome(primeiroNome,sobrenome());
	}

	public Nome renomear(String primeiroNome, String sobrenome) {
		return new Nome(primeiroNome, sobrenome);
	}
}
