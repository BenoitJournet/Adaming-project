package com.inti.services;

import java.util.List;

import com.inti.entities.Annonce;
import com.inti.entities.AnnonceDTO;

public interface AnnonceService {

	public Annonce findByTitre(String titre);
	public Annonce save(AnnonceDTO annonce);
	public List<Annonce> findAll();
	public void delete(long id);
	public List<Annonce> findSome(String string);
	public Annonce findById(long annonce_id);
	public Annonce valider(Annonce annonce);
	public Annonce editAnnonce(Annonce annonce);
	public List<Annonce> findbyCategorie(long categorie_id);
	public List<Annonce> findbyUser(long user_id);
	public List<Annonce> findbyRegion(String region_annonce);	
	public List<Annonce> getAnnonceunder(long prix);
	public List<Annonce> getAnnoncesup(long prix);
	public List<Annonce> getbyCara(long cara_id);
	public List<Annonce> findbyString(String titre);
	public List<Annonce> findbydroit(boolean autorisation);
	public List<Annonce> findtruebytitre(String titre);
	public List<Annonce> findtruebyCate(long categorie_id);
	public List<Annonce> findavecfiltre(String categorie, long categorie_id, String filtre, String filtre_value);
	public void update(boolean autorisation, long annonce_id);
	public void multipledelete(List<Long> annonces);
}
