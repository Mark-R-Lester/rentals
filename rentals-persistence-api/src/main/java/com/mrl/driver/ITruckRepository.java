package com.mrl.driver;

import java.util.List;

import com.mrl.dto.TruckDto;

public interface ITruckRepository {
	
	/**
	* Gets all drivers from the repository
    * @return List<TruckDto>
	*/
	public List<TruckDto> getTrucks();
	

	/**
	* Save a given driver in json format in the repository
    * @return boolean true if save is successful else false
	*/
	public boolean saveTruck(TruckDto truck);

}
