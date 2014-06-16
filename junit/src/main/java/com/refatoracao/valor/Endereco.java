package com.refatoracao.valor;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Endereco {
	
	private String rua;
	private String cidade;
	private String uf;
	private String pais;
	private String cep;

	public Endereco(String rua, String cidade, String uf, String pais, String cep) {
		if(rua == null || cidade == null || uf == null || pais == null || cep == null)
			throw new IllegalArgumentException("Informações do endereço não podem ser nulas");
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

	public Endereco alterarRua(String novaRua) {
		return new Endereco(novaRua, cidade, uf, pais, cep);
	}
	
	public Endereco alterarCidade(String novaCidade) {
		return new Endereco(rua, novaCidade, uf, pais, cep);
	}

	@Override
	public boolean equals(Object objeto) {
		boolean objetosIguais = false;

		if (objeto != null && this.getClass() == objeto.getClass()) {
			Endereco objetoTipado = (Endereco) objeto;
			objetosIguais = new EqualsBuilder()
				.append(rua, objetoTipado.rua)
				.append(cidade, objetoTipado.cidade)
				.append(uf, objetoTipado.uf)
				.append(pais, objetoTipado.pais)
				.append(cep, objetoTipado.cep)
				.isEquals();
		}

		return objetosIguais;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(7757,19)
			.append(rua)
			.append(cidade)
			.append(uf)
			.append(pais)
			.append(cep)
			.toHashCode();
	}
	
	@Override
	public String toString() {
		return "Endereco [rua=" 
				+ rua 
				+ ", cidade: " + cidade
				+ ", uf: " + uf
				+ ", pais: " + pais
				+ ", cep: " + cep
				+ "]";
	} 
}