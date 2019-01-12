package com.inti.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Annonce implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long annonce_id;
	private String titre;
	private String description;
	private long prix;
	private long stock;
	private boolean autorisation;
	private String region_annonce;
	private String email_user;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
	@JsonIgnore
    private UserManager user;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
	
	@OneToMany(mappedBy="annonce")
	private List<Photo> photos;
	

	public long getAnnonce_id() {
		return annonce_id;
	}

	public void setAnnonce_id(long annonce_id) {
		this.annonce_id = annonce_id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
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

	public UserManager getUser() {
		return user;
	}

	public void setUser(UserManager user) {
		this.user = user;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}



	public Annonce(long annonce_id, String titre, String description, long prix, long stock, boolean autorisation,
			String region_annonce, String email_user, UserManager user, Categorie categorie, List<Photo> photos) {
		super();
		this.annonce_id = annonce_id;
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.stock = stock;
		this.autorisation = autorisation;
		this.region_annonce = region_annonce;
		this.email_user = email_user;
		this.user = user;
		this.categorie = categorie;
		this.photos = photos;
		
	}

	
	public Annonce(long annonce_id, String titre, String description, long prix, long stock, boolean autorisation,
			String region_annonce, String email_user, UserManager user, Categorie categorie) {
		super();
		this.annonce_id = annonce_id;
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.stock = stock;
		this.autorisation = autorisation;
		this.region_annonce = region_annonce;
		this.email_user = email_user;
		this.user = user;
		this.categorie = categorie;
	}

	public Annonce() {
		super();
	}

	public Annonce(String titre, String description, long prix, long stock, boolean autorisation, UserManager user, Categorie categorie,
			List<Photo> photos) {
		super();
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.stock = stock;
		this.autorisation=autorisation;
		this.user = user;
		this.categorie = categorie;
		this.photos = photos;
	}
	
	public Annonce(String titre, String description, long prix, long stock, boolean autorisation,String region_annonce,String email_user, UserManager user, Categorie categorie) {
		super();
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.stock = stock;
		this.autorisation=autorisation;
		this.region_annonce=region_annonce;
		this.email_user=email_user;
		this.user = user;
		this.categorie = categorie;
		
	}

	@Override
	public String toString() {
		return "Annonce [annonce_id=" + annonce_id + ", titre=" + titre + ", description=" + description + ", prix="
				+ prix + ", stock=" + stock + ", autorisation=" + autorisation + ", region_annonce=" + region_annonce
				+ ", email_user=" + email_user + ", categorie=" + categorie + ", photos=" + photos + "]";
	}


	
	

}
