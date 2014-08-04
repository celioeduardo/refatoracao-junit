package com.refatoracao.valor.passaro;

class Europeu extends Passaro {
	
	private final String tipo = "EUROPEU";
	
	@Override
	public double obterVelocidade() {
		return 18;
	}

	@Override
	public String tipoDoPassaro() {
		return tipo;
	}

}
