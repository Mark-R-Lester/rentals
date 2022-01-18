package com.mrl.dto;

import java.time.LocalDateTime;

import com.mrl.enumeration.VehicleType;



public class LicenseDto extends Identifiable{
	
	public String licenseNumber;
	public LocalDateTime startDate, endDate;
	public VehicleType vehicleType;


	
	
	
}
