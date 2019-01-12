package com.inti.entities;

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
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long region_id;
	private String region_name;
	
	@OneToMany(mappedBy="regions")
	private List<Adresse> adresses;

	public long getRegion_id() {
		return region_id;
	}

	public void setRegion_id(long region_id) {
		this.region_id = region_id;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Region(long region_id, String region_name, List<Adresse> adresses) {
		super();
		this.region_id = region_id;
		this.region_name = region_name;
		this.adresses = adresses;
	}

	public Region() {
		super();
	}

	public Region(String region_name) {
		super();
		this.region_name = region_name;
	}

	public Region(String region_name, List<Adresse> adresses) {
		super();
		this.region_name = region_name;
		this.adresses = adresses;
	}

	@Override
	public String toString() {
		return "Region [region_id=" + region_id + ", region_name=" + region_name + "]";
	}
	
	
}
