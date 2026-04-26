package com.example.calculadora_obra.dto;

public class ConcretoResponse {
    private double volumeTotal;

    public ConcretoResponse(double volumeTotal) {
        this.volumeTotal = volumeTotal;
    }

    public double getVolumeTotal() {
        return volumeTotal;
    }
}