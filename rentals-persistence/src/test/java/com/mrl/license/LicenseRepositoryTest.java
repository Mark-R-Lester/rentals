package com.mrl.license;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mrl.dto.LicenseDto;
import com.mrl.enumeration.VehicleType;



class LicenseRepositoryTest {
	private final static String FILE_LOCAION = "src/test/resources/json/licenses.json";
	private final static LicenseDto LICENSE_1 = new LicenseDto();
	private final static LicenseDto LICENSE_2 = new LicenseDto();
	private final static LicenseDto LICENSE_3 = new LicenseDto();
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm");
	
	private static LicenseRepository repo = null; 
	
	
	@BeforeEach
	public void before() {
		
		LICENSE_1.vehicleType = VehicleType.CAR;
		LICENSE_1.licenseNumber = "number1";
		LICENSE_1.endDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		LICENSE_1.startDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		
		LICENSE_2.vehicleType = VehicleType.CAR;
		LICENSE_2.licenseNumber = "number2";
		LICENSE_2.endDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		LICENSE_2.startDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		
		LICENSE_3.vehicleType = VehicleType.CAR;
		LICENSE_3.licenseNumber = "number3";
		LICENSE_3.endDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		LICENSE_3.startDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		
	}
	
	@BeforeAll
	public static void beforeAll() {
		File file = new File(FILE_LOCAION);
		file.delete();
		repo = new LicenseRepository(FILE_LOCAION);
	}
	
	@Test
	void saveAndgetLicenses() {
		repo.saveLicense(LICENSE_1);
		repo.saveLicense(LICENSE_2);
		repo.saveLicense(LICENSE_3);
		
		List<LicenseDto> licenses = repo.getLicenses();
		assertTrue(licenses.size() == 3 );
	}

}
