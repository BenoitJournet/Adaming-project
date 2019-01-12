package com.inti.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.inti.services.UserService;
import com.inti.servicesImpl.UserServiceImpl;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Panier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long panier_id;
	private long id_annonce;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    private UserManager user;

	public long getPanier_id() {
		return panier_id;
	}

	public void setPanier_id(long panier_id) {
		this.panier_id = panier_id;
	}

	public long getId_annonce() {
		return id_annonce;
	}

	public void setId_annonce(long id_annonce) {
		this.id_annonce = id_annonce;
	}

	public UserManager getUser() {
		return user;
	}

	public void setUser(UserManager user) {
		this.user = user;
	}

	public Panier() {
		super();
	}


	public Panier(long panier_id, long id_annonce, UserManager user) {
		super();
		this.panier_id = panier_id;
		this.id_annonce = id_annonce;
		this.user = user;
	}

	public Panier(long id_annonce, UserManager user) {
		super();
		this.id_annonce = id_annonce;
		this.user = user;
	}
	
	
}
