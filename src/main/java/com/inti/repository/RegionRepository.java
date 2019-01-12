package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>{
	
}
