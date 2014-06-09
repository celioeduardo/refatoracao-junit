package com.refatoracao.valor;

import static org.junit.Assert.*;

import org.junit.Test;

public class PessoaCpfTest {

	@Test
	public void criarPessoaComCpf(){
		Pessoa pessoaComCpf = new Pessoa("Murlo", "Tokunaga", "37507458890");
		assertEquals("37507458890", pessoaComCpf.cpf());
	}
	
	@Test
	public void eCpfValido(){
		Pessoa pessoaComCpf = new Pessoa("Murilo", "Tokunaga", "37507458890");
		pessoaComCpf.validar("37507458890");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void eCpfInvalido(){
		Pessoa pessoaComCpf = new Pessoa("Murilo", "Tokunaga", "37507458890");
		pessoaComCpf.validar("12345678911");
		pessoaComCpf.validar("11111111111");
		pessoaComCpf.validar("123456789");
		pessoaComCpf.validar("");
	}
}
