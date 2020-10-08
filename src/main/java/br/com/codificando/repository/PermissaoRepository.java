package br.com.codificando.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.codificando.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
