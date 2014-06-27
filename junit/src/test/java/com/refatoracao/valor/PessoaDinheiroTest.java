package com.refatoracao.valor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PessoaDinheiroTest {
	private Pessoa obterNovaPessoaComSalarioDeMil(){
		Pessoa kent = new Pessoa("Kent","beck");  
		kent.novoSalario(Dinheiro.emReais(1000));
		return kent;
	}
	@Test
	public void salario(){
		Pessoa kent = obterNovaPessoaComSalarioDeMil();
		assertEquals(Dinheiro.emReais(1000),kent.salarioAtual());
	}
	@Test
	public void aumentoSalarialEmQuantia(){
		Pessoa kent = obterNovaPessoaComSalarioDeMil();
		kent.aumentoSalarial(Dinheiro.emReais(325));
		assertEquals(Dinheiro.emReais(1000+325),kent.salarioAtual());
	}
	@Test
	public void aumentoSalarialEmPercentagem(){
		Pessoa kent = obterNovaPessoaComSalarioDeMil();
		kent.aumentoSalarial(15);
		assertEquals(Dinheiro.emReais(1000+150),kent.salarioAtual());
	}
	//apoucamento, decréscimo, subtração, atenuação, enfraquecimento, restrição, estreitamento, encolhimento, encolhedela, 
	//limitação, moderação, diminuição, apequenamento, míngua, redução, decremento, minoração, controle, encurtamento.
	@Test
	public void diminuicaoSalarialEmQuantia(){
		Pessoa kent = obterNovaPessoaComSalarioDeMil();
		kent.diminuicaoSalarial(Dinheiro.emReais(325));
		assertEquals(Dinheiro.emReais(1000-325),kent.salarioAtual());
	}
	@Test
	public void diminuicaoSalarialEmPercentagem(){
		Pessoa kent = obterNovaPessoaComSalarioDeMil();
		kent.diminuicaoSalarial(15);
		assertEquals(Dinheiro.emReais(1000-150),kent.salarioAtual());
	}
}
