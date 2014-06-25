package com.refatoracao.valor;

import static org.junit.Assert.*;

import org.junit.Test;

public class DinheiroTest {

	@Test
	public void novoDinheiroEmReais(){
		Dinheiro grana = Dinheiro.emReais(100);
		assertEquals(Dinheiro.emReais(100),grana);
	}
	@Test
	public void somarDinheiro(){
		Dinheiro grana = Dinheiro.emReais(100);
		grana = grana.adicionar(Dinheiro.emReais(350));
		assertEquals(Dinheiro.emReais(450),grana);
	}
	@Test
	public void subtrairDinheiro(){
		Dinheiro grana = Dinheiro.emReais(350);
		grana = grana.subtrair(Dinheiro.emReais(100));
		assertEquals(Dinheiro.emReais(250),grana);
	}
	@Test
	public void multiplicarDinheiro(){
		Dinheiro grana = Dinheiro.emReais(100);
		grana = grana.vezes(5);
		assertEquals(Dinheiro.emReais(500),grana);
	}
	@Test
	public void igualdadeMoeda(){
		Dinheiro dolar = Dinheiro.emDolares(100);
		dolar = dolar.vezes(5);
		assertEquals(Dinheiro.emDolares(500), dolar);
		Dinheiro real = Dinheiro.emReais(100);
		real = real.vezes(5);
		assertEquals(Dinheiro.emReais(500), real);
	}
	@Test(expected=IllegalArgumentException.class)
	public void naoPossoSomarMoedasDiferentes(){
		Dinheiro dolar = Dinheiro.emDolares(100);
		Dinheiro real = Dinheiro.emReais(200);
		dolar.adicionar(real);
	}
	@Test
	public void formatacao(){
		Dinheiro dolar = Dinheiro.emDolares(100.26);
		System.out.println(dolar.toString());
		Dinheiro real = Dinheiro.emReais(100.999);
		System.out.println(real.toString());
	}
}
