package com.refatoracao.valor;

import static org.junit.Assert.*;

import java.util.Currency;

import org.junit.Test;

public class DinheiroTest {

	@Test
	public void novo(){
		Dinheiro grana = new Dinheiro(100);		
		assertEquals(100, grana.quantia());
	}
	@Test
	public void somarDinheiro(){
		Dinheiro grana = new Dinheiro(100);
		grana = grana.adicionar(new Dinheiro(350));
		assertEquals(100+350, grana.quantia());
	}
	@Test
	public void subtrairDinheiro(){
		Dinheiro grana = new Dinheiro(350);
		grana = grana.subtrair(new Dinheiro(100));
		assertEquals(350-100, grana.quantia());
	}
	@Test
	public void multiplicador(){
		Dinheiro grana = new Dinheiro(100);
		grana = grana.vezes(5);
		assertEquals(5*100, grana.quantia());
	}
}
