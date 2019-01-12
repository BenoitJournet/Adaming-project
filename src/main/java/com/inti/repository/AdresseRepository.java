package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.entities.Adresse;
import com.inti.entities.Region;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long>{

	@Query("from Adresse WHERE adresse_id=:s")
	public Adresse getOnebyId(@Param("s") long adresse_id);
	
	@Query("from Adresse WHERE region=:x")
	public Adresse findbyregion(@Param("x")String region);
	
	@Query("from Adresse WHERE user_id=:x")
	public List<Adresse> findbyuser(@Param("x")long user_id);

	@Query("from Adresse WHERE region_id=:x AND ville=:y AND numero=:z AND rue=:a AND pays=:b")
	public Adresse findladresse(@Param("x")Region region_id,@Param("y")String ville,@Param("z")String numero, @Param("a")String rue, @Param("b")String pays );
}
