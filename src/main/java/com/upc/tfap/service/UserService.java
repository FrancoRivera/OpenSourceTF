package com.upc.tfap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.upc.tfap.entity.Rol;
import com.upc.tfap.entity.User;
import com.upc.tfap.entity.UsuarioAuth;
import com.upc.tfap.repository.UserRepository;


@Service
public class UserService implements IUserService {

	@Autowired
	public UserRepository ue;
	
	@Override
	public com.upc.tfap.entity.User login(com.upc.tfap.entity.User u) {
		// TODO Auto-generated method stub
		return ue.login(u.getDniruc(), u.getPassword());
	}

	@Override
	public List<com.upc.tfap.entity.User> listar() {	
		return ue.findAll();
	}

	@Override
	public String registrar(com.upc.tfap.entity.User u) {
		if (ue.save(u) != null) return "Perfecto, ahora inicia sesion con tu nuevo usuario";
		return "Hubo un error, intenta nuevamente";
		
	}
	@Override
	public String delete(User u) {
		ue.delete(u);
		return "Deleted";
		
	}
	
	

	@Autowired
	private UserRepository usuarioRepository;

	// Se encargara de llamar a nuestro repository y se obtendra una entidad
		// usuario(com.pe.entity.Usuario) la cual se tendra que transformar a un userDetails
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			// TODO Auto-generated method stub

			List<GrantedAuthority> authorities = new ArrayList<>();
			
			// Se obtiene el usuario en base a username
			com.upc.tfap.entity.User usuario = usuarioRepository.findByDniruc(username);

			if(usuario==null){
				throw new UsernameNotFoundException("No user found with email:"+username);
			}
			
			// Transformar los roles a autorities
			authorities = buildAuthorities(usuario.getRol());
			UsuarioAuth lus = buildUser(usuario, authorities);
			System.out.println(lus.getPassword());
			BCryptPasswordEncoder bp = new BCryptPasswordEncoder();
			return lus;

		}

		// Retorna un User tipo de objeto que spring security necesita, recibe por
		// parametro usuario(com.pe.entity.Usuario) y una lista
		// de authorities(GrantedAuthority) que en realidad es nuestra entidad rol
		private UsuarioAuth buildUser(com.upc.tfap.entity.User usuario, List<GrantedAuthority> authorities) {
			return new UsuarioAuth(usuario.getDniruc(), usuario.getPassword(), usuario.isEnable(), true, true, true, authorities, usuario);
		}

		// Asigna nuestros roles a una lista de grantedautorities
		private List<GrantedAuthority> buildAuthorities(List<Rol> usuarioRoles) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

			for (Rol rol : usuarioRoles) {
				authorities.add(new SimpleGrantedAuthority(rol.getName_role()));
			}
			return authorities;
		}
		



}
