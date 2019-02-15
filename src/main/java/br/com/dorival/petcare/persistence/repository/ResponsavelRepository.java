package br.com.dorival.petcare.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.dorival.petcare.persistence.entity.Responsavel;

public interface ResponsavelRepository extends CrudRepository<Responsavel, Long> {
	
	List<Responsavel> findByNome(String nome);

}


