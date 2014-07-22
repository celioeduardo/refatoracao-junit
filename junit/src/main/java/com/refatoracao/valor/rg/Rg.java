package com.refatoracao.valor.rg;

public abstract class Rg {
	protected String rg;
	
	public static Rg novo(String rg, Estado estado){
		switch (estado) {
		case SAO_PAULO:
			return new RgSaoPaulo(rg);
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public static Rg novo(long numero,Estado estado) {
		return novo(String.valueOf(numero),estado);
	}

	Rg(String rg) {
		validarFormatacao(rg);
		this.rg = higienizar(rg);		
		validar();
	}
	
	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Rg)
			return rg.equals(((Rg)objeto).rg);
		return false;
	}
	
	@Override
	public int hashCode(){
		return rg.hashCode();
	}

	protected abstract void validarFormatacao(String rg);
	protected abstract String higienizar(String rg);	
	protected abstract void validar();
}
