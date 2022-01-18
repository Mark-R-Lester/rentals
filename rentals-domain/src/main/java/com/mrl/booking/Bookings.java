package com.mrl.booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bookings {
	
	
	public List<Booking> getBookings(String registrationPlate){
		return new ArrayList<Booking>();
	}
	
	
	public Map<LocalDateTime, LocalDateTime> getFreePeriods(String registrationPlate) {
		
		List<Booking> bookings = getBookings(registrationPlate);
		Collections.sort(bookings);
		
		Map<LocalDateTime, LocalDateTime> freePeriods = new HashMap<LocalDateTime, LocalDateTime>();
		LocalDateTime startDate = LocalDateTime.now(), endDate;
		
		for(Booking booking : bookings) {
			if(startDate.isBefore(booking.getStartDate())) {
				endDate = booking.getStartDate().minusDays(1);
				freePeriods.put(startDate, endDate);
				startDate = booking.getEndDate().plusDays(1);
			} else {
				startDate = booking.getEndDate().plusDays(1);
			}
		}
		
		return freePeriods;
	}
	

}
