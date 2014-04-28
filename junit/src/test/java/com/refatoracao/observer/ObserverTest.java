package com.refatoracao.observer;

import org.junit.Before;
import org.junit.Test;

import com.refatoracao.observer.dominio.Intervalo;
import com.refatoracao.observer.iu.JanelaIntervalo;

public class ObserverTest {
	
	private Intervalo intervalo;
	private JanelaIntervalo window;
	private JanelaIntervalo ie;
	private JanelaIntervalo chrome;
	private JanelaIntervalo safari;
	private JanelaIntervalo tor;
	private JanelaIntervalo opera;
	private JanelaIntervalo firefox;
	
	@Before
	public void setup(){
		
		intervalo = new Intervalo(100, 150);
		
		window = new JanelaIntervalo("Window",intervalo);
		ie = new JanelaIntervalo("IE There's a lot of bug!!!", intervalo);
		chrome = new JanelaIntervalo("Chrome!",intervalo);
		safari = new JanelaIntervalo("Safari", intervalo);
		tor = new JanelaIntervalo("Tor", intervalo);
		opera = new JanelaIntervalo("Opera", intervalo);
		firefox = new JanelaIntervalo("Firefox",intervalo);
		
		intervalo.registrarObservador(window);
		intervalo.registrarObservador(ie);
		intervalo.registrarObservador(chrome);
		intervalo.registrarObservador(safari);
		intervalo.registrarObservador(tor);
		intervalo.registrarObservador(opera);
		intervalo.registrarObservador(firefox);
	}
	
	@Test
	public void teste(){
		intervalo.alterarInicio(110);
		intervalo.alterarInicio(80);
		intervalo.alterarInicio(130);
	}
	
	@Test
	public void alterarInicioPelaJanela(){
		window.alterarInicio("115");
	}

}
