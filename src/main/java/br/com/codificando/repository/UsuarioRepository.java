package br.com.codificando.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.codificando.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByLogin(String login);

}
