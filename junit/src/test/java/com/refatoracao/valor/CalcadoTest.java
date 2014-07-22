package com.refatoracao.valor;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalcadoTest {

	private Calcado calcado;
	
	@Before
	public void setUp(){
		calcado = new Calcado("Tenis", 41.0);
	}
	
	@Test
	public void novoCalcado(){
		assertEquals(new Calcado("Tenis", 41.0), 
				calcado);
	}
	
	@Test
	public void alteraTipoCalcado(){
		calcado = calcado.alteraTipo("Sapato");
		assertEquals(new Calcado("Sapato", 41.0), calcado);
	}
	
	@Test
	public void aumentaNumereacao(){
		calcado = calcado.aumentaNumeracao(42.0);
		assertEquals(new Calcado("Tenis", 42.0), calcado);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void aumentaNumeracaoMenor(){
		calcado = calcado.aumentaNumeracao(40.0);
	}
	
	@Test
	public void diminuiNumeracao(){
		calcado = calcado.diminuiNumeracao(39.0);
		assertEquals(new Calcado("Tenis", 39.0), calcado);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void diminuiNumeracaoMaior(){
		calcado = calcado.diminuiNumeracao(43.0);
	}
	
}
