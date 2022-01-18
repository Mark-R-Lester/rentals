package com.mrl.driver;

import java.util.List;

import com.mrl.dto.BookingDto;

public interface IBookingRepository {
	
	/**
	* Gets all bookingss from the repository
    * @return List<BookingDto>
	*/
	public List<BookingDto> getBookings();
	

	/**
	* Save a given booking in json format in the repository
    * @return boolean true if save is successful else false
	*/
	public boolean saveBooking(BookingDto booking);

}
