package com.mrl.driver;

import java.util.List;

import com.mrl.dto.LicenseDto;

public interface ILicenseRepository {
	
	/**
	* Gets all trucks from the repository
    * @return List<TruckDto>
	*/
	public List<LicenseDto> getLicenses();
	

	/**
	* Save a given truck in json format in the repository
    * @return boolean true if save is successful else false
	*/
	public boolean saveLicense(LicenseDto license);

}
