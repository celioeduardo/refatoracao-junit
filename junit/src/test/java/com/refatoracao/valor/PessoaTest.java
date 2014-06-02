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
}
