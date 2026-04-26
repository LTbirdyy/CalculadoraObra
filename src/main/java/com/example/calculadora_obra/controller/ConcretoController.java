package com.example.calculadora_obra.controller;

import com.example.calculadora_obra.dto.ConcretoRequest;
import com.example.calculadora_obra.dto.ConcretoResponse;
import org.springframework.web.bind.annotation.*;
import com.example.calculadora_obra.service.ConcretoService;

@RestController
@RequestMapping("/Volume")
public class ConcretoController {

    private final ConcretoService service;

    public ConcretoController(ConcretoService service) {
        this.service = service;
    }

    @PostMapping
    public ConcretoResponse calcular(@RequestBody ConcretoRequest request) {
        double volume = service.calcularVolume(
                request.getArestas(),
                request.getAltura()
        );

        return new ConcretoResponse(volume);
    }
}