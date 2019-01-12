package com.inti.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Region;
import com.inti.repository.RegionRepository;
import com.inti.services.RegionService;
@Service
public class RegionServiceImpl implements RegionService{

	@Autowired
	RegionRepository regionRepo;
	
	@Override
	public List<Region> getAll() {
		return regionRepo.findAll();
	}

	@Override
	public Region getOneById(long region_id) {
		return regionRepo.getOne(region_id);
	}

	@Override
	public Iterable<Region> saveAllregion(Iterable<Region> regions) {
		return regionRepo.saveAll(regions);
	}

}
