package com.example.calculadora_obra.controller;

import com.example.calculadora_obra.dto.TijoloRequest;
import com.example.calculadora_obra.dto.TijoloResponse;
import com.example.calculadora_obra.service.TijoloService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tijolos")
public class TijoloController {

    private final TijoloService service;

    public TijoloController(TijoloService service) {
        this.service = service;
    }

    @PostMapping
    public TijoloResponse calcular(@RequestBody TijoloRequest request) {

        double total = service.calcularQuantidade(
                request.getArestas(),
                request.getAltura(),
                request.getComprimentoTijolo(),
                request.getLarguraTijolo()
        );

        return new TijoloResponse(total);
    }
}