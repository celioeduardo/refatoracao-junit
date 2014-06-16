package com.refatoracao.valor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class PessoaEnderecoTest {
	
	@Test
	public void criarPessoaComEndereco(){
		
		Pessoa pessoa = new Pessoa("Tiago", "Costa", new Cpf(36456155800L), 
				new Endereco("José Augusto Mendonça 331", 
				"Miguelópolis", "SP", "Brasil", "14530-000"));
		
		assertEquals(
				"José Augusto Mendonça 331 Miguelópolis SP Brasil 14530-000", 
				pessoa.endereco().endereco());
	}
	
	@Test
	public void alterarEndereco(){
		
		Pessoa pessoa = new Pessoa("Tiago", "Costa", new Cpf(36456155800L), 
				new Endereco("José Augusto Mendonça 331", 
				"Miguelópolis", "SP", "Brasil", "14530-000"));
		
		Endereco novoEndereco = new Endereco("Benedita Rodrigues Domingues 331", 
				"Ribeirão Preto", "SP", "Brasil", "14530-000");
		
		pessoa.alterarEndereco(pessoa.endereco()
				.alterarRua("Benedita Rodrigues Domingues 331")
				.alterarCidade("Ribeirão Preto"));
		
		assertEquals(novoEndereco,pessoa.endereco());
	}

}
