package com.mrl.vehicle;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mrl.driver.ICarRepository;
import com.mrl.dto.CarDto;



class CarRepositoryTest {
	private final static String FILE_LOCAION = "src/test/resources/json/cars.json";
	private final static CarDto CAR_1 = new CarDto();
	private final static CarDto CAR_2 = new CarDto();
	private final static CarDto CAR_3 = new CarDto();
	
	private static ICarRepository repo = null; 
	
	@BeforeEach
	public void before() {
		
		CAR_1.make = "Ford";
		CAR_1.model = "Ka";
		CAR_1.registrationPlate = "GH01 KLM";
		
		CAR_1.make = "Ford";
		CAR_1.model = "Ka";
		CAR_1.registrationPlate = "FG01 PDD";
	
		CAR_1.make = "Ford";
		CAR_1.model = "Ka";
		CAR_1.registrationPlate = "JK01 DDM";
	}
	
	@BeforeAll
	public static void beforeAll() {
		File file = new File(FILE_LOCAION);
		file.delete();
		repo = new CarRepository(FILE_LOCAION);
	}
	
	@Test
	void saveAndgetcars() {
		repo.saveCar(CAR_1);
		repo.saveCar(CAR_2);
		repo.saveCar(CAR_3);
		
		List<CarDto> cars = repo.getCars();
		
		assertTrue(cars.size() == 3 );
	}

}
