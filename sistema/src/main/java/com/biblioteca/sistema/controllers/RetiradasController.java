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

import com.biblioteca.sistema.entities.Retiradas;
import com.biblioteca.sistema.repositories.RetiradasRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/retiradas")
public class RetiradasController {

    @Autowired
    RetiradasRepository retiradasRepository;

     @GetMapping("/listar")
    public String biblioteca(Model model) {
        Iterable<Retiradas> retiradas = retiradasRepository.findAll();
        model.addAttribute("retiradas", retiradas);
        return "retiradas/listar";
    }

     @GetMapping("/novo")
    public String novo(Retiradas Retiradas) {
        return "/retiradas/novo";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable("id") int id) {
        Optional<Retiradas> retiradas = retiradasRepository.findById(id);
        retiradasRepository.delete(retiradas.orElse(null));
        return "redirect:/retiradas/listar";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable("id") int id, Model model) {
        Optional<Retiradas> retiradas = retiradasRepository.findById(id);
        model.addAttribute("retiradas", retiradas.orElse(null));
        return "retiradas/alterar";
    }

    @PostMapping("/salvar")
    public String insere(@Valid Retiradas retiradas, BindingResult result) {
        if(result.hasErrors() == true) {
            if(retiradas.getId() != 0) {
                return "retiradas/alterar";
            } 
            return "retiradas/novo";
        }
        retiradasRepository.save(retiradas);
        return "redirect:/retiradas/listar";
    }
}
