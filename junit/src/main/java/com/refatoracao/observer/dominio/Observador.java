package com.refatoracao.observer.dominio;

public interface Observador {
	
	void atualizado(int inicio, int fim, int tamanho); 
}
