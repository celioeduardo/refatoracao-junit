package com.refatoracao.valor;

import java.util.InputMismatchException;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Cpf {

	private String cpf;
	
	public Cpf(String cpf) {
		this.cpf = cpf;
		if(!this.eValido(cpf))
			throw new IllegalArgumentException("Cpf Invalido");
	}

	public Cpf(long cpf){
		this(String.valueOf(cpf));
	}

	private boolean eValido(String cpf) {
		
		if (cpf.equals("00000000000") || cpf.equals("11111111111") 
				|| cpf.equals("22222222222") || cpf.equals("33333333333") 
				|| cpf.equals("44444444444") || cpf.equals("55555555555") 
				|| cpf.equals("66666666666") || cpf.equals("77777777777") 
				|| cpf.equals("88888888888") || cpf.equals("99999999999") 
				|| (cpf.length() != 11) || cpf == null)
			return false;
		
		try { 
			if ((calculoaDigitoVerificador(cpf, 10) == cpf.charAt(9)) 
					&& (calculoaDigitoVerificador(cpf, 11) == cpf.charAt(10)))
				return true;
			else
				return false;
		} catch (InputMismatchException erro) {
			return false;
		}
	}
	
	private char calculoaDigitoVerificador(String cpf, int peso){
		char dig;
		int sm = 0, num, r, max = 0;
		
		if (peso == 10) 
			max = 9;
		else if (peso == 11) 
			max = 10;
		
		for (int i = 0; i < max; i++) { 
			num = (int) (cpf.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		}
		r = 11 - (sm % 11);
		
		if ((r == 10) || (r == 11))
			dig = '0';
		else
			dig = (char) (r + 48);
		
		return dig;
	}
	
	
	@Override
	public boolean equals(Object objeto) {
		boolean objetosIguais = false;

		if (objeto != null && this.getClass() == objeto.getClass()) {
			Cpf objetoTipado = (Cpf) objeto;
			objetosIguais = new EqualsBuilder()
				.append(cpf, objetoTipado.cpf)
				.isEquals();
		}

		return objetosIguais;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(9519,7)
			.append(cpf)
			.toHashCode();
	}

	@Override
	public String toString() {
		return "Cpf [cpf " 
				+ cpf 
				+ "]";
	}
	
}
