package com.example.calculadora_obra.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Comodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double largura;
    private double comprimento;
    private double altura;

    @ManyToMany
    private List<Aresta> paredes;

    // getters/setters
}