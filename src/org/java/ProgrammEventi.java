package org.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi {
	
	private String titolo;
	private List<Evento> eventi;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public ProgrammEventi(String titolo) {
		
		setTitolo(titolo);
		this.eventi = new ArrayList<Evento>();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
	
	
	public void addEvento(Evento event) {
		
		this.eventi.add(event);
	}
	
	public void clearEventi() {
		
		this.eventi.clear();
	}
	
	public int getNumeroEventi() {
		
		return getEventi().size();
	}
	
	public List<Evento> getEventiByData(String data) {

		LocalDate date = LocalDate.parse(data, dtf);
		
		List<Evento> eventiPerData = new ArrayList<>();
		
		for (Evento e : getEventi()) {
			
			if (e.getData().equals(date)) {
				
				eventiPerData.add(e);
			}
		}
		
		return eventiPerData;		
	}
	
	@Override
	public String toString() {
		
		String res = getTitolo() + "\n";
		
		getEventi().sort(new Comparator<Evento>() {

			@Override
			public int compare(Evento o1, Evento o2) {
				
				return (int) (o1.getData().toEpochDay() - o2.getData().toEpochDay());
			}
			
		});
		
		for (Evento e : getEventi()) {
			
			res += e.toString() + "\n";
		}
		
		return res;
	}
}
