package com.project.ica.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.ica.dao.UsuariDAO;
import com.project.ica.entity.Usuario;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UsuariDAO usuariDAO;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		
		Usuario bean = null;
		bean = usuariDAO.iniciarSession(username);
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(bean.getRol().getNomRol()));
		
		userDetails = new User(username, bean.getPassword(), authorities);
		return userDetails;
	}
	
	
}
