package com.refatoracao.valor;

import java.util.InputMismatchException;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Cpf {

	private String cpf;
	
	public Cpf(String cpf) {
		this.cpf = cpf;
		if (!this.eValido(cpf))
			throw new IllegalArgumentException("CPF inválido");
	}

	public Cpf(long cpf) {
		this(String.valueOf(cpf));
	}

	private boolean eValido(String novoCpf) {
		
		if (cpf.equals("00000000000") || cpf.equals("11111111111") 
				|| cpf.equals("22222222222") || cpf.equals("33333333333") 
				|| cpf.equals("44444444444") || cpf.equals("55555555555") 
				|| cpf.equals("66666666666") || cpf.equals("77777777777") 
				|| cpf.equals("88888888888") || cpf.equals("99999999999") 
				|| (cpf.length() != 11) || cpf == null)
			return false;
		
		char dig10, dig11;
		int sm, i, r, num, peso;
		
		try { // Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) { 
				num = (int) (novoCpf.charAt(i) - 48); // (48 eh a posicao de '0' na tabela ASCII)
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico
			
			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (novoCpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48); // Verifica se os digitos calculados
											// conferem com os digitos
											// informados.
			if ((dig10 == novoCpf.charAt(9)) && (dig11 == novoCpf.charAt(10)))
				return true;
			else
				return false;
		} catch (InputMismatchException erro) {
			return false;
		}
		
		
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
		return "Cpf [cpf=" 
				+ cpf 
				+ "]";
	}

}
