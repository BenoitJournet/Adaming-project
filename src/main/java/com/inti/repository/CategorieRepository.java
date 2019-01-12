package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

	@Query("from Categorie WHERE categorie_name=:x")
	public Categorie findbyname(@Param("x")String categorie_name);
	
	@Query("from Categorie WHERE categorie_name LIKE CONCAT('%',:s,'%')")
	public List<Categorie> findbyString(@Param("s") String categorie_name);

	@Query("from Categorie WHERE categorie_id=:s")
	public Categorie getOnebyId(@Param("s") long categorie_id);

}
