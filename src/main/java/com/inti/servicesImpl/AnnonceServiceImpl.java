package com.inti.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Annonce;
import com.inti.entities.AnnonceDTO;
import com.inti.repository.AnnonceRepository;
import com.inti.services.AnnonceService;
import com.inti.services.CategorieService;
import com.inti.services.UserService;

@Service
public class AnnonceServiceImpl implements AnnonceService{

	@Autowired
	AnnonceRepository annonceRepo;
	@Autowired
	UserService userServ;
	@Autowired
	CategorieService cateServ;
	
	
	@Override
	public Annonce findByTitre(String titre) {
		
		return annonceRepo.findbytitre(titre);
	}

	@Override
	public Annonce save(AnnonceDTO annoncedto) {
		System.out.println();
		Annonce annonce= new Annonce(
				annoncedto.getAnnonce_id(),
				annoncedto.getTitre(),
				annoncedto.getDescription(),
				annoncedto.getPrix(),
				annoncedto.getStock(),
				annoncedto.isAutorisation(),
				annoncedto.getRegion_annonce(),
				annoncedto.getEmail_user(),
				
				userServ.findById(annoncedto.getUser_id()),
				
				cateServ.findById(annoncedto.getCategorie_id()));
		return annonceRepo.save(annonce);
	}

	@Override
	public List<Annonce> findAll() {
		
		return annonceRepo.findAll();
	}

	@Override
	public void delete(long id) {
		annonceRepo.deleteById(id);
		
	}

	@Override
	public List<Annonce> findSome(String string) {
		
		return annonceRepo.findbyString(string);
	}

	@Override
	public Annonce findById(long annonce_id) {
	
		return annonceRepo.getOnebyId(annonce_id);
	}

	@Override
	public Annonce valider(Annonce annonce) {
		 annonce.setAutorisation(true);
		 return annonceRepo.save(annonce);
	}

	@Override
	public Annonce editAnnonce(Annonce annonce) {
		
		return annonceRepo.save(annonce);
	}

	@Override
	public List<Annonce> findbyCategorie(long categorie_id) {
		
		return annonceRepo.getsomebyCategorie(categorie_id);
	}

	@Override
	public List<Annonce> findbyUser(long user_id) {
		
		return annonceRepo.getsomebyUser(user_id);
	}

	@Override
	public List<Annonce> findbyRegion(String region_annonce) {
		
		return annonceRepo.getOnebyadresse(region_annonce);
	}

	@Override
	public List<Annonce> getAnnonceunder(long prix) {
		
		return annonceRepo.getsomebyPrixinf(prix);
	}

	@Override
	public List<Annonce> getAnnoncesup(long prix) {
		
		return annonceRepo.getsomebyPrixsup(prix);
	}

	@Override
	public List<Annonce> getbyCara(long cara_id) {
		
		return annonceRepo.getsomebycara(cara_id);
	}

	@Override
	public List<Annonce> findbyString(String titre) {
		
		return annonceRepo.findbyString(titre);
	}

	@Override
	public List<Annonce> findbydroit(boolean autorisation) {
	
		return annonceRepo.getOnebyautorisation(autorisation);
	}

	@Override
	public List<Annonce> findtruebytitre(String titre) {
		
		return annonceRepo.findtruebyString(titre);}

	@Override
	public List<Annonce> findtruebyCate(long categorie_id) {
		return annonceRepo.getsometruebyCategorie(categorie_id);
	}
	
	@Override
	public List<Annonce> findavecfiltre(String categorie, long categoire_id, String filtre, String filtre_value){
		return annonceRepo.getsomebyfiltre( categorie, categoire_id,  filtre,  filtre_value);
	}

	@Override
	public void update(boolean autorisation, long annonce_id) {
		 annonceRepo.update(autorisation, annonce_id);
	}

	@Override
	public void multipledelete(List<Long> annonce_id) {
		for(int i=0;i<annonce_id.size();i++) {
			annonceRepo.deleteById(annonce_id.get(i));
		}
		
	}
}
