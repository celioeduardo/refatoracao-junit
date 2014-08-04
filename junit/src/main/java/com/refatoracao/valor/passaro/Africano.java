package com.refatoracao.valor.passaro;

public class Africano extends Passaro {
	
	private final String tipo = "AFRICANO";

	@Override
	public double obterVelocidade() {
		return 20;
	}

	@Override
	public String tipoDoPassaro() {
		return tipo;
	}

}
