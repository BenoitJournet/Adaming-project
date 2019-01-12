package com.inti.services;

import java.util.List;


import com.inti.entities.Categorie;

public interface CategorieService {

	public Categorie findByName(String categorie_name);
	public Categorie save(Categorie categorie);
	public List<Categorie> findAll();
	public void delete(long categorie_id);
	public List<Categorie> findSome(String string);
	public Categorie findById(long categorie_id);
	public Categorie editCategorie(Categorie categorie);
}
