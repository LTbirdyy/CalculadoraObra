package com.example.calculadora_obra.controller;

import com.example.calculadora_obra.model.Aresta;
import com.example.calculadora_obra.repository.PilarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arestas")
public class PilarController {

    private final PilarRepository repository;

    public PilarController(PilarRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Aresta criar(@RequestBody Aresta p) {
        return repository.save(p);
    }

    @GetMapping
    public List<Aresta> listar() {
        return repository.findAll();
    }
}