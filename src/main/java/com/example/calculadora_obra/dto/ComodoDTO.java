package com.example.calculadora_obra.dto;

import java.util.ArrayList;
import java.util.List;

public class ComodoDTO {

    private String nome;
    private double largura;
    private double comprimento;
    private double altura = 2.8; // pé-direito padrão

    private List<ParedeDTO> paredes = new ArrayList<>();

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getLargura() { return largura; }
    public void setLargura(double largura) { this.largura = largura; }

    public double getComprimento() { return comprimento; }
    public void setComprimento(double comprimento) { this.comprimento = comprimento; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public List<ParedeDTO> getParedes() { return paredes; }
    public void setParedes(List<ParedeDTO> paredes) { this.paredes = paredes; }
}