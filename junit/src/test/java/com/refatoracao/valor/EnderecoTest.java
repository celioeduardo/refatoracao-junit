package com.refatoracao.valor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EnderecoTest {
	
	private Endereco endereco;
	
	@Before
	public void setUp(){
		endereco = new Endereco(
				"Casemiro de Abreu",
				"Ribeirão Preto",
				"SP", 
				"Brasil",
				"14020060");
	}
	
	@Test
	public void novoEndereco(){
		
		assertEquals(new Endereco(
				"Casemiro de Abreu",
				"Ribeirão Preto",
				"SP", 
				"Brasil",
				"14020060"),endereco);
		
	}
	
	@Test
	public void alterarRua(){
		endereco = endereco.alterarRua("Casemiro");
		
		assertEquals(new Endereco(
				"Casemiro",
				"Ribeirão Preto",
				"SP", 
				"Brasil",
				"14020060"),endereco);
		
	}
	@Test
	public void alterarCidade(){
		endereco = endereco.alterarCidade("São Paulo");
		
		assertEquals(new Endereco(
				"Casemiro de Abreu",
				"São Paulo",
				"SP", 
				"Brasil",
				"14020060"),endereco);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void enderecoNaoPreenchido(){
		new Endereco(null,null,null,null,null);
	}
	
	
	
	

}
