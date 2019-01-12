package com.inti.services;

import java.util.List;

import com.inti.entities.Region;

public interface RegionService {

	public List<Region> getAll();
	public Region getOneById(long region_id);
	public Iterable<Region> saveAllregion(Iterable<Region> regions);
}
