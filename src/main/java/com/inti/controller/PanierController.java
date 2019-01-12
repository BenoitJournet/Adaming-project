package com.inti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Annonce;
import com.inti.entities.Panier;
import com.inti.entities.UserManager;
import com.inti.services.AnnonceService;
import com.inti.services.PanierService;
import com.inti.services.UserService;
import com.inti.servicesImpl.PanierServiceImpl;

@RestController
@RequestMapping(path="/panier")
@CrossOrigin("*")
public class PanierController {

	@Autowired
	PanierService panierServ;
	@Autowired
	UserService userServ;
	@Autowired
	AnnonceService annonceServ;
	
	//Retourne la liste de tout les panier des différents utilisateurs
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_SUPER_ADMIN')")
	@GetMapping(path="/Allpanier")
	public @ResponseBody List<Panier> getAllPanier(){
		return panierServ.findAllPanier();
	}
	
	//Retourne un panier par son ID
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_SUPER_ADMIN')")
	@GetMapping(path="/unpanier")
	public @ResponseBody Panier getOnePanier(long panier_id) {
		return panierServ.findOnePanierbyId(panier_id);
	}
	
	//Retourne une liste de panier contenant cette ID d'annonce
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_SUPER_ADMIN')")
	@GetMapping(path="/pannierannonce")
	public @ResponseBody List<Panier> getOnePanierAn(long id_annonce) {
		return panierServ.findOnePanierbyAnnonce(id_annonce);
	}
	
	//Créer un panier et y ajoute une annonce
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_SUPER_ADMIN')")
	@PostMapping(path="/ajouteraupanier")
	public @ResponseBody void ajoutpanier(@RequestBody Panier panier) {
		 panierServ.ajoutpanier(panier);
	}
	
	//Supprime un panier grâce a son ID
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_SUPER_ADMIN')")
	@GetMapping(path="/retirerdupanier")
	public @ResponseBody void retirerpanier( long panier_id) {
		panierServ.retirerpanier(panier_id);
	}
	
	//Retourne une liste des annonces dans le panier de l'utilisateur
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_SUPER_ADMIN')")
	@GetMapping(path="/cadis")
	public @ResponseBody List<Annonce> affichecadis( long user_id) {
		UserManager user=userServ.findById(user_id);
		 List<Panier> cadis =user.getPanier();
		 List<Annonce> annonces = new ArrayList<Annonce>();
		 for(int i =0; i<cadis.size();i++) {
			 annonces.add(annonceServ.findById(cadis.get(i).getId_annonce()));
		 }
		return annonces;
	}
	
	
}
