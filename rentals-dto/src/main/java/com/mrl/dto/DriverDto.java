package com.mrl.dto;


import java.time.LocalDateTime;

public class DriverDto extends Identifiable{
	
	public String firstName, lastName;
	public LocalDateTime creationDate, dateOfBirth;

	
	
	@Override
	public String toString() {
		return "Driver [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", driverId=" + id + ", creationDate=" + creationDate + "]";
	}


}
