package com.biblioteca.sistema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.sistema.entities.Biblioteca;
import com.biblioteca.sistema.repositories.BibliotecaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/biblioteca")
public class BibliotecaController {

    @Autowired
    BibliotecaRepository bibliotecaRepository;

    @GetMapping("/listar")
    public String biblioteca(Model model) {
        Iterable<Biblioteca> livros = bibliotecaRepository.findAll();
        model.addAttribute("livros", livros);
        return "biblioteca/listar";
    }

    @GetMapping("/novo")
    public String novo(Biblioteca biblioteca) {
        return "/professor/novo";
    }

    @PostMapping("/salvar")
    public String insere(@Valid Biblioteca biblioteca, BindingResult result) {
        if(result.hasErrors() == true) {
            if(biblioteca.getId() != 0) {
                return "biblioteca/alterar";
            } 
            return "biblioteca/novo";
        }
        bibliotecaRepository.save(biblioteca);
        return "redirect:/biblioteca/listar";
    }
}
