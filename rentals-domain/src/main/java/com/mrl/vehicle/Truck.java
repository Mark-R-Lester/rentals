package com.mrl.vehicle;

import java.time.LocalDateTime;

import com.mrl.driver.Driver;
import com.mrl.enumeration.VehicleType;

public class Truck extends Vehicle {

	@Override
	public boolean rentalCheck(Driver driver, LocalDateTime endDate) {
		
		return driver.hasInDateLicense(VehicleType.TRUCK, endDate);
	}

	@Override
	public boolean makeBooking(Driver driver, LocalDateTime endDate) {
		// TODO Auto-generated method stub
		return false;
	}

}
