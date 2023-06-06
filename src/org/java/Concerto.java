package org.java;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	
	DateTimeFormatter dtfc = DateTimeFormatter.ofPattern("HH.mm");
	
	private LocalTime ora;
	private BigDecimal prezzo;

	public Concerto(String titolo, String data, int postiTotali, String ora, BigDecimal prezzo) throws Exception {
		
		super(titolo, data, postiTotali);
		
		LocalTime oraFormatted = LocalTime.parse(ora, dtfc);
		
		setOra(oraFormatted);
		setPrezzo(prezzo);		
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	
	public String getPriceFormatted() {
		
		String priceF = String.format("%.2f $", getPrezzo()); 
		return priceF;
	}
	
	
	@Override
	public String toString() {
		
		return "| Date e ora evento: " + getData() + " " + getOra() + " - Titolo: " + getTitolo() + " Prezzo: " + getPriceFormatted();
	}
}
