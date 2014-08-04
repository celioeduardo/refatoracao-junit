package com.refatoracao.valor.passaro;

public class NorueguesAzul extends Passaro {
	
	private final String tipo = "NORUEGUES AZUL";

	@Override
	public double obterVelocidade() {
		return 25;
	}

	@Override
	public String tipoDoPassaro() {
		return tipo;
	}

}
