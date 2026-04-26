package com.example.calculadora_obra.dto;

import java.util.List;
import com.example.calculadora_obra.model.Aresta;

public class TijoloRequest {

    private List<Aresta> arestas;
    private double altura;
    private double comprimentoTijolo;
    private double larguraTijolo;

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

    public double getComprimentoTijolo() {
        return comprimentoTijolo;
    }

    public void setComprimentoTijolo(double comprimentoTijolo) {
        this.comprimentoTijolo = comprimentoTijolo;
    }

    public double getLarguraTijolo() {
        return larguraTijolo;
    }

    public void setLarguraTijolo(double larguraTijolo) {
        this.larguraTijolo = larguraTijolo;
    }
}