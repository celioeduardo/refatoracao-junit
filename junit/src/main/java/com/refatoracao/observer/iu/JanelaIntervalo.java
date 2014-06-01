package com.refatoracao.observer.iu;

import com.refatoracao.observer.dominio.Intervalo;
import com.refatoracao.observer.dominio.Observador;

public class JanelaIntervalo implements Observador{
	private String nome;
	private String inicio;
	private String fim;
	private String tamanho;
	private Intervalo intervalo;
	
	public JanelaIntervalo(String nome, Intervalo intervalo){
		this.nome = nome;
		this.intervalo = intervalo;
	}
	
	public void atualizado(int inicio, int fim, int tamanho) {
		this.inicio = String.valueOf(inicio);
		this.fim = String.valueOf(fim);
		this.tamanho = String.valueOf(tamanho);
		redimensionar();
	}
	
	public void alterarInicio(String novoInicio){
		intervalo.alterarInicio(Integer.parseInt(novoInicio));
	}
	
	private void redimensionar(){
		System.out.println("[" +this.nome+ "] "+ 
				"Janela redimensionada. "+
				"Início: "+inicio+
				", Fim: "+fim+
				", Tamanho: "+tamanho
				);
	}
	
	
}
