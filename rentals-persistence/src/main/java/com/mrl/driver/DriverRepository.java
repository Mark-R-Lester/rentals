package com.mrl.driver;

import java.util.List;
import com.mrl.common.Repository;
import com.mrl.dto.DriverDto;

public class DriverRepository extends Repository implements IDriverRepository  {
	
	private String path = "./drivers.json";
	
	public DriverRepository() {
		super();
		createFile(path);
	}
	
	public DriverRepository(String path) {
		super();
		this.path = path;
		createFile(path);
	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	public List<DriverDto> getDrivers() {
		return getList(path, DriverDto.class);
	}
	

	/**
	 * {@inheritDoc}
	 */
	public boolean saveDriver(DriverDto driver) {
		return save(path, DriverDto.class, driver);
	}
	
	
	

}
