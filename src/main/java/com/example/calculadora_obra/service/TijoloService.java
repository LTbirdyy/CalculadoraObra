package com.example.calculadora_obra.service;

import com.example.calculadora_obra.model.Aresta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TijoloService {

    public double calcularQuantidade(List<Aresta> arestas,
                                     double altura,
                                     double comprimentoTijolo,
                                     double larguraTijolo) {

        double areaTijolo = comprimentoTijolo * larguraTijolo;
        double total = 0;

        for (Aresta a : arestas) {

            double areaParede = a.getComprimento() * altura;

            double areaPorta = 0;
            if (a.isTemPorta()) {
                areaPorta = a.getAlturaPorta() * a.getLarguraPorta();
            }

            double areaJanela = 0;
            if (a.isTemJanela()) {
                areaJanela = a.getAlturaJanela() * a.getLarguraJanela();
            }

            double areaLiquida = areaParede - areaPorta - areaJanela;

            total += areaLiquida / areaTijolo;
        }

        return Math.ceil(total);
    }
}