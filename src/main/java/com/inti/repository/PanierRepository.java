package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.entities.Panier;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long>{

	@Query("from Panier WHERE id_annonce=:x")
	public List<Panier> findbyAnnonce(@Param("x")long id_annonce);
	
	@Query("from Panier WHERE user=:x")
	public List<Panier> findbyUser(@Param("x")long user_id);
	
	@Query("from Panier WHERE panier_id=:x")
	public Panier findbyId(@Param("x")long panier_id);
	
	
}
