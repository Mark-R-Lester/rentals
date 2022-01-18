package com.mrl.driver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.mrl.dto.DriverDto;
import com.mrl.enumeration.VehicleType;
import com.mrl.license.License;

public class Driver {
	
	@Override
	public String toString() {
		return driver.toString();
	}
	
	private List<License> licenses;
	private DriverDto driver;
	
	
	public String getFirstName() {
		return driver.firstName;
	}
	public void setFirstName(String firstName) {
		driver.firstName = firstName;
	}
	
	public String getLastName() {
		return driver.lastName;
	}
	public void setLastName(String lastName) {
		driver.lastName = lastName;
	}
	
	public LocalDateTime getDateOfBirth() {
		return driver.dateOfBirth;
	}
	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		driver.dateOfBirth = dateOfBirth;
	}
	
	public UUID getId() {
		return driver.id;
	}
	public void setId(UUID id) {
		driver.id = id;
	}
	
	public LocalDateTime getCreationDate() {
		return driver.creationDate;
	}
	
	public void setCreationDate(LocalDateTime creationDate) {
		driver.creationDate = creationDate;
	}
	
	
	public void addCreationDateAndId() {
		setCreationDate(LocalDateTime.now());
		setId(UUID.randomUUID());
	}
	
	
	public boolean hasInDateLicense(VehicleType vehicleType, LocalDateTime endDate) {
		return licenses.stream()
				.filter(license -> license.getVehicleType() == vehicleType)
				.anyMatch(license -> license.getEndDate().isAfter(endDate));
	}
	

}
