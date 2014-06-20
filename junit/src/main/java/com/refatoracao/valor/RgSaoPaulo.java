package com.refatoracao.valor;

import java.util.regex.Pattern;

public class RgSaoPaulo extends Rg{
	
	public RgSaoPaulo(String rg) {
		super(rg);
	}
	
	public RgSaoPaulo(long rg) {
		super(String.valueOf(rg));
	}
	
	@Override
	protected void validarFormatacao(String rg) {
		if (!Pattern.compile("^0?\\d{2}\\.\\d{3}\\.\\d{3}-\\d$|^0?\\d{9}$").matcher(rg).find())
			throw new NumberFormatException("Formato de RG incorreto para o estado de São Paulo.");		
	}

	protected String higienizar(String rg) {
		return String.format("%10s", rg.replaceAll("\\.|-", "")).replace(" ", "0");
	}

	protected void validar() {
		int v = 0;
		
		for (int i = 0; i < rg.length(); i++)
			if (i == rg.length()-1)
				v += 100*Integer.parseInt(String.valueOf(rg.charAt(i)));
			else
				v += (i+1)*Integer.parseInt(String.valueOf(rg.charAt(i)));
		
		if ((v == 0) || ((v % 11) != 0))
			throw new IllegalArgumentException("RG inválido para o estado de São Paulo.");
	}
	
}
