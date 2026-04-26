package com.example.calculadora_obra.controller;

import com.example.calculadora_obra.model.Vertice;
import com.example.calculadora_obra.repository.ParedeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vertices")
public class ParedeController {

    private final ParedeRepository repository;

    public ParedeController(ParedeRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Vertice criar(@RequestBody Vertice p) {
        return repository.save(p);
    }

    @GetMapping
    public List<Vertice> listar() {
        return repository.findAll();
    }
}