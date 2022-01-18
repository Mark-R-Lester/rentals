package com.mrl.vehicle;

import java.util.List;


import com.mrl.common.Repository;
import com.mrl.driver.ICarRepository;
import com.mrl.dto.CarDto;

public class CarRepository extends Repository implements ICarRepository  {
	
private String path = "./car.json";
	
	public CarRepository() {
		super();
		createFile(path);
	}
	
	public CarRepository(String path) {
		super();
		this.path = path;
		createFile(path);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CarDto> getCars() {
		return getList(path, CarDto.class);
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean saveCar(CarDto car) {
		return save(path, CarDto.class, car);
	}

}
