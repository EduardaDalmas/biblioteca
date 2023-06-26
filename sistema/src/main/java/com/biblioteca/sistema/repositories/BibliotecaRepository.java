package com.biblioteca.sistema.repositories;

import org.springframework.data.repository.CrudRepository;

import com.biblioteca.sistema.entities.Biblioteca;

public interface BibliotecaRepository extends CrudRepository<Biblioteca, Integer> {
    
}
