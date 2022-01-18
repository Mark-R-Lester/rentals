package com.mrl.driver;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mrl.dto.DriverDto;



class DriverRepositoryTest {
	private final static String DIRECTORY_LOCAION = "src/test/resources/json";
	private final static String FILE_LOCAION = "src/test/resources/json/drivers.json";
	private final static DriverDto DRIVER_1 = new DriverDto();
	private final static DriverDto DRIVER_2 = new DriverDto();
	private final static DriverDto DRIVER_3 = new DriverDto();
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm");
	
	private static DriverRepository repo = null; 
	
	@BeforeEach
	public void before() {
		
		DRIVER_1.firstName = "Mark1";
		DRIVER_1.lastName = "Lester";
		DRIVER_1.dateOfBirth = LocalDateTime.parse("1969-03-04 12:30", formatter);
		DRIVER_1.creationDate = LocalDateTime.parse("1968-03-04 12:30", formatter);
		DRIVER_1.id = UUID.randomUUID();
		
	
		DRIVER_2.firstName = "Roger1";
		DRIVER_2.lastName = "Parker";
		DRIVER_2.dateOfBirth = LocalDateTime.parse("1969-03-04 12:30", formatter);
		DRIVER_2.creationDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		DRIVER_2.id = UUID.randomUUID();
	
		DRIVER_3.firstName = "Dave1";
		DRIVER_3.lastName = "Gibbs";
		DRIVER_3.dateOfBirth = LocalDateTime.parse("1969-03-04 12:30", formatter);
		DRIVER_3.creationDate = LocalDateTime.parse("1969-03-04 12:30", formatter);
		DRIVER_3.id = UUID.randomUUID();
	}
	
	@BeforeAll
	public static void beforeAll() {
		RemoveAllFiles(DIRECTORY_LOCAION);
		repo = new DriverRepository("src/test/resources/json/drivers.json");
		repo.setFileLocationsPath(DIRECTORY_LOCAION);
	}
	
	
	public static void RemoveAllFiles(String path) {
		File folder = new File(path);
	    File[] files = folder.listFiles();
	    
	    if(files!=null)
	        for(File file: files)
	           file.delete();
	}
	
	@Test
	void saveAndgetDrivers() {
		repo.saveDriver(DRIVER_1);
		repo.saveDriver(DRIVER_2);
		repo.saveDriver(DRIVER_3);
		
		List<DriverDto> drivers = repo.getDrivers();
		
		assertTrue(drivers.size() == 3 );
	}

}
