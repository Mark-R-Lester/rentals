package com.mrl.booking;

import java.time.LocalDateTime;
import java.util.UUID;

import com.mrl.dto.BookingDto;



public class Booking implements Comparable<Booking>{
	
	
	private BookingDto booking;
	
	
	
	public String getRegistrationPlate() {
		return booking.registrationPlate;
	}

	public void setRegistrationPlate(String registrationPlate) {
		booking.registrationPlate = registrationPlate;
	}

	public LocalDateTime getStartDate() {
		return booking.startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		booking.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return booking.endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		 booking.endDate = endDate;
	}

	public UUID getDriverId() {
		return  booking.driverId;
	}

	public void setDriverId(UUID driverId) {
		 booking.driverId = driverId;
	}

	

	public boolean isActive() {
		LocalDateTime now = LocalDateTime.now();
		return !now.isBefore(booking.startDate) && !now.isAfter(booking.endDate);
	}

	
	public int compareTo(Booking other) {
		if(getStartDate().equals(other.getStartDate()))
			return 0;
		if (getStartDate().isBefore(other.getStartDate()))
			return -1;
					
		return 1;
	}
	
	
}
