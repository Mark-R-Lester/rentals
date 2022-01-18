package com.mrl.vehicle;


import java.time.LocalDateTime;
import com.mrl.driver.Driver;

public abstract class Vehicle {
	
	private String driver, make, model, registrationPlate;
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistrationPlate() {
		return registrationPlate;
	}

	public void setRegistrationPlate(String registrationPlate) {
		this.registrationPlate = registrationPlate;
	}

	/**
	 * The check must ensure the driver has the correct license for the vehicle
	 * 
	 * @param driver
	 * @return
	 */
	abstract public boolean rentalCheck(Driver driver, LocalDateTime endDate);
	
	abstract public boolean makeBooking(Driver driver, LocalDateTime endDate);
	
	
	
}
