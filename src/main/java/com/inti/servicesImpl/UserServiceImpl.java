package com.inti.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.inti.entities.Roles;
import com.inti.entities.UserManager;
import com.inti.repository.UserRepository;
import com.inti.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	
	public boolean estUnEntier(String chaine) { 
		try { Integer.parseInt(chaine); } 
		catch (NumberFormatException e){ 
			return false; } 
		return true; }
	
	
	public String encrypt(String password){
		password = BCrypt.hashpw(password, BCrypt.gensalt(10)); 
		System.out.println(password); 
		return password; }
	
	@Override
	public UserManager findBylogin(String login, String password) {
		// TODO Auto-generated method stub
		return userRepo.authenticate(login, password);
	}

	@Override
	public UserManager findByusername(String login) {
		// TODO Auto-generated method stub
		return userRepo.findbyname(login);
	}

	@Override
	public boolean save(UserManager user) {
		System.out.println("l'user: "+user);
		System.out.println("l'adresse de l'user: "+user.getAdresses());
		System.out.println("la region de l'user: "+user.getAdresses().getRegion());
		List<Roles> roles = new ArrayList<>();
		roles.add(new Roles(0));
		user.setRoles(roles);
		user.setPassword(encrypt(user.getPassword()));
		if(estUnEntier(user.getNumero())==true && user.getNumero().length()==10) {
			if(user.getMail_user().matches("^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"+ "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$")==true ){
				userRepo.save(user);
		System.out.println("yes");
		return true;
		}
		else {
			System.out.println("nop");
			return false;
		}
		}
			else {
				System.out.println("nop");
				return false;
			}
	}

	@Override
	public List<UserManager> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public void delete(long id) {
		userRepo.deleteById(id);
	}


	@Override
	public List<UserManager> findSome(String string) {
		return userRepo.findbyString(string);
	}

	@Override
	public UserManager findById(long user_id) {
		
		return userRepo.getOnebyId(user_id);
	}

	@Override
	public boolean editUser(UserManager user) {
		if(estUnEntier(user.getNumero())==true && user.getNumero().length()==10) {
			if(user.getMail_user().matches("^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"+ "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$")==true ){
				userRepo.save(user);
		System.out.println("yes");
		return true;
		}
		else {
			System.out.println("nop");
			return false;
		}
		}
			else {
				System.out.println("nop");
				return false;
			}
	}


	@Override
	public UserManager ladmin(long user_id) {
		System.out.println(user_id);
		List<Roles> roles = new ArrayList<>();
		roles.add(new Roles(1,"ROLE_ADMIN"));
		System.out.println(roles);
		UserManager user=getOnebyId(user_id);
		System.out.println("user avant clear"+user);
		user.getRoles().clear();
		System.out.println("user après clear"+user);
		user.setRoles(roles);
		System.out.println(user);
		return userRepo.save(user);
		
	}


	@Override
	public UserManager plusadmin(long user_id) {
		System.out.println(user_id);
		List<Roles> roles = new ArrayList<>();
		roles.add(new Roles(0));
		System.out.println(roles);
		UserManager user=userRepo.getOne(user_id);
		user.getRoles().clear();
		user.setRoles(roles);
		System.out.println(user);
		return userRepo.save(user);
	}


	@Override
	public UserManager getOnebyId(long user_id) {
		
		return userRepo.getOnebyId(user_id);
	}

}
