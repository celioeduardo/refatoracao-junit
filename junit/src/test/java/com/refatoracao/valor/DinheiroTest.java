package com.refatoracao.valor;

import static org.junit.Assert.*;

import org.junit.Test;

public class DinheiroTest {

	@Test
	public void novoDinheiroEmReais(){
		assertEquals(Dinheiro.emReais(100),Dinheiro.emReais(100));
	}
	@Test
	public void somarDinheiro(){
		assertEquals(Dinheiro.emReais(450),Dinheiro.emReais(100).adicionar(Dinheiro.emReais(350)));
	}
	@Test
	public void somarPercentualDinheiro(){
		assertEquals(Dinheiro.emReais(105),Dinheiro.emReais(100).adicionarPercentual(5));
	}
	@Test
	public void subtrairDinheiro(){
		assertEquals(Dinheiro.emReais(250),Dinheiro.emReais(350).subtrair(Dinheiro.emReais(100)));
	}
	@Test
	public void multiplicarDinheiro(){
		assertEquals(Dinheiro.emReais(500),Dinheiro.emReais(100).vezes(5));
	}
	@Test
	public void igualdadeMoeda(){
		assertEquals(Dinheiro.emDolares(500), Dinheiro.emDolares(100).vezes(5));
		assertEquals(Dinheiro.emReais(500), Dinheiro.emReais(100).vezes(5));
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
