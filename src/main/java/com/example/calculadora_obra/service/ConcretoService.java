package com.example.calculadora_obra.service;

import com.example.calculadora_obra.model.Aresta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcretoService {

    public double calcularVolume(List<Aresta> arestas, double alturaViga) {

        double total = 0;

        for (Aresta a : arestas) {

            double comprimento = a.getComprimento();
            double larguraViga = a.getEspessura(); // L
            double altura = alturaViga; // A

            double volume = comprimento * altura * larguraViga;

            total += volume;
        }

        return total;
    }
}