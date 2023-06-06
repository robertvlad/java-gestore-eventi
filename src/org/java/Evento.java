package org.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private String titolo;
	private LocalDate data;
	private int postiTotali,
				postiPrenotati = 0;
	
	public Evento(String titolo, String data, int postiTotali) throws Exception {
		
		checkPostiTotali(postiTotali);
		
		LocalDate dataFormatter = LocalDate.parse(data, dtf);
		
		setTitolo(titolo);
		setData(dataFormatter);
		this.postiTotali = postiTotali;
		
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate dataFormatter) throws Exception {
		
		if (LocalDate.now().isAfter(dataFormatter)) throw new Exception("La data selezionata non è più disponibile");
		this.data = dataFormatter;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	
	private void checkPostiTotali(int postiTotali) throws Exception {
		
		if (postiTotali < 1) throw new Exception("Il numero dei posti non può essere inferiore o uguale a 0");
	}
	
	public void prenota(int postiDaPrenotare) throws Exception {
		
		if (LocalDate.now().isAfter(data)) {
			
			throw new Exception("L'evento non è più disponibile");
		}
		else if (getPostiTotali() <= (getPostiPrenotati() + postiDaPrenotare)) {
			throw new Exception("Non ci sono più posti disponibili. Posti prenotati: " + getPostiPrenotati() + "/" + getPostiTotali());
		}
		else {
			this.postiPrenotati += postiDaPrenotare;
		}
	}
	
	public void disdici(int postiDaDisdire) throws Exception {
		
		if (LocalDate.now().isAfter(data)) {
			
			throw new Exception("L'evento non è più disponibile");
		}
		else if (getPostiPrenotati() < postiDaDisdire) {
			throw new Exception("Il numero dei posti da disdire è superiore alle reali prenotazioni");
		}
		else {
			this.postiPrenotati -= postiDaDisdire;
		}
	}
	
	
	@Override
	public String toString() {
		
		return "| Data Evento: " + getData().format(dtf) + " | Titolo: " + getTitolo() + " | Numeri totali: " + getPostiTotali();
	}
}
