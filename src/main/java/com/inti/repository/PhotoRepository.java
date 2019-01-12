package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.entities.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long>{

	@Query("from Photo WHERE photo_id=:x")
	public Photo findbyId(@Param("x")long photo_id);
}
