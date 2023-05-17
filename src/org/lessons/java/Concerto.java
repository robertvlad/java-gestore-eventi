package org.lessons.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	
	private LocalTime hour;
    private BigDecimal price;

	public Concerto(String title, String date, int totalSeats, LocalTime hour, BigDecimal price) throws IllegalArgumentException{
		
		super(title, date, totalSeats);
		
		setHour(hour);
		setPrice(price);	
	}
	
	public LocalTime getHour() {
		
		return hour;
	}

	public void setHour(LocalTime hour) {
		
		this.hour = hour;
	}

	public BigDecimal getPrice() {
		
		return price;
	}

	public void setPrice(BigDecimal price) {
		
		this.price = price;
	}
	
	

    @Override
    public LocalDate getDate() {
    	
        return super.getDate();
    }

    @Override
    public String getTitle() {
    	
        return super.getTitle();
    }


    @Override
    public String toString() {
        return "The Concert " + getTitle() + " will be at " +  super.getDate() + " " + getHour() + ". The concert price is " + String.format("%,.2f", getPrice()) + "$";
    }

}
