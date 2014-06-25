package com.refatoracao.valor;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Currency;
import java.util.Locale;


public class Dinheiro {
	private double quantia;
	private Currency moeda;
	private Locale local;
	
	public String toString(){
		DecimalFormatSymbols simbolo = new DecimalFormatSymbols(local);    
		DecimalFormat formato = new DecimalFormat("¤ ###,###,##0.00",simbolo); 
		return formato.format(valor());    
	}
	public double valor() {
		return quantia / fatorCentavos();
	}
	public Dinheiro vezes(int i) {
		return novoDinheiro(this.quantia*i);
	}
	public Dinheiro(double quantia, Currency moeda){
		setMoeda(moeda);		
		this.quantia = Math.round(quantia * fatorCentavos());
	}
	public Dinheiro() {
	}
	private void setMoeda(Currency moeda) {
		
		this.moeda = moeda;

		if (moeda.getCurrencyCode()=="USD")
			this.local = Locale.US;			
		else 
			this.local = new Locale("pt","BR");
		
	}
	public Currency moeda(){
		return moeda;
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
	
	private Dinheiro novoDinheiro(double quantia) {
		Dinheiro dinheiro = new Dinheiro();
		dinheiro.moeda = this.moeda;
		dinheiro.local = this.local;
		dinheiro.quantia = quantia;
		return dinheiro;
	}
	private void assercaoMesmaMoedaQue(Dinheiro outro) {
		if (!this.moeda().equals(outro.moeda()))
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
		return (int) (quantia * (quantia * 32));
	}
	
	private static final int[] centavos = new int[]{1, 10, 100, 1000};
	private int fatorCentavos(){
		return centavos[moeda.getDefaultFractionDigits()];
	}
}    