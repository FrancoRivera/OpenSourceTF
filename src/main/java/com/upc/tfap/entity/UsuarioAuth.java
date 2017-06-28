package com.upc.tfap.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class UsuarioAuth extends org.springframework.security.core.userdetails.User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User usuario;

	public UsuarioAuth(String username, String password, boolean enabled,
	         boolean accountNonExpired, boolean credentialsNonExpired,
	         boolean accountNonLocked,
	         Collection<? extends GrantedAuthority> authorities, User u) {

	             super(username, password, enabled, accountNonExpired,
	                credentialsNonExpired, accountNonLocked, authorities);
	             usuario = u;

	     }
	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
}
