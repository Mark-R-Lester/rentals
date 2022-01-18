package com.mrl.license;

import java.time.Duration;
import java.time.LocalDateTime;

import com.mrl.enumeration.VehicleType;


public class License {
	
	public License(LocalDateTime startDate, LocalDateTime endDate, VehicleType vehicleType) {
		
	}
	
	private String licenseNumber;
	private LocalDateTime startDate, endDate;
	private VehicleType vehicleType;

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	
	
	
	/**
	 * Calculates the remaining duration of a rental.
	 * 
	 * @return duration
	 */
	public Duration remainingTime() {
		return Duration.between(startDate, endDate);
	};
	
	/**
	 * Is this vehicle available for hire
	 * 
	 * @return boolean
	 */
	public boolean isInDate() {
		return remainingTime().getSeconds() == 0;
	}
	
	/**
	 * Defines the start and end dates of the for the license
	 * 
	 * @param startDate
	 * @param endDate
	 */
	public void updateLicense(LocalDateTime startDate, LocalDateTime endDate, VehicleType vehicleType) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

}
