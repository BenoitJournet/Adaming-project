package com.inti.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long photo_id;
	private String laphoto;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "annonce_id")
    private Annonce annonce;

	public long getPhoto_id() {
		return photo_id;
	}

	public void setPhoto_id(long photo_id) {
		this.photo_id = photo_id;
	}

	public String getLaphoto() {
		return laphoto;
	}

	public void setLaphoto(String laphoto) {
		this.laphoto = laphoto;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public Photo() {
		super();
	}

	public Photo(long photo_id, String laphoto, Annonce annonce) {
		super();
		this.photo_id = photo_id;
		this.laphoto = laphoto;
		this.annonce = annonce;
	}

	public Photo(String laphoto, Annonce annonce) {
		super();
		this.laphoto = laphoto;
		this.annonce = annonce;
	}
	
	
}
