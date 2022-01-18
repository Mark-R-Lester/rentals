package com.mrl.booking;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mrl.driver.IBookingRepository;
import com.mrl.dto.BookingDto;



class BookingRepositoryTest {
	private final static String FILE_LOCAION = "src/test/resources/json/bookings.json";
	private final static BookingDto BOOKING_1 = new BookingDto();
	private final static BookingDto BOOKING_2 = new BookingDto();
	private final static BookingDto BOOKING_3 = new BookingDto();
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm");
	
	private static IBookingRepository repo = null; 
	
	@BeforeEach
	public void before() {
		BOOKING_1.registrationPlate = "Mark1";
		BOOKING_1.endDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		BOOKING_1.startDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		BOOKING_1.driverId = UUID.randomUUID();
		BOOKING_1.vehicleId = UUID.randomUUID();
		BOOKING_1.id = UUID.randomUUID();
		
		BOOKING_2.registrationPlate = "Mark2";
		BOOKING_2.endDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		BOOKING_2.startDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		BOOKING_2.driverId = UUID.randomUUID();
		BOOKING_2.vehicleId = UUID.randomUUID();
		BOOKING_2.id = UUID.randomUUID();
		
		BOOKING_3.registrationPlate = "Mark3";
		BOOKING_3.endDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		BOOKING_3.startDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		BOOKING_3.driverId = UUID.randomUUID();
		BOOKING_3.vehicleId = UUID.randomUUID();
		BOOKING_3.id = UUID.randomUUID();
		
		
	}
	
	@BeforeAll
	public static void beforeAll() {
		File file = new File(FILE_LOCAION);
		file.delete();
		repo = new BookingRepository(FILE_LOCAION);
	}
	
	@Test
	void saveAndgetBookings() {
		repo.saveBooking(BOOKING_1);
		repo.saveBooking(BOOKING_2);
		repo.saveBooking(BOOKING_3);
		
		List<BookingDto> bookings = repo.getBookings();
		
		assertTrue(bookings.size() == 3 );
	}

}
