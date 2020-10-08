package br.com.codificando.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.codificando.model.Usuario;
import br.com.codificando.repository.PermissaoRepository;
import br.com.codificando.repository.UsuarioRepository;

@Component
public class CodificandoDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) 
			throws  UsernameNotFoundException{
		
		Usuario usuario = usuarioRepository.findByLogin(login);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return new UsuarioSistema(usuario.getNome(), usuario.getLogin(), usuario.getSenha(), authorities(usuario));
	}
	
	//public Collection<? extends GrantedAuthority> authorities
	//TODO Continuar na proxima aulita

}
