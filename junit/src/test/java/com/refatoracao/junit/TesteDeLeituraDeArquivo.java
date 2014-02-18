package com.refatoracao.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteDeLeituraDeArquivo {

	private FileReader _entrada;

	@Before
	public void setup() {
		try {
			_entrada = new FileReader(arquivo("/data.txt"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(
					"Não é possível abrir o arquivo de teste");
		}
	}
	
	private String arquivo(String nome){
		return getClass().getResource(nome).getFile();
	}

	@Test
	public void leitura() throws IOException {
		char ch = '&';
		for (int i = 0; i < 4; i++)
			ch = (char) _entrada.read();
		assertTrue('d' == ch);
	}

	@Test
	public void testeDeLeituraAoFinal() throws IOException {
		int ch = -1234;
		for (int i = 0; i <= 168; i++)
			ch = _entrada.read();
		assertEquals(-1, ch);
	}

	@Test
	public void testeDeLeituraDeLimites() throws IOException {
		assertEquals("ler primeiro caracter", 'B', _entrada.read());
		for (int i = 1; i < 167; i++)
			 _entrada.read();
		assertEquals("leitura do último caracter", '6', _entrada.read());
		assertEquals("leitura do final", -1, _entrada.read());
	}

	@Test
	public void testeLeituraVazia() throws IOException {
		File vazio = new File(arquivo("/vazio.txt"));
		FileOutputStream saida = new FileOutputStream(vazio);
		saida.close();
		FileReader entrada = new FileReader(vazio);
		assertEquals(-1, entrada.read());
		entrada.close();
	}
	
	@Test(expected=IOException.class)
	public void testeDeLeituraApósFechar() throws IOException {
		_entrada.close();
		_entrada.read();
	}

	@After
	public void tearDown() {
		try {
			_entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
