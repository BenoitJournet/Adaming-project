package com.inti.entities;

import java.io.Serializable;
import java.time.LocalDate;
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
public class UserManager implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	private String prenom_user;
	private String nom_user;
	private LocalDate ddN_user;
	private String mail_user;
	private String numero;
	private String login;
	private String password;
	private String photo_user;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id", referencedColumnName="user_id")
	,inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName="role_id"))
	private List<Roles> roles;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL) 
	@JoinColumn(name="adresse_id")
    private Adresse adresses;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Annonce> annonces;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Panier> panier;
	
	
	
	public Adresse getAdresses() {
		return adresses;
	}



	public void setAdresses(Adresse adresses) {
		this.adresses = adresses;
	}



	public List<Annonce> getAnnonces() {
		return annonces;
	}

	

	public long getUser_id() {
		return user_id;
	}



	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}



	public String getPrenom_user() {
		return prenom_user;
	}



	public void setPrenom_user(String prenom_user) {
		this.prenom_user = prenom_user;
	}



	public String getNom_user() {
		return nom_user;
	}



	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}



	public LocalDate getDdN_user() {
		return ddN_user;
	}



	public void setDdN_user(LocalDate ddN_user) {
		this.ddN_user = ddN_user;
	}



	public String getMail_user() {
		return mail_user;
	}



	public void setMail_user(String mail_user) {
		this.mail_user = mail_user;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPhoto_user() {
		return photo_user;
	}



	public void setPhoto_user(String photo_user) {
		this.photo_user = photo_user;
	}



	public List<Roles> getRoles() {
		return roles;
	}



	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}


	public List<Panier> getPanier() {
		return panier;
	}



	public void setPanier(List<Panier> panier) {
		this.panier = panier;
	}



	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}



	public UserManager(long user_id, String prenom_user, String nom_user, LocalDate ddN_user, String mail_user,
			String numero, String login, String password, String photo_user, List<Roles> roles,
			List<Annonce> annonces, List<Panier> panier) {
		super();
		this.user_id = user_id;
		this.prenom_user = prenom_user;
		this.nom_user = nom_user;
		this.ddN_user = ddN_user;
		this.mail_user = mail_user;
		this.numero = numero;
		this.login = login;
		this.password = password;
		this.photo_user = photo_user;
		this.roles = roles;
		this.annonces = annonces;
		this.panier = panier;
	}



	public UserManager() {
		super();
	}



	public UserManager(String prenom_user, String nom_user, LocalDate ddN_user, String mail_user, String numero,
			String login, String password, List<Roles> roles, Adresse adresses) {
		super();
		this.prenom_user = prenom_user;
		this.nom_user = nom_user;
		this.ddN_user = ddN_user;
		this.mail_user = mail_user;
		this.numero = numero;
		this.login = login;
		this.password = password;
		this.roles = roles;
		this.adresses = adresses;
	}



	public UserManager(long user_id, String prenom_user, String nom_user, LocalDate ddN_user, String mail_user,
			String numero, String login, String password, String photo_user, List<Roles> roles, Adresse adresses,
			List<Annonce> annonces, List<Panier> panier) {
		super();
		this.user_id = user_id;
		this.prenom_user = prenom_user;
		this.nom_user = nom_user;
		this.ddN_user = ddN_user;
		this.mail_user = mail_user;
		this.numero = numero;
		this.login = login;
		this.password = password;
		this.photo_user = photo_user;
		this.roles = roles;
		this.adresses = adresses;
		this.annonces = annonces;
		this.panier = panier;
	}



	public UserManager(String prenom_user, String nom_user, LocalDate ddN_user, String mail_user, String numero,
			String login, String password) {
		super();
		this.prenom_user = prenom_user;
		this.nom_user = nom_user;
		this.ddN_user = ddN_user;
		this.mail_user = mail_user;
		this.numero = numero;
		this.login = login;
		this.password = password;
		
	}

	


	public UserManager(String prenom_user, String nom_user, LocalDate ddN_user, String mail_user, String numero,
			String login, String password, Adresse adresses) {
		super();
		this.prenom_user = prenom_user;
		this.nom_user = nom_user;
		this.ddN_user = ddN_user;
		this.mail_user = mail_user;
		this.numero = numero;
		this.login = login;
		this.password = password;
		this.adresses = adresses;
	}



	@Override
	public String toString() {
		return "UserManager [user_id=" + user_id + ", prenom_user=" + prenom_user + ", nom_user=" + nom_user
				+ ", ddN_user=" + ddN_user + ", mail_user=" + mail_user + ", numero=" + numero + ", login=" + login
				+ ", password=" + password + ", photo_user=" + photo_user + ", roles=" + roles + ", adresses="
				+ adresses + ", annonces=" + annonces + ", panier=" + panier + "]";
	}



	
	
}
