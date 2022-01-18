package com.mrl.booking;

import java.util.List;


import com.mrl.common.Repository;
import com.mrl.driver.IBookingRepository;
import com.mrl.dto.BookingDto;

public class BookingRepository extends Repository implements IBookingRepository  {
	
	private String path = "./bookings.json";
	
	public BookingRepository() {
		super();
		createFile(path);
	}
	
	public BookingRepository(String path) {
		super();
		this.path = path;
		createFile(path);
	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BookingDto> getBookings() {
		return getList(path, BookingDto.class);
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean saveBooking(BookingDto booking) {
		return save(path, BookingDto.class, booking);
	}
	
	
	

}
