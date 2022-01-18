package com.mrl.vehicle;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mrl.driver.ITruckRepository;
import com.mrl.dto.TruckDto;



class TruckRepositoryTest {
	private final static String FILE_LOCAION = "src/test/resources/json/trucks.json";
	private final static TruckDto TRUCK_1 = new TruckDto();
	private final static TruckDto TRUCK_2 = new TruckDto();
	private final static TruckDto TRUCK_3 = new TruckDto();
	
	private static ITruckRepository repo = null; 
	
	@BeforeEach
	public void before() {
		
		TRUCK_1.make = "Ford";
		TRUCK_1.model = "Ka";
		TRUCK_1.registrationPlate = "GH01 KLM";
		
		TRUCK_1.make = "Ford";
		TRUCK_1.model = "Ka";
		TRUCK_1.registrationPlate = "FG01 PDD";
	
		TRUCK_1.make = "Ford";
		TRUCK_1.model = "Ka";
		TRUCK_1.registrationPlate = "JK01 DDM";
	}
	
	@BeforeAll
	public static void beforeAll() {
		File file = new File(FILE_LOCAION);
		file.delete();
		repo = new TruckRepository(FILE_LOCAION);
	}
	
	@Test
	void saveAndGetTrucks() {
		repo.saveTruck(TRUCK_1);
		repo.saveTruck(TRUCK_2);
		repo.saveTruck(TRUCK_3);
		
		List<TruckDto> trucks = repo.getTrucks();
		assertTrue(trucks.size() == 3 );
	}

}
