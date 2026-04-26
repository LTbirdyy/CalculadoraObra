package com.example.calculadora_obra.dto;

import java.util.List;
import com.example.calculadora_obra.model.Aresta;

public class ConcretoRequest {
    private List<Aresta> arestas;
    private double altura;

    // getters e setters


    public List<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}