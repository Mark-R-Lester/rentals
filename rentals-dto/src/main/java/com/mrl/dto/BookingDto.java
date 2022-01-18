package com.mrl.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingDto extends Identifiable{
	
	
	public String registrationPlate;
	public UUID driverId, vehicleId;
	public LocalDateTime startDate, endDate;
	
	
}
