package com.inti.services;

import java.util.List;

import com.inti.entities.Roles;
import com.inti.entities.UserManager;

public interface UserService {

	public UserManager findBylogin(String login, String password);
	public UserManager findByusername(String login);
	public boolean save(UserManager user);
	public List<UserManager> findAll();
	public void delete(long id);
	public List<UserManager> findSome(String string);
	public UserManager findById(long user_id);
	public boolean editUser(UserManager user);
	public UserManager ladmin(long user_id);
	public UserManager plusadmin(long user_id);
	public UserManager getOnebyId(long user_id);
	
}
