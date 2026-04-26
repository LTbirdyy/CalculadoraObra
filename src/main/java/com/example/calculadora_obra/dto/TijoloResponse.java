package com.example.calculadora_obra.dto;

public class TijoloResponse {

    private double quantidadeTotal;

    public TijoloResponse(double quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public double getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(double quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }
}