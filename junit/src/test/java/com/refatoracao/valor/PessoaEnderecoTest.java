package com.refatoracao.valor;

import org.junit.Assert;
import org.junit.Test;


public class PessoaEnderecoTest {
	
	@Test
	public void criarPessoaComEndereco(){
		
		Pessoa pessoa = new Pessoa("Tiago", "Costa", new Cpf(36456155800L), "José Augusto Mendonça 331", 
				"Miguelópolis", "SP", "Brasil", "14530-000");
		
		Assert.assertEquals("José Augusto Mendonça 331 Miguelópolis SP Brasil 14530-000", pessoa.endereco().endereco());
	}
	
	@Test
	public void alterarEndereco(){
		
		Pessoa pessoa = new Pessoa("Tiago", "Costa", new Cpf(36456155800L), "José Augusto Mendonça 331", 
				"Miguelópolis", "SP", "Brasil", "14530-000");
		
		pessoa.alterarEndereco("Benedita Rodrigues Domingues 821", 
				"Ribeirão Preto", "SP", "Brasil", "99999-000");
		
		Assert.assertEquals("Benedita Rodrigues Domingues 821 Ribeirão Preto SP Brasil 99999-000",pessoa.endereco().endereco());
	}

}
