package org.java;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		
		BigDecimal x = new BigDecimal(100);
		
//		Scanner sc = new Scanner(System.in);
		
		try {
			
			ProgrammEventi pe = new ProgrammEventi("Eventi serie");
			pe.addEvento(new Evento("mio evento1", "01-01-2024", 100));
			pe.addEvento(new Evento("mio evento2", "01-01-2024", 200));
			pe.addEvento(new Evento("mio evento3", "01-01-2024", 500));
			pe.addEvento(new Evento("mio evento4", "02-01-2024", 1000));
			
			System.out.println(pe);
			
			List<Evento> eventiPrimoGennaio = pe.getEventiByData("01-01-2024");
			System.out.println(eventiPrimoGennaio);
			
			int eventiCount = pe.getNumeroEventi();
			System.out.println("numero eventi: " + eventiCount);
			
			pe.clearEventi();
			System.out.println("--clear--");
			
			eventiCount = pe.getNumeroEventi();
			System.out.println("numero eventi: " + eventiCount);
			
//			System.out.println("Inserisci il nome dell'evento");
//			String nome = sc.nextLine();
//			
//			System.out.println("Inserisci la data dell'evento");
//			String data = sc.nextLine();
//			
//			System.out.println("Inserisci il numeri di posti dell'evento");
//			int postiTotali = Integer.parseInt(sc.nextLine());
//			
//			Evento event = new Evento(nome, data, postiTotali);
//			
//			System.out.println("\n" + event);
//			
//			int risp = -1;
//			
//			while (risp != 0) {
//				
//				System.out.println("\n-------------------------------------------------------------\n");
//				
//				System.out.println("Premi 0 per USCIRE, 1 per PRENOTARE, 2 per DISDIRE");
//				risp = Integer.parseInt(sc.nextLine());
//				
//				System.out.println("\n-------------------------------------------------------------\n");
//				
//				if (risp == 1) {
//					
//					System.out.println("Quanti posti vuoi prenotare?");
//					int postiDaPrenotare = Integer.parseInt(sc.nextLine());
//					
//					try {
//												
//						event.prenota(postiDaPrenotare);
//						
//						System.out.println("| Posti prenotati: " + postiDaPrenotare + " | Posti ancora liberi: " + (event.getPostiTotali() - event.getPostiPrenotati()) + "/" + event.getPostiTotali());
//					} catch (Exception e) {
//						
//						System.out.println("Errore: " + e.getMessage());
//					}
//				}
//				else if (risp == 2) {
//					
//					System.out.println("Quanti posti vuoi disdire");
//					int postiDaDisdire = Integer.parseInt(sc.nextLine());
//					
//					try {
//													
//						event.disdici(postiDaDisdire);						
//						
//						System.out.println("| Posti disdetti: " + postiDaDisdire + " | Posti ancora prenotati da te: " + event.getPostiPrenotati() + "| Posti liberi: " + (event.getPostiTotali() - event.getPostiPrenotati()) + "/" + event.getPostiTotali());
//					} catch (Exception e) {
//						
//						System.out.println("Errore: " + e.getMessage());
//					}
//				}
//				
//			}
		} catch (Exception e) {
			
			System.err.println("Errore: " + e.getMessage());
		}
		finally {
			
//			sc.close();
		}		
	}
}
