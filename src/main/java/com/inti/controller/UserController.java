package com.inti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Adresse;
import com.inti.entities.Annonce;
import com.inti.entities.Panier;
import com.inti.entities.Region;
import com.inti.entities.UserManager;
import com.inti.services.AdresseService;
import com.inti.services.AnnonceService;
import com.inti.services.PanierService;
import com.inti.services.RegionService;
import com.inti.services.UserService;

@RestController
@RequestMapping(path="/users")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserService userServ;
	@Autowired 
	AdresseService adresseServ;
	@Autowired
	RegionService regionServ;
	@Autowired
	PanierService panierServ;
	
	//Permet d'ajouter un utilisateur si les informations renseignés sont correctes.
	@PostMapping(path="/adduser")
	public @ResponseBody boolean ajouterUSer(@RequestBody UserManager user) {
		System.out.println(user);
		System.out.println("l'adresse envoyé"+user.getAdresses());
		if(userServ.save(user)==true) {
			return true;
		}else{
			return false;
		}
	}

	//ajoute une adresse a la bdd
	@PostMapping(path="/addadresse")
	public @ResponseBody void ajouterAdresse(@RequestBody Adresse adresse) {
		System.out.println("adresse:"+adresse);
		System.out.println(adresseServ.save(adresse));
	}
	
	//Supprime un utilisateur
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping(path="/suppuser")
	public @ResponseBody void supprimerUser(long user_id) {
		userServ.delete(user_id);
	}
	
	//Change les information d'un user
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping(path="/modifuser")
	public @ResponseBody boolean updateUser(@RequestBody UserManager user) {
		return userServ.editUser(user);
	}

	//Passe un utilisateur en admin (seul le super_admin peut le faire)
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	@GetMapping(path="/estadmin")
	public @ResponseBody void defadmin(long user_id) {
		userServ.ladmin(user_id);
	}
	
	//Passe un admin en utilisateur simple (seul le super_admin peut le faire)
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	@GetMapping(path="/estplusadmin")
	public @ResponseBody void defplusadmin(long user_id) {
		userServ.plusadmin(user_id);
	
	}
	
	//Retourne la liste de tout les utilisateurs
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
	@GetMapping(path="/All")
	public @ResponseBody List<UserManager> getAllUser(){
		return userServ.findAll();
	}
	
	//Retourne un utilisateur grâce a son ID
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping(path="/One")
	public @ResponseBody UserManager getOneUser(long user_id) {
		return userServ.findById(user_id);
	}
	
	//Retourne un utilisateur grâce a son login
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN')")
	@GetMapping(path="/Onebylogin")
	public @ResponseBody UserManager getOneuserbyLogin(String login) {
		return userServ.findByusername(login);
	}
	
	//retourne la liste de toutes les adresses
	@GetMapping(path="/getadresse")
	public @ResponseBody List<Adresse> getadresse() {
		return adresseServ.findAll();
	}
	
	//retourne la liste de toutes les regions
	@GetMapping(path="/getAllregion")
	public @ResponseBody List<Region> getAllRegion() {
		return regionServ.getAll();
	}
	
	//supprime un utilisateur (si admin ou super admin)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
	@GetMapping(path="/deleteuser")
	public @ResponseBody void deleteUser(long user_id) {
		userServ.delete(user_id);
	}
	
	//ajoute une annonce au panier de l'utilisateur
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_SUPER_ADMIN')")
	@PostMapping(path="/ajoutpanier")
	public @ResponseBody void ajoutpanier(@RequestBody Panier panier) {
		panierServ.save(panier);
	}
}
