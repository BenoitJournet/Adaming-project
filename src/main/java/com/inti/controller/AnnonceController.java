package com.inti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Annonce;
import com.inti.entities.AnnonceDTO;
import com.inti.entities.Region;
import com.inti.entities.UserManager;
import com.inti.repository.AnnonceRepository;
import com.inti.services.AnnonceService;
import com.inti.services.RegionService;
import com.inti.services.UserService;
import com.inti.servicesImpl.AnnonceServiceImpl;
import com.inti.servicesImpl.UserServiceImpl;

@RestController
@RequestMapping(path="/annonce")
@CrossOrigin("*")
public class AnnonceController {
	
	@Autowired
	AnnonceService annonceServ;
	@Autowired
	UserService userServ;
	@Autowired
	RegionService regionServ;
	
	//Retourne une liste de toutes les annonces
	@GetMapping(path="/Allannonce")
	public @ResponseBody List<Annonce> getAllAnnonce(){
		return annonceServ.findAll();
	}
	
	//Retourne une liste de toutes les annonces poster par un utilisateur 
	@GetMapping(path="/GetbyUser")
	public @ResponseBody List<Annonce> getAllAnnoncesofUser(long user_id){
		return userServ.findById(user_id).getAnnonces();
	}
	       	
	//Permet d'autoriser l'affichage d'une annonce sur l'accueil 
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(path="/autoriserannonce")
	public @ResponseBody Annonce defineAutorisationTrue(@RequestBody long annonce_id) {
		Annonce annonce=annonceServ.findById(annonce_id);
		return annonceServ.valider(annonce);
	}
	
	//Supprime une annonce par son ID
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN')")
	@GetMapping(path="/suppannonce")
	public @ResponseBody void supprimerAnnonce(long annonce_id) {
		annonceServ.delete(annonce_id);
	}
	
	//Permet de poster une annonce 
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN')")
	@PostMapping(path="/ajouterannonce")
	public @ResponseBody void ajouterAnnonce(@RequestBody AnnonceDTO annonce) {
		annonceServ.save(annonce);
	}
	
	//Retourne une annonce grâce a son ID
	@GetMapping(path="/OneAnnonce")
	public @ResponseBody Annonce getOneAnnonce(long annonce_id) {
		System.out.println("la fonction pour trouver l'annnonce");
		System.out.println(annonceServ.findById(annonce_id));
		return annonceServ.findById(annonce_id);
		
	}
	
	//Retourne une annonce grâce a son Titre
	@GetMapping(path="/AnnoncebyTitre")
	public @ResponseBody List<Annonce> getOneAnnonce(String titre) {
		return annonceServ.findbyString(titre);
	}
	
	//Retourne une liste des annonces autorisée
	@GetMapping(path="/Alltrue")
	public @ResponseBody List<Annonce> getAlltrue(boolean autorisation){
		return annonceServ.findbydroit(autorisation);
	}

	//Retourne une liste des annonces autorisées ayant un titre proche de celui rentré
	@GetMapping(path="/AnnoncetruebyTitre")
	public @ResponseBody List<Annonce> gettrueAnnonce(String titre) {
		return annonceServ.findtruebytitre(titre);
	}
	
	//Retourne une liste des annonces autorisées dans une catégorie 
	@GetMapping(path="/Annoncetruebycate")
	public @ResponseBody List<Annonce> gettrueAnnoncecate(long categorie_id) {
		return annonceServ.findtruebyCate(categorie_id);
	}
	
	//Retourne une liste des annonces autorisées ayant un prix inférieur ou égale au prix entré
	@GetMapping(path="/trueannonceinfa")
	public @ResponseBody List<Annonce> trueInfA(long prix) {
		return annonceServ.getAnnonceunder(prix);
	}
	
	//Change l'autorisation d'une annonce
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
	@PutMapping(path="/changeautorisation")
	public @ResponseBody void changeautorisation(@RequestBody String[] tab) {
		boolean b;
		if(tab[0]=="true") {
			b=true;
		}else {
			b=false;
		}
		 annonceServ.update(b, Long.parseLong(tab[1]));
	}
	
	//Permet de supprimer une liste d'annonce
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
	@PostMapping(path="/multiplesupp")
	public @ResponseBody void deletemultiple(@RequestBody Long[] tab) {
		List<Long> annonce_ids=new ArrayList<>();
	for(int i=0;i<tab.length;i++) {
		annonce_ids.add(tab[i]);
	}
		 annonceServ.multipledelete(annonce_ids);
	}
}
