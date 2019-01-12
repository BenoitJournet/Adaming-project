package com.inti.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Categorie;
import com.inti.repository.CategorieRepository;
import com.inti.services.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService{

	@Autowired
	CategorieRepository categorieRepo;
	
	@Override
	public Categorie findByName(String categorie_name) {
		return categorieRepo.findbyname(categorie_name);
	}

	@Override
	public Categorie save(Categorie categorie) {
		return categorieRepo.save(categorie);
	}

	@Override
	public List<Categorie> findAll() {
		return categorieRepo.findAll();
	}

	@Override
	public void delete(long categorie_id) {
		categorieRepo.deleteById(categorie_id);
		
	}

	@Override
	public List<Categorie> findSome(String string) {
		return categorieRepo.findbyString(string);
	}

	@Override
	public Categorie findById(long categorie_id) {
		return categorieRepo.getOnebyId(categorie_id);
	}

	@Override
	public Categorie editCategorie(Categorie categorie) {
		
		return categorieRepo.save(categorie);
	}

	
}
