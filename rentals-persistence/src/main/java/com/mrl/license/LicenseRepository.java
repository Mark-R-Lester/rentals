package com.mrl.license;

import java.util.List;

import com.mrl.common.Repository;
import com.mrl.driver.ILicenseRepository;
import com.mrl.dto.LicenseDto;

public class LicenseRepository extends Repository implements ILicenseRepository  {
	
private String path = "./licenses.json";
	
	public LicenseRepository() {
		super();
		createFile(path);
	}
	
	public LicenseRepository(String path) {
		super();
		this.path = path;
		createFile(path);
	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LicenseDto> getLicenses() {
		return getList(path, LicenseDto.class);
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean saveLicense(LicenseDto license) {
		return save(path, LicenseDto.class, license);
	}


	
	

}
