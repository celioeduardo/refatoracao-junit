package com.refatoracao.valor;

public class Cnpj {

	private String cnpj;
	private int dig13, dig14;
	
	public Cnpj(String cnpj) {
		this.cnpj = cnpj;
		if (!this.ehValido(this.cnpj.replace(".", "").replace("/", "").replace("-", ""))) {
			throw new IllegalArgumentException("CNPJ inválido.");
		}
	}
	
	public Cnpj(Long cnpj) {
		this.cnpj =  String.valueOf(cnpj);
		if (!this.ehValido(this.cnpj)) {
			throw new IllegalArgumentException("CNPJ inválido.");
		}
	}

	private boolean ehValido(String novoCnpj) {
		
		if (novoCnpj.length() != 14) {
			return false;
		}
		
		int resultado;
		int divisor = 11;
		int posicao = 0;
		int soma = 0;
		int numero;
		
		try {
			
			// primeiro digito
			for (int i = 5; i >= 2; i--) {
				numero = (int) novoCnpj.charAt(posicao) - 48;
				soma += numero * i;
				posicao ++;
			}
			
			for (int i = 9; i >= 2; i--) {
				numero = (int) novoCnpj.charAt(posicao) - 48;
				soma += numero * i;
				posicao ++;
			}
			
			resultado = soma % divisor;
			
			if (resultado < 2) {
				dig13 = 0;
			} else {
				dig13 = 11 - resultado;
			}
			
			// segundo digito
			soma = 0;
			resultado = 0;
			posicao = 0;
			for (int i = 6; i >= 2; i--) {
				numero = (int) novoCnpj.charAt(posicao) - 48;
				soma +=  numero * i;
				posicao ++;
			}
			
			for (int i = 9; i >= 2; i--) {
				numero = (int) novoCnpj.charAt(posicao) - 48;
				soma += numero * i;
				posicao ++;
			}
			
			resultado = soma % divisor;
			
			if (resultado < 2) {
				dig14 = 0;
			} else {
				dig14 = 11 - resultado;
			}
			
			if (dig13 == (int)novoCnpj.charAt(12)-48 && dig14 == (int)novoCnpj.charAt(13)-48) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}

	public int retornaPrimeiroDV() {
		this.ehValido(this.cnpj);
		return dig13;
	}

	public int retornaSegundoDV() {
		this.ehValido(this.cnpj);
		return dig14;
	}
	
}
