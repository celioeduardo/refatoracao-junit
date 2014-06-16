package com.refatoracao.valor;

import static org.junit.Assert.*;

import org.junit.Test;

public class DinheiroTest {

	@Test
	public void novoDinheiroEmReais(){
		Dinheiro grana = new Dinheiro(100);
		assertEquals(new Dinheiro(100),grana);
	}
	@Test
	public void somarDinheiro(){
		Dinheiro grana = new Dinheiro(100);
		grana = grana.adicionar(new Dinheiro(350));
		assertTrue(new Dinheiro(450).equals(grana));
	}
	@Test
	public void subtrairDinheiro(){
		Dinheiro grana = new Dinheiro(350);
		grana = grana.subtrair(new Dinheiro(100));
		assertTrue(new Dinheiro(250).equals(grana));
	}
	@Test
	public void multiplicarDinheiro(){
		Dinheiro grana = new Dinheiro(100);
		grana = grana.vezes(5);
		assertTrue(new Dinheiro(500).equals(grana));
	}
	@Test
	public void igualdadeMoeda(){
		Dinheiro dolar = Dinheiro.emDolares(100);
		dolar = dolar.vezes(5);
		Dinheiro produto = Dinheiro.emDolares(500);
		assertTrue(produto.equals(dolar));
		
		Dinheiro real = Dinheiro.emReais(100);
		real = real.vezes(5);
		produto = Dinheiro.emReais(500);
		assertTrue(produto.equals(real));	
	}
	@Test(expected=IllegalArgumentException.class)
	public void naoPossoSomarMoedasDiferentes(){
		Dinheiro dolar = Dinheiro.emDolares(100);
		Dinheiro real = Dinheiro.emReais(200);
		dolar.adicionar(real);
	}
}
