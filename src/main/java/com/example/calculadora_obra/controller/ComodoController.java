package com.example.calculadora_obra.controller;

import com.example.calculadora_obra.model.Comodo;
import com.example.calculadora_obra.repository.ComodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comodos")
public class ComodoController {

    private final ComodoRepository repository;

    public ComodoController(ComodoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Comodo criar(@RequestBody Comodo c) {
        return repository.save(c);
    }

    @GetMapping
    public List<Comodo> listar() {
        return repository.findAll();
    }
}