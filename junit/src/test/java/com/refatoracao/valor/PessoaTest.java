package com.refatoracao.valor;

import static org.junit.Assert.*;

import org.junit.Test;

import com.refatoracao.valor.Pessoa;


public class PessoaTest {
	
	
	@Test
	public void criarMartin(){
		Pessoa martin = new Pessoa("Martin","Fowler");
		
		assertEquals("Martin Fowler", martin.nome());
		assertEquals("Martin",  martin.primeiroNome());
		assertEquals("Fowler",  martin.sobrenome());
		
	}
	
	@Test
	public void criarKent(){
		Pessoa kent = new Pessoa("Kent","Beck");
		
		assertEquals("Kent Beck", kent.nome());
		assertEquals("Kent", kent.primeiroNome());
		assertEquals("Beck", kent.sobrenome());
		
	}
	
	@Test 
	public void alterarPrimeiroNome(){
		Pessoa kevin = new Pessoa("Kevinx", "Mitnick");
		
		kevin.alterarPrimeiroNome("Kevin");
		
		assertEquals("Kevin",kevin.primeiroNome());
	}
	
	@Test
	public void alterarSobrenome(){
		Pessoa kevin = new Pessoa("Kevin", "Mitnik");
		
		kevin.alterarSobrenome("Mitnick");
		
		assertEquals("Mitnick",kevin.sobrenome());
		
	}
	
	@Test
	public void renomear(){
		Pessoa kevin = new Pessoa("KevinX", "MitinickX");
		
		kevin.renomear("Kevin","Mitnick");
		
		assertEquals("Kevin Mitnick", kevin.nome());
	}
	
	@Test
	public void idade(){
		Pessoa pessoa = new Pessoa("Nome","Sobrenome",25);
		
		assertEquals(25,pessoa.idade());
	}
	
	@Test
	public void idadePeloAno(){
		Pessoa pessoa = new Pessoa("Nome","Sobrenome",6,1980);

		assertEquals(34,pessoa.idade());
	}
	
	@Test
	public void dieta(){
		Pessoa pessoaComPeso = new Pessoa("Tiago", "Costa", 9, 1986, 90.5);
		
		pessoaComPeso.emagrecer(80.1);
		
		assertEquals((Double)80.1, pessoaComPeso.peso());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naDietaPerdesePeso(){
		Pessoa pessoaComPeso = new Pessoa("Tiago", "Costa", 9, 1986, 90.5);
		pessoaComPeso.emagrecer(91.0);
	}
	
	@Test
	public void ganharPeso() {
		Pessoa pessoaComPeso = new Pessoa("Tiago", "Costa", 9, 1986, 80.1);
		
		pessoaComPeso.engordar(90.5);
		
		assertEquals((Double)90.5, pessoaComPeso.peso());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void quandoEngordaGanhasePeso(){
		Pessoa pessoaComPeso = new Pessoa("Tiago", "Costa", 9, 1986, 90.5);
		pessoaComPeso.engordar(81.0);
	}
	@Test
	public void definirAltura(){
		Pessoa pessoaComAltura = new Pessoa("Tiago", "Costa", 9, 1986, 80.0, 1.78);
		
		pessoaComAltura.redefinirAltura(1.90);
		
		assertEquals((Double)1.90, pessoaComAltura.retornaAltura());
	}
	
}
