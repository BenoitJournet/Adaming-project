package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="role")
public class Roles implements Serializable {

	@Id
	private long role_id;
	private String role_name;
	public long getRole_id() {
		return role_id;
	}
	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public Roles() {
		super();
	}
	public Roles(long role_id) {
		super();
		this.role_id = role_id;
	}
	public Roles(long role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name=role_name;
	}
	@Override
	public String toString() {
		return "Roles [role_id=" + role_id + ", role_name=" + role_name + "]";
	}


	
}
