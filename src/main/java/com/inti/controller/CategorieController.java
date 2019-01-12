package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Categorie;
import com.inti.services.CategorieService;
import com.inti.servicesImpl.CategorieServiceImpl;

@RestController
@RequestMapping(path="/categorie")
@CrossOrigin("*")
public class CategorieController {

	@Autowired
	CategorieService cateServ;
	
	//Retourne une liste de toutes les catégories
	@GetMapping(path="/AllCategorie")
	public @ResponseBody List<Categorie> getAllCategorie(){
		return cateServ.findAll();
	}
	
	//Retourne une catégorie grâce à son nom
	@GetMapping(path="/OneCategorie")
	public @ResponseBody Categorie getCategorie(String categorie_name) {
		return cateServ.findByName(categorie_name);
	}
	
	//Retourne une catégorie par son ID
	@GetMapping(path="/Lacate")
	public @ResponseBody Categorie getlaCategorie(long categorie_id) {
		return cateServ.findById(categorie_id);
	}

}
