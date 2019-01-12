package com.inti.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.inti.entities.UserManager;
import com.inti.services.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserService userServ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserManager usermanager=userServ.findByusername(username);
		if(usermanager == null) throw new UsernameNotFoundException(username);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		usermanager.getRoles().forEach(role->{
			authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
			System.out.println(role.getRole_name());
		});
		
		return (UserDetails) new User(usermanager.getLogin(),usermanager.getPassword(),authorities);
	}
	

}
