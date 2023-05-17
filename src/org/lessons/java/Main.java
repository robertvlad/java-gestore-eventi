package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		///////// BONUS
		
		ProgrammEventi eventsList = new ProgrammEventi("Concerti");

		Evento event = new Evento("TEST 1", "10/01/2024", 100);
		eventsList.addEvent(event);
		Evento event1 = new Evento("TEST 2", "10/01/2024", 200);
		eventsList.addEvent(event1);
		Evento event2 = new Evento("TEST 3", "10/01/2024", 300);
		eventsList.addEvent(event2);
		Evento event3 = new Evento("TEST 4", "12/01/2024", 400);
		eventsList.addEvent(event3);

		System.out.println("There are " + eventsList.getEventsNumber() + " total events.");

		String dateFilter = "10/01/2024";
		
		List<Evento> filteredEvents = eventsList.getEventsByDate(dateFilter);

		System.out.println("\nOn the date " + dateFilter + " there are the following events:");

		for (Evento filteredEvent : filteredEvents) {
			
			System.out.println(filteredEvent.toString());
		}
		
		System.out.println("-------------------------------------------");
		System.out.println("The whole list is:");
		System.out.println(eventsList.eventsList());
		System.out.println("-------------------------------------------");
		
		
		///////// END BONUS
		
		Scanner scan = new Scanner(System.in);
		
        System.out.println("Hi, I'm here to help you with your booking for your favorite Concert"); 
        System.out.println("-------------------------------------------");
        
        ArrayList<Evento> listEvents = new ArrayList<>();

        String title,date;
        int seats;
 

        System.out.println("Enter the title of the event: ");
        title = scan.nextLine();
        System.out.println("The name of the event is: " + title);
        System.out.println("-------------------------------------------");        
        

        try {
        	
            System.out.println("Enter the number of seats for you event: ");
            seats = Integer.parseInt(scan.nextLine());
            System.out.println("-------------------------------------------");
            
            System.out.println("Enter the date of your event in dd/mm/yyyy format :");
            date = scan.nextLine();
            System.out.println("-------------------------------------------");
            
            System.out.println("Enter the hour of your event in HH:mm format :");
            LocalTime hour = LocalTime.parse(scan.next());
            System.out.println("-------------------------------------------");
            
            System.out.println("Enter the price of your event ticket in $$ format without decimal :");
            BigDecimal price = scan.nextBigDecimal();

            // Evento firstEvent = new Evento(title, date, seats);
            Concerto firstEvent = new Concerto(title, date, seats, hour, price);
            
            listEvents.add(firstEvent);
            System.out.println(firstEvent);
            
            System.out.println("We have added your event to our list.");
            System.out.println("Thank you for creating an event.");
            System.out.println("-------------------------------------------");
            
            String options, options2;
            
            do {
            	
            	System.out.println("The max number of seats is: " + seats);
                System.out.println("Do you want to reserve seats for the event? Press '1' to confirm or '2' to exit");
                options = scan.nextLine();
                
            }
            while (!options.equals("1") && !options.equals("2"));
            
            switch (options) {
            
                case "1":
                    int seatsToBook = 0;
                    
                    do {
                    	
                        System.out.println("How many places do you want to book?");
                        
                        try {
                        	
                        	seatsToBook = Integer.parseInt(scan.nextLine());
                        	
                            for (int i = 0; i < seatsToBook; i++)
                            	
                            	listEvents.get(0).book();
                            
                            System.out.println("Thank you for booking seats.");
                            System.out.println("You have booked: " + seatsToBook + " from " + seats + " total avaible.");
                            System.out.println("-------------------------------------------");
                            System.out.println(firstEvent);
                            
                            do {
                            	
                            	System.out.println("Do you want to confirm seats for the event? Press '1' to delete or '2' to confirm");
                                options2 = scan.nextLine();
                                
                            }
                            while (!options2.equals("1") && !options2.equals("2"));
                            
                            switch (options2) {
                            
	                            case "1":
	                                int seatsToDelete = seatsToBook;
	                                
	                                for (int i = 0; i < seatsToDelete; i++)
                                    	
                                    	listEvents.get(0).cancel();
                                    
                                    System.out.println("Your seats have been deleted");
                                    
                                    
                                    
                               case "2":
	                                System.out.println("Thank you, bye.");
                            }       
                            
                        } 
                        catch (NumberFormatException e) {
                        	
                            System.out.println("Only numbers can be entered");
                        } 
                        catch (Exception e) {
                        	
                            System.out.println(e.getMessage());
                        }
                        
                    } 
                    while (seatsToBook == 0);
                    break;

                case "2":
                    System.out.println("Thank you, bye.");
            }
        }
        
        catch (IllegalArgumentException e) {
        	
            System.out.println(e.getMessage());
        }
    }
}
