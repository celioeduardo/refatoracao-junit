package com.refatoracao.valor;

public abstract class Rg {
	protected String rg;
	
	public Rg(String rg) {
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
