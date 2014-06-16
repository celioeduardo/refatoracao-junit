package com.refatoracao.valor;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CnpjTest {
	
	@Test
	public void novoCnpjValido() {
		new Cnpj("11222333000181");
	}
	
	@Test
	public void novoCnpjValidoFormatado() {
		new Cnpj("11.222.333/0001-81");
	}
	
	@Test
	public void cnpjComLong() {
		new Cnpj(11222333000181L);
	}
	
	@Test
	public void igualdade(){
		assertEquals(new Cnpj(11222333000181L),new Cnpj(11222333000181L));
	}
	@Test
	public void igualdadeComCnpjFormatado(){
		assertEquals(new Cnpj(11222333000181L),new Cnpj("11.222.333/0001-81"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void verificarTamanhoCnpj() {
		new Cnpj(111L);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cnpjComErro() {
		new Cnpj("xxx");
	}
	
	@Test
	public void primeiroDigitoVerificador() {
		Cnpj cnpj = new Cnpj("11222333000181");
		Assert.assertEquals(8, cnpj.retornaPrimeiroDV());
	}
	
	@Test
	public void segundoDigitoVerificador() {
		Cnpj cnpj = new Cnpj("11222333000181");
		Assert.assertEquals(1, cnpj.retornaSegundoDV());
	}

}
