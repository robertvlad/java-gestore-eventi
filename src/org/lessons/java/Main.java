package org.lessons.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
        System.out.println("Hi, I'm here to help you with your booking"); 
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
            
            System.out.println("Enter the date of your event in dd/mm/yyyy format :");
            date = scan.nextLine();
            System.out.println("-------------------------------------------");

            Evento firstEvent = new Evento(title, date, seats);
            
            listEvents.add(firstEvent);
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
