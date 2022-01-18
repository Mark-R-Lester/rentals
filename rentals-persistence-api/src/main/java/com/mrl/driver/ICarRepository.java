package com.mrl.driver;

import java.util.List;

import com.mrl.dto.CarDto;

public interface ICarRepository {
	
	/**
	* Gets all cars from the repository
    * @return List<CarDto>
	*/
	public List<CarDto> getCars();
	

	/**
	* Save a given car in json format in the repository
    * @return boolean true if save is successful else false
	*/
	public boolean saveCar(CarDto car);

}
