package br.com.dorival.petcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dorival.petcare.persistence.entity.Responsavel;
import br.com.dorival.petcare.persistence.repository.ResponsavelRepository;

@Service
public class ResponsavelService {

	    @Autowired
	    private ResponsavelRepository repository;


	    public Iterable<Responsavel> obterTodos(){
	        Iterable<Responsavel> responsaveis = repository.findAll();
	        return responsaveis;
	    }

	    public void salvar(Responsavel responsavel){
	        repository.save(responsavel);
	    }
	}
	