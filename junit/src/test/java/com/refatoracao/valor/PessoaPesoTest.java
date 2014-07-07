package com.refatoracao.valor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PessoaPesoTest {
	@Test
	public void dieta(){
		Pessoa pessoaComPeso = new Pessoa("Murilo", "Tokunaga", 6, 1989, 80.0);
		pessoaComPeso.emagrecer(60.5);
		assertEquals((Double)60.5, pessoaComPeso.peso());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naDietaPerdesePeso(){
		Pessoa pessoaComPeso = new Pessoa("Murilo", "Tokunaga", 6, 1989, 80.0);
		pessoaComPeso.emagrecer(91.0);
	}
	
	@Test
	public void ganharPeso() {
		Pessoa pessoaComPeso = new Pessoa("Murilo", "Tokunaga", 6, 1989, 60.5);
		pessoaComPeso.engordar(70.5);
		assertEquals((Double)70.5, pessoaComPeso.peso());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void quandoEngordaGanhasePeso(){
		Pessoa pessoaComPeso = new Pessoa("Murilo", "Tokunaga", 6, 1989, 60.5);
		pessoaComPeso.engordar(60.0);
	}
}
