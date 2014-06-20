package com.refatoracao.valor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RgTest {
	Rg rgEsperado;
	
	@Before
	public void incializacao() {
		rgEsperado = new RgSaoPaulo("44.950.085-8");
	}
	
	@Test
	public void novoRgSaoPauloFormatado(){
		Assert.assertEquals(rgEsperado, new RgSaoPaulo("44.950.085-8"));
	}
	
	@Test
	public void novoRgSaoPauloNaoFormatado(){
		Assert.assertEquals(rgEsperado, new RgSaoPaulo("449500858"));
	}
	
	@Test
	public void novoRgSaoPauloFormatadoComZeroAEsquerda(){
		Assert.assertEquals(rgEsperado, new RgSaoPaulo("044.950.085-8"));
	}
	
	@Test
	public void novoRgSaoPauloNaoFormatadoComZeroAEsquerda(){
		Assert.assertEquals(rgEsperado, new RgSaoPaulo("0449500858"));
	}

	@Test
	public void novoRgSaoPauloComLong(){
		Assert.assertEquals(rgEsperado, new RgSaoPaulo(449500858L));
	}

	@Test(expected=IllegalArgumentException.class)
	public void novoRgInvalidoEmSaoPaulo(){
		new RgSaoPaulo("00.000.000-0");
	}
	
	@Test(expected=NumberFormatException.class)
	public void novoRgFormatacaoInvalidaEmSaoPaulo_1(){
		new RgSaoPaulo("ab.950.085-8");
	}
	
	@Test(expected=NumberFormatException.class)
	public void novoRgFormatacaoInvalidaEmSaoPaulo_2(){
		new RgSaoPaulo("44.495.008-58");
	}
	
	@Test(expected=NumberFormatException.class)
	public void novoRgFormatacaoInvalidaEmSaoPaulo_3(){
		new RgSaoPaulo("44495.008-8");
	}
}
