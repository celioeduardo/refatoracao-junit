package com.refatoracao.valor;

import java.util.Currency;


public class Dinheiro {
	private long quantia;
	private Currency moeda;

	public long quantia() {
		return Math.round(quantia / fatorCentavos());
	}
	public Dinheiro vezes(int i) {
		return novoDinheiro(this.quantia*i);
	}
	public Dinheiro(double quantia, Currency moeda){
		this.moeda = moeda;		
		this.quantia = Math.round(quantia * fatorCentavos());
	}
	public Dinheiro(long quantia, Currency moeda){
		this.moeda = moeda;		
		this.quantia = quantia * fatorCentavos();	
	}
	public Dinheiro(double quantia){
		this.moeda = Currency.getInstance("BRL");		
		this.quantia = Math.round(quantia * fatorCentavos());
	}
	public Dinheiro() {
	}
	public Currency moeda(){
		return moeda;
	}
	public long valor(){
		return this.quantia;
	}

	public Dinheiro adicionar(Dinheiro novaQuantia){
		assercaoMesmaMoedaQue(novaQuantia);
		return novoDinheiro(this.quantia + novaQuantia.quantia);
	}
	public Dinheiro subtrair(Dinheiro novaQuantia){
		assercaoMesmaMoedaQue(novaQuantia);
		return novoDinheiro(this.quantia - novaQuantia.quantia);
	}
	public int compararCom(Object outro){
		return compararCom((Dinheiro) outro);
	}
	public int compararCom(Dinheiro outro){
		assercaoMesmaMoedaQue(outro);
		if (quantia < outro.quantia) return -1;
		else if (quantia == outro.quantia) return 0;
		else return 1;
	}
	
	private Dinheiro novoDinheiro(long quantia) {
		Dinheiro dinheiro = new Dinheiro();
		dinheiro.moeda = this.moeda;
		dinheiro.quantia = quantia;
		return dinheiro;
	}
	private void assercaoMesmaMoedaQue(Dinheiro outro) {
		if (this.moeda().equals(outro))
			throw new IllegalArgumentException(this.moeda + " diferente " + outro.moeda);		
	}
	public static Dinheiro emDolares(double quantia){
		return new Dinheiro(quantia, Currency.getInstance("USD"));
	}	
	public static Dinheiro emReais(double quantia){
		return new Dinheiro(quantia, Currency.getInstance("BRL"));
	}		
	
	public boolean equals (Object outro){
		return (outro instanceof Dinheiro ) && 
				equals((Dinheiro)outro);
	}
	public boolean equals (Dinheiro outro){
		return moeda.equals(outro.moeda) && 
				(quantia == outro.quantia);
	}
	public int hashCode(){
		return (int) (quantia ^ (quantia >>> 32));
	}
	
	private static final int[] centavos = new int[]{1, 10, 100, 1000};
	private int fatorCentavos(){
		return centavos[moeda.getDefaultFractionDigits()];
	}
}    