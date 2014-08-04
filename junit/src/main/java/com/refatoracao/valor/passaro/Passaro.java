package com.refatoracao.valor.passaro;

public abstract class Passaro {
	
	public static Passaro nascer(TipoDePassaro tipoDePassaro) {
		switch (tipoDePassaro) {
		case EUROPEU:
			return new Europeu();
		case AFRICANO: 
			return new Africano();
		case NORUEGUES_AZUL:
			return new NorueguesAzul();
		default:
			throw new IllegalArgumentException("Tipo não definido");
		}
		
	}
	
	public abstract double obterVelocidade();
	public abstract String tipoDoPassaro();
	
}
