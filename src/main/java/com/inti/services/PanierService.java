package com.inti.services;

import java.util.List;

import com.inti.entities.Panier;

public interface PanierService {

	public Panier save(Panier panier);
	public Panier editPanier(Panier panier);
	public List<Panier> findAllPanier();
	public List<Panier> findOnePanierbyAnnonce(long id_annonce);
	public Panier findOnePanierbyId(long panier_id);
	public void suppPanier(long panier_id);
	public void ajoutpanier(Panier panier);
	public void retirerpanier(long panier_id);
}
