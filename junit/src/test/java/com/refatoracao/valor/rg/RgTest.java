package com.refatoracao.valor.rg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.refatoracao.valor.rg.Rg;

public class RgTest {
	Rg rgEsperado;
	
	@Before
	public void incializacao() {
		rgEsperado = Rg.novo("44.950.085-8",Estado.SAO_PAULO);
	}
	
	@Test
	public void novoRgSaoPauloFormatado(){
		Assert.assertEquals(rgEsperado, Rg.novo("44.950.085-8",Estado.SAO_PAULO));
	}
	
	@Test
	public void novoRgSaoPauloNaoFormatado(){
		Assert.assertEquals(rgEsperado, Rg.novo("449500858",Estado.SAO_PAULO));
	}
	
	@Test
	public void novoRgSaoPauloFormatadoComZeroAEsquerda(){
		Assert.assertEquals(rgEsperado, Rg.novo("044.950.085-8",Estado.SAO_PAULO));
	}
	
	@Test
	public void novoRgSaoPauloNaoFormatadoComZeroAEsquerda(){
		Assert.assertEquals(rgEsperado, Rg.novo("0449500858",Estado.SAO_PAULO));
	}

	@Test
	public void novoRgSaoPauloComLong(){
		Assert.assertEquals(rgEsperado, Rg.novo(449500858L,Estado.SAO_PAULO));
	}

	@Test(expected=IllegalArgumentException.class)
	public void novoRgInvalidoEmSaoPaulo(){
		Rg.novo("00.000.000-0",Estado.SAO_PAULO);
	}
	
	@Test(expected=NumberFormatException.class)
	public void novoRgFormatacaoInvalidaEmSaoPaulo_1(){
		Rg.novo("ab.950.085-8",Estado.SAO_PAULO);
	}
	
	@Test(expected=NumberFormatException.class)
	public void novoRgFormatacaoInvalidaEmSaoPaulo_2(){
		Rg.novo("44.495.008-58",Estado.SAO_PAULO);
	}
	
	@Test(expected=NumberFormatException.class)
	public void novoRgFormatacaoInvalidaEmSaoPaulo_3(){
		Rg.novo("44495.008-8",Estado.SAO_PAULO);
	}
}
