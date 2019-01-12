package com.inti.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Adresse;
import com.inti.repository.AdresseRepository;
import com.inti.services.AdresseService;


@Service
public class AdresseServiceImpl implements AdresseService{

	@Autowired
	AdresseRepository adresseRepo;

	@Override
	public Adresse findByRegion(String region) {
		return adresseRepo.findbyregion(region);
	}

	@Override
	public Adresse save(Adresse adresse) {
		return adresseRepo.save(adresse);
	}

	@Override
	public void delete(long adresse_id) {
		adresseRepo.deleteById(adresse_id);
		
	}

	@Override
	public Adresse findById(long adresse_id) {
		return adresseRepo.getOnebyId(adresse_id);
	}

	@Override
	public Adresse editAdresse(Adresse adresse) {
		return adresseRepo.save(adresse);
	}

	@Override
	public List<Adresse> findbyuser(long user_id) {
		
		return adresseRepo.findbyuser(user_id);
	}

	@Override
	public List<Adresse> findAll() {
		
		return adresseRepo.findAll();
		}

	@Override
	public Adresse Ladresse(Adresse adresse) {
		
		return adresseRepo.findladresse(adresse.getRegion(),adresse.getVille(), adresse.getNumero(), adresse.getRue(), adresse.getPays());
	}
	
	
	
}
