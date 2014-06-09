package com.refatoracao.valor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PessoaAlturaTest {
	
	@Test
	public void cresce(){
		Pessoa pessoaComAltura = new Pessoa("Murilo", "Tokunaga", 6, 1989, 60.5, 1.70);
		pessoaComAltura.crescer(1.75);
		assertEquals((Double)1.75, pessoaComAltura.altura());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void noCrescimentoAumentaAltura(){
		Pessoa pessoaComAltura = new Pessoa("Murilo", "Tokunaga", 6, 1989, 60.5, 1.70);
		pessoaComAltura.crescer(1.65);
	}
	
	@Test
	public void encolhe(){
		Pessoa pessoaComAltura = new Pessoa("Murilo", "Tokunaga", 6, 1989, 60.5 ,1.70);
		pessoaComAltura.encolher(1.60);
		assertEquals((Double)1.60, pessoaComAltura.altura());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void noEncolhimentoDiminuiAltura(){
		Pessoa pessoaComAltura = new Pessoa("Murilo", "Tokunaga", 6, 1989, 60.5, 1.70);
		pessoaComAltura.encolher(1.75);
	}
	
}
