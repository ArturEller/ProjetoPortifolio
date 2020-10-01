package br.com.codificando.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.codificando.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
