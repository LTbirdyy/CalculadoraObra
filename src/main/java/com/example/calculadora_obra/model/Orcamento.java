package com.example.calculadora_obra.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numero;

    private String nomeUsuario;
    private LocalDateTime dataCriacao;

    private double areaTotal;
    private double volumeConcreto;
    private double quantidadeTijolos;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    public double getAreaTotal() { return areaTotal; }
    public void setAreaTotal(double areaTotal) { this.areaTotal = areaTotal; }

    public double getVolumeConcreto() { return volumeConcreto; }
    public void setVolumeConcreto(double volumeConcreto) { this.volumeConcreto = volumeConcreto; }

    public double getQuantidadeTijolos() { return quantidadeTijolos; }
    public void setQuantidadeTijolos(double quantidadeTijolos) { this.quantidadeTijolos = quantidadeTijolos; }
}