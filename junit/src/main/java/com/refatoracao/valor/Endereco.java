package com.refatoracao.valor;

public class Endereco {
	
	private String rua;
	private String cidade;
	private String uf;
	private String pais;
	private String cep;

	public Endereco(String rua, String cidade, String uf, String pais, String cep) {
		this.rua = rua;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
		this.cep = cep;
	}
	
	public String endereco(){
		return rua +" "+ cidade +" "+ uf +" "+ pais +" "+ cep;
	}
	
	public String rua(){
		return rua;
	}
	
	public String cidade(){
		return cidade;
	}

	public String uf(){
		return uf;
	}
	
	public String pais(){
		return pais;
	}
	
	public String cep(){
		return cep;
	}

	public Endereco alterarEndereco( String rua, String cidade, String uf, String pais, String cep) {
		return new Endereco(rua, cidade, uf, pais, cep);
	}
}