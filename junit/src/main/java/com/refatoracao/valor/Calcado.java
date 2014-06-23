package com.refatoracao.valor;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Calcado {

	private Double numeracao;
	private String tipo;
	
	public Calcado(String tipo, Double numeracao) {
		this.tipo = tipo;
		this.numeracao = numeracao;
	}
	
	public Double numeracao(){
		return numeracao;
	}
	
	public String tipo(){
		return tipo;
	}
	
	public Calcado alteraTipo(String novoTipo){
		return new Calcado(novoTipo, numeracao);
	}
	
	private Calcado alteraNumeracao(Double novaNumeracao){
		return new Calcado(tipo, novaNumeracao);
	}
	
	public Calcado aumentaNumeracao(Double novoTamanho) {
		if(numeracao > novoTamanho)
			throw new IllegalArgumentException("Novo tamanho: " + novoTamanho
					+ "tem que ser maior que o tamanho anterior" + this.numeracao);
		return alteraNumeracao(novoTamanho);		
	}
	
	public Calcado diminuiNumeracao(Double novoTamanho) {
		if(this.numeracao < novoTamanho)
			throw new IllegalArgumentException("Novo tamanho: " + novoTamanho
					+ "tem que ser menor que o tamanho anterior" + this.numeracao);
		return alteraNumeracao(novoTamanho);		
	}
	
	@Override
	public boolean equals(Object objeto) {
		boolean objetosIguais = false;

		if (objeto != null && this.getClass() == objeto.getClass()) {
			Calcado objetoTipado = (Calcado) objeto;
			objetosIguais = new EqualsBuilder()
				.append(numeracao, objetoTipado.numeracao)
				.append(tipo, objetoTipado.tipo)
				.isEquals();
		}

		return objetosIguais;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(9519,7)
			.append(numeracao)
			.append(tipo)
			.toHashCode();
	}

	@Override
	public String toString() {
		return "Calcado [tamanho " + numeracao
				+ "tipo " + tipo
				+ "]";
	}
	
}
