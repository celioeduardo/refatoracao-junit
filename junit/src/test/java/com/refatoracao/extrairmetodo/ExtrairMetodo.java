package com.refatoracao.extrairmetodo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ExtrairMetodo {
	
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	private String _nome;
	
	@Before
	public void setup(){
		_nome = "Martin Fowler";
		pedidos.add(new Pedido(15.00));
		pedidos.add(new Pedido(22.00));
	}
	
	@Test
	public void imprimirDívida() {
		imprimirCabecalho();
		imprimirDetalhes();
	}

	private double lerDivida() {
		// calcula dividas
		double divida = 0;
		for (Pedido cada : pedidos) {
			divida += cada.lerQuantia();
		}
		return divida;
	}

	private void imprimirDetalhes() {
		// imprimir detalhes
		System.out.println("nome:" + _nome);
		System.out.println("quantia: " + lerDivida());
	}

	private void imprimirCabecalho() {
		// imprimir cabeçalho
		System.out.println("**************************");
		System.out.println("***** O Cliente Deve *****");
		System.out.println("**************************");
	}
}
