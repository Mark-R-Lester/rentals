package com.mrl.vehicle;

import java.util.List;


import com.mrl.common.Repository;
import com.mrl.driver.ITruckRepository;
import com.mrl.dto.TruckDto;

public class TruckRepository extends Repository implements ITruckRepository  {
	
private String path = "./truck.json";
	
	public TruckRepository() {
		super();
		createFile(path);
	}
	
	public TruckRepository(String path) {
		super();
		this.path = path;
		createFile(path);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TruckDto> getTrucks() {
		return getList(path, TruckDto.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean saveTruck(TruckDto truck) {
		return save(path, TruckDto.class, truck);
	}
	

}
