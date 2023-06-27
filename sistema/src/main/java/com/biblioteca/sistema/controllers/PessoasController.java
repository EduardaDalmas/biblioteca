package com.biblioteca.sistema.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.sistema.entities.Pessoas;
import com.biblioteca.sistema.repositories.PessoasRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pessoas")
public class PessoasController {
    
    @Autowired
    PessoasRepository pessoasRepository;

    @GetMapping("/listar")
    public String biblioteca(Model model) {
        Iterable<Pessoas> pessoas = pessoasRepository.findAll();
        model.addAttribute("pessoas", pessoas);
        return "pessoas/listar";
    }

    @GetMapping("/novo")
    public String novo(Pessoas pessoas) {
        return "/pessoas/novo";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable("id") int id) {
        Optional<Pessoas> pessoas = pessoasRepository.findById(id);
        pessoasRepository.delete(pessoas.orElse(null));
        return "redirect:/pessoas/listar";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable("id") int id, Model model) {
        Optional<Pessoas> pessoas = pessoasRepository.findById(id);
        model.addAttribute("pessoas", pessoas.orElse(null));
        return "pessoas/alterar";
    }

    @PostMapping("/salvar")
    public String insere(@Valid Pessoas pessoas, BindingResult result) {
        if(result.hasErrors() == true) {
            if(pessoas.getId() != 0) {
                return "pessoas/alterar";
            } 
            return "pessoas/novo";
        }
        pessoasRepository.save(pessoas);
        return "redirect:/pessoas/listar";
    }
}
