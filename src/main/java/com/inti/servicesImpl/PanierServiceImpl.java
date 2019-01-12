package com.inti.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Panier;
import com.inti.entities.UserManager;
import com.inti.repository.PanierRepository;
import com.inti.services.PanierService;
import com.inti.services.UserService;

@Service
public class PanierServiceImpl implements PanierService{

	@Autowired
	PanierRepository panierRepo;
	
	
	UserManager theuser = new UserManager();
	
	@Autowired
	UserService userServ;
	
	@Override
	public Panier save(Panier panier) {
		
		return panierRepo.save(panier);
	}

	@Override
	public Panier editPanier(Panier panier) {
		
		return panierRepo.save(panier);
	}

	@Override
	public List<Panier> findAllPanier() {
		
		return panierRepo.findAll();
	}

	@Override
	public List<Panier> findOnePanierbyAnnonce(long id_annonce) {
		
		return panierRepo.findbyAnnonce(id_annonce);
	}

	@Override
	public Panier findOnePanierbyId(long panier_id) {
		
		return panierRepo.findbyId(panier_id);
	}

	@Override
	public void suppPanier(long panier_id) {
		panierRepo.deleteById(panier_id);
		
	}

	@Override
	public void ajoutpanier(Panier panier) {
		panierRepo.save(panier);
	}

	@Override
	public void retirerpanier(long panier_id) {
	
		panierRepo.deleteById(panier_id);
			}
			
		
}

	

