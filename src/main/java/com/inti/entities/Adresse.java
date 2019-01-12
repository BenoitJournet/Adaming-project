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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Adresse implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adresse_id;
	private String rue;
	private String ville;
	private String pays;
	private String numero;
	private long code_postal;

	
	@OneToMany(mappedBy="adresses")
	@JsonIgnore
	private List<UserManager> users;
	
	
	@ManyToOne(fetch=FetchType.EAGER) 
	@JoinColumn(name="region_id")
    private Region regions;
	
	public List<UserManager> getUsers() {
		return users;
	}

	public void setUsers(List<UserManager> users) {
		this.users = users;
	}

	public long getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(long code_postal) {
		this.code_postal = code_postal;
	}

	public long getAdresse_id() {
		return adresse_id;
	}

	public void setAdresse_id(long adresse_id) {
		this.adresse_id = adresse_id;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Region getRegion() {
		return regions;
	}

	public void setRegion(Region region) {
		this.regions = region;
	}


	public Adresse() {
		super();
	}

	public Adresse(String rue, String ville, String pays, String numero, Region region, long code_postal) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.pays = pays;
		this.numero = numero;
		this.regions = region;
		this.code_postal = code_postal;
	}

	public Adresse(long adresse_id, String rue, String ville, String pays, String numero, Region region,
			long code_postal) {
		super();
		this.adresse_id = adresse_id;
		this.rue = rue;
		this.ville = ville;
		this.pays = pays;
		this.numero = numero;
		this.regions = region;
		this.code_postal = code_postal;
	}

	public Adresse(long adresse_id, String rue, String ville, String pays, String numero, Region region,
			long code_postal, List<UserManager> users) {
		super();
		this.adresse_id = adresse_id;
		this.rue = rue;
		this.ville = ville;
		this.pays = pays;
		this.numero = numero;
		this.regions = region;
		this.code_postal = code_postal;
		this.users = users;
	}

	
	public Adresse(String rue, String ville, String pays, String numero, Region region, long code_postal, List<UserManager> users) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.pays = pays;
		this.numero = numero;
		this.regions = region;
		this.code_postal = code_postal;
		this.users = users;
	}

	@Override
	public String toString() {
		return numero+" "+rue+" "+code_postal+" "+ville+" "+regions+" "+pays;
	}


	
}
