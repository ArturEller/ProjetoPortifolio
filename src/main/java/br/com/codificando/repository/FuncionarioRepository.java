package br.com.codificando.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.codificando.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	public List<Funcionario> findAllByCargo(String cargo);
	public List<Funcionario> findAllByCargoNot(String cargo);

}
