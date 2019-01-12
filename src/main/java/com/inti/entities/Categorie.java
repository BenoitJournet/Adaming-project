package com.inti.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Categorie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categorie_id;
	private String categorie_name;
	private String categorie_description;
	
	
	@OneToMany(mappedBy="categorie", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Annonce> annonces;
	
	
	public List<Annonce> getAnnonces() {
		return annonces;
	}
	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}
	
	public long getCategorie_id() {
		return categorie_id;
	}
	
	public void setCategorie_id(long categorie_id) {
		this.categorie_id = categorie_id;
	}
	public String getCategorie_name() {
		return categorie_name;
	}
	public void setCategorie_name(String categorie_name) {
		this.categorie_name = categorie_name;
	}
	public String getCategorie_description() {
		return categorie_description;
	}
	public void setCategorie_description(String categorie_description) {
		this.categorie_description = categorie_description;
	}
	public Categorie(long categorie_id, String categorie_name, String categorie_description) {
		super();
		this.categorie_id = categorie_id;
		this.categorie_name = categorie_name;
		this.categorie_description = categorie_description;
	}
	public Categorie() {
		super();
	}
	public Categorie(String categorie_name, String categorie_description) {
		super();
		this.categorie_name = categorie_name;
		this.categorie_description = categorie_description;
	}
	
	
}
