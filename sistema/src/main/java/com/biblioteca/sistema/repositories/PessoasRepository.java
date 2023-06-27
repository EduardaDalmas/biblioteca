package com.biblioteca.sistema.repositories;

import org.springframework.data.repository.CrudRepository;

import com.biblioteca.sistema.entities.Pessoas;

public interface PessoasRepository extends CrudRepository<Pessoas, Integer>{
    
}
