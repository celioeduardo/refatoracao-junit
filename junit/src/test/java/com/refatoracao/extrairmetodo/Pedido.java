package com.refatoracao.extrairmetodo;

public class Pedido {
	private double quantia;

	public Pedido(double quantia) {
		super();
		this.quantia = quantia;
	}
	
	public double lerQuantia(){
		return quantia;
	}
}
