package com.refatoracao.observer.dominio;

import java.util.ArrayList;
import java.util.List;

public class Intervalo {
	private int inicio;
	private int fim;
	private int tamanho;
	private List<Observador> observadores = new ArrayList<Observador>();
	
	public Intervalo(int inicio, int fim) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		calcularTamanho();
	}
	
	public void alterarInicio(int novoInicio){
		this.inicio = novoInicio;
		calcularTamanho();
	}
	
	private void calcularTamanho(){
		this.tamanho = fim - inicio;
		for (Observador observador : this.observadores) {
			observador.atualizado(inicio, fim, tamanho);
		}
	}
	
	public void registrarObservador(Observador observador){
		this.observadores.add(observador); 
	}
}
