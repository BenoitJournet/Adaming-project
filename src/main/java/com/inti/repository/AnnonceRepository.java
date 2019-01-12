package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Annonce;

@Transactional
@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long>{

	@Modifying
	@Query(value = "UPDATE annonce SET autorisation = :state WHERE annonce_id = :id ", nativeQuery = true)
	public void update(@Param("state")boolean autorisation, @Param("id")long annonce_id);
	
	@Query("from Annonce WHERE titre=:x")
	public Annonce findbytitre(@Param("x")String titre);
	
	@Query("from Annonce WHERE titre LIKE CONCAT('%',:s,'%')")
	public List<Annonce> findbyString(@Param("s") String titre);

	@Query("from Annonce WHERE annonce_id=:s")
	public Annonce getOnebyId(@Param("s") long annonce_id);
	
	@Query("from Annonce WHERE categorie_id=:s")
	public List<Annonce> getsomebyCategorie(@Param("s") long categorie_id);

	@Query("from Annonce WHERE :a =:s AND :b=:z")
	public List<Annonce> getsomebyfiltre( @Param("a") String filtre, @Param("s") long categorie_id, @Param("b") String filtre_2, @Param("z") String value_filtre);
	
//	@Query("from Annonce WHERE :a =:s AND :b=:z AND :c=:y")
//	public List<Annonce> getsomebyfiltre_2(@Param("s") long categorie_id, @Param("a") String filtre);
	
	@Query("from Annonce Where prix<=:s AND autorisation=true" )
	public List<Annonce> getsomebyPrixinf(@Param("s") long prix);
	
	@Query("from Annonce Where prix>=:s")
	public List<Annonce> getsomebyPrixsup(@Param("s") long prix);
	
	@Query("from Annonce WHERE region_annonce=:s")
	public List<Annonce> getOnebyadresse(@Param("s") String region_annonce);
	
	@Query("from Annonce WHERE autorisation=:s")
	public List<Annonce> getOnebyautorisation(@Param("s") boolean autorisation);
	
	@Query("from Annonce WHERE user_id=:s")
	public List<Annonce> getsomebyUser(@Param("s") long user_id);
	
	@Query("from Annonce WHERE cara_id=:s")
	public List<Annonce> getsomebycara(@Param("s") long cara_id);
	
	@Query("from Annonce WHERE titre LIKE CONCAT('%',:s,'%') AND autorisation=true")
	public List<Annonce> findtruebyString(@Param("s") String titre);
	
	@Query("from Annonce WHERE categorie_id=:s AND autorisation=true")
	public List<Annonce> getsometruebyCategorie(@Param("s") long categorie_id);
}
