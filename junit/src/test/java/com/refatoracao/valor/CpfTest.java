package com.refatoracao.valor;

import org.junit.Assert;
import org.junit.Test;

public class CpfTest {
	
	@Test
	public void novoComString(){
		Cpf cpf = new Cpf("61720970599");
		Assert.assertEquals(new Cpf("61720970599"), cpf);
	}
	
	@Test
	public void novoComLong(){
		Cpf cpf = new Cpf(61720970599L);
		Assert.assertEquals(new Cpf("61720970599"), cpf);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalido(){
		new Cpf("ABC");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalido00000000000(){
		new Cpf("00000000000");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalido11111111111(){
		new Cpf("11111111111");
	}
	
	@Test
	public void validoComZeroAEsquerda(){
		new Cpf("07135704665");
	}
	
	@Test(expected=IllegalArgumentException.class) //TODO permitir
	public void validoSemZeroAEsquerda(){
		new Cpf("7135704665");
	}
}
