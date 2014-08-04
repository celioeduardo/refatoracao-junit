package com.refatoracao.valor.passaro;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassaroTest {
	
	Passaro europeu;
	Passaro africano;
	Passaro norueguesAzul;
	
	@Before
	public void criarPassaros() {
		europeu = Passaro.nascer(TipoDePassaro.EUROPEU);
		africano = Passaro.nascer(TipoDePassaro.AFRICANO);
		norueguesAzul = Passaro.nascer(TipoDePassaro.NORUEGUES_AZUL);
	}
	
	@Test 
	public void passaroEhEuropeu() {
		Assert.assertEquals("EUROPEU", europeu.tipoDoPassaro());
	}
	
	@Test
	public void passaroEhAfricano() {
		Assert.assertEquals("AFRICANO", africano.tipoDoPassaro());
	}
	
	@Test
	public void passaroEhNorueguesAzul() {
		Assert.assertEquals("NORUEGUES AZUL", norueguesAzul.tipoDoPassaro());
	}
	
	@Test
	public void velocidadeDoEuropeu() {
		Assert.assertEquals(Double.valueOf(18), Double.valueOf(europeu.obterVelocidade()));
	}
	
	@Test
	public void velocidadeDoAfricano() {
		Assert.assertEquals(Double.valueOf(20), Double.valueOf(africano.obterVelocidade()));
	}
	
	@Test
	public void velocidadeDoNorueguesAzul() {
		Assert.assertEquals(Double.valueOf(25), Double.valueOf(norueguesAzul.obterVelocidade()));
	}

}
