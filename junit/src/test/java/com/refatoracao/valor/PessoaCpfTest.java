package com.refatoracao.valor;

import static org.junit.Assert.*;

import org.junit.Test;

public class PessoaCpfTest {

	@Test
	public void criarPessoaComCpf(){
		Pessoa pessoaComCpf = new Pessoa("Murilo", "Tokunaga",
				new Cpf("50512384592"));
		assertEquals(new Cpf("50512384592"), pessoaComCpf.cpf());
	}
	
}
