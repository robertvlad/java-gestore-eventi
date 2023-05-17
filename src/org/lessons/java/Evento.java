package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String title;
    private LocalDate date;
    private int totalSeats, totalSeatsReserved;
    

    public Evento(String title, LocalDate date, int totalSeats) throws IllegalArgumentException {
    	
        validDate(date);
        validSeats(totalSeats);

        this.title = title;
        this.date = date;
        this.totalSeats = totalSeats;
        this.totalSeatsReserved = 0;
    }
    


    public String getTitle() {
    	
        return title;
    }

    public void setTitle(String title) {
    	
        this.title = title;
    }

    public LocalDate getDate() {
    	
        return date;
    }

    public void setDate(LocalDate date) throws IllegalArgumentException {
    	
        validDate(date);
        this.date = date;
    }

    public int getTotalSeats() {
    	
        return totalSeats;
    }

    public int getTotalSeatsReserved() {
    	
        return totalSeatsReserved;
    }


    private void validDate(LocalDate date) throws IllegalArgumentException {
    	
        if (date.isBefore(LocalDate.now())) {
        	
            throw new IllegalArgumentException("The date is in the past");
        }
    }
    
    private void validSeats(int seats) throws IllegalArgumentException {
    	
        if (seats<1) {
        	
            throw new IllegalArgumentException("There must be at least one place");
        }
    }


    public void book() throws Exception {
    	
        if (LocalDate.now().isAfter(date)) {
        	
            throw new Exception("Unable to book past events");
        } 
        else if (totalSeats==totalSeatsReserved) {
        	
            throw new Exception("The event is fully booked");
        } 
        else
        	totalSeatsReserved++;
    }
    
    public void cancel() throws Exception {
    	
        if (LocalDate.now().isAfter(date)) {
        	
            throw new Exception("Impossible to cancel past events");
        } 
        else if (totalSeatsReserved<1) {
        	
            throw new Exception("There are no reservations for this event");
        }else
        	totalSeatsReserved--;
    }

    @Override
    public String toString() {
    	
        return "Event date " + format.format(date) + " with the title " + title;
    }

}
