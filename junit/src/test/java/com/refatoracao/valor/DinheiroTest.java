package com.refatoracao.valor;

import static org.junit.Assert.*;
import org.junit.Test;

public class DinheiroTest {

	@Test
	public void moedaReal(){

		Dinheiro cemReais = Dinheiro.emReais(100);
		
		assertEquals(100, cemReais);
		
	}
	
	
}
