package com.inti.services;

import java.util.List;

import com.inti.entities.Adresse;

public interface AdresseService {

	public Adresse findByRegion(String region);
	public Adresse save(Adresse adresse);
	public void delete(long adresse_id);
	public Adresse findById(long adresse_id);
	public Adresse editAdresse(Adresse adresse);
	public List<Adresse> findbyuser(long user_id);
	public List<Adresse> findAll();
	public Adresse Ladresse(Adresse adresse);
}
