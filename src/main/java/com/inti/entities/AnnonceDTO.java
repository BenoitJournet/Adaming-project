package com.inti.entities;

import java.util.List;

public class AnnonceDTO {
	private long annonce_id;
	private String titre;
	private String description;
	private long prix;
	private long stock;
	private boolean autorisation;
	private String region_annonce;
	private String email_user;
	private long user_id;
	private long categorie_id;
	private List<String> photos;
	
	
	public long getAnnonce_id() {
		return annonce_id;
	}
	public void setAnnonce_id(long annonce_id) {
		this.annonce_id = annonce_id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre_annonce) {
		this.titre= titre_annonce;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPrix() {
		return prix;
	}
	public void setPrix(long prix) {
		this.prix = prix;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public boolean isAutorisation() {
		return autorisation;
	}
	public void setAutorisation(boolean autorisation) {
		this.autorisation = autorisation;
	}
	public String getRegion_annonce() {
		return region_annonce;
	}
	public void setRegion_annonce(String region_annonce) {
		this.region_annonce = region_annonce;
	}
	public String getEmail_user() {
		return email_user;
	}
	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getCategorie_id() {
		return categorie_id;
	}
	public void setCategorie_id(long categorie_id) {
		this.categorie_id = categorie_id;
	}
	public List<String> getPhotos() {
		return photos;
	}
	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}
	
	public AnnonceDTO(String titre, String description, long prix, long stock, boolean autorisation,
			String region_annonce, String email_user, long user_id, long categorie_id, List<String> photos) {
		super();
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.stock = stock;
		this.autorisation = autorisation;
		this.region_annonce = region_annonce;
		this.email_user = email_user;
		this.user_id = user_id;
		this.categorie_id = categorie_id;
		this.photos = photos;
	}
	public AnnonceDTO() {
		super();
	}
	
	
	public AnnonceDTO(long annonce_id, String titre, String description, long prix, long stock, boolean autorisation,
			String region_annonce, String email_user, long user_id, long categorie_id) {
		super();
		this.annonce_id = annonce_id;
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.stock = stock;
		this.autorisation = autorisation;
		this.region_annonce = region_annonce;
		this.email_user = email_user;
		this.user_id = user_id;
		this.categorie_id = categorie_id;
	
	}
	public AnnonceDTO(String titre, String description, long prix, long stock, boolean autorisation,
			String region_annonce, String email_user, long user_id, long categorie_id) {
		super();
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.stock = stock;
		this.autorisation = autorisation;
		this.region_annonce = region_annonce;
		this.email_user = email_user;
		this.user_id = user_id;
		this.categorie_id = categorie_id;
	}

	
}
