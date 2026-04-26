package com.example.calculadora_obra.model;

import jakarta.persistence.*;

@Entity
public class Aresta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double comprimento;
    private double espessura;

    private boolean temPorta;
    private double alturaPorta;
    private double larguraPorta;

    private boolean temJanela;
    private double alturaJanela;
    private double larguraJanela;

    @ManyToOne
    private Vertice inicio;

    @ManyToOne
    private Vertice fim;

    // getters/setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getEspessura() {
        return espessura;
    }

    public void setEspessura(double espessura) {
        this.espessura = espessura;
    }

    public boolean isTemPorta() {
        return temPorta;
    }

    public void setTemPorta(boolean temPorta) {
        this.temPorta = temPorta;
    }

    public double getAlturaPorta() {
        return alturaPorta;
    }

    public void setAlturaPorta(double alturaPorta) {
        this.alturaPorta = alturaPorta;
    }

    public double getLarguraPorta() {
        return larguraPorta;
    }

    public void setLarguraPorta(double larguraPorta) {
        this.larguraPorta = larguraPorta;
    }

    public boolean isTemJanela() {
        return temJanela;
    }

    public void setTemJanela(boolean temJanela) {
        this.temJanela = temJanela;
    }

    public double getAlturaJanela() {
        return alturaJanela;
    }

    public void setAlturaJanela(double alturaJanela) {
        this.alturaJanela = alturaJanela;
    }

    public double getLarguraJanela() {
        return larguraJanela;
    }

    public void setLarguraJanela(double larguraJanela) {
        this.larguraJanela = larguraJanela;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public Vertice getFim() {
        return fim;
    }

    public void setFim(Vertice fim) {
        this.fim = fim;
    }


}