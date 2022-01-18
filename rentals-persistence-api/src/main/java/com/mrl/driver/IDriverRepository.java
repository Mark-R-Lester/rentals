package com.mrl.driver;

import java.util.List;
import com.mrl.dto.DriverDto;

public interface IDriverRepository {
	
	/**
	* Gets all drivers from the repository
    * @return List<Driver>
	*/
	public List<DriverDto> getDrivers();
	

	/**
	* Save a given driver in json format in the repository
    * @return boolean true if save is successful else false
	*/
	public boolean saveDriver(DriverDto driver);
	

}
