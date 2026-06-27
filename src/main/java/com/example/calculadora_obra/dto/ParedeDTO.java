package com.example.calculadora_obra.dto;

public class ParedeDTO {

    private double comprimento;
    private double espessura = 0.15; // valor padrão de parede

    private boolean temPorta;
    private double alturaPorta;
    private double larguraPorta;

    private boolean temJanela;
    private double alturaJanela;
    private double larguraJanela;

    public double getComprimento() { return comprimento; }
    public void setComprimento(double comprimento) { this.comprimento = comprimento; }

    public double getEspessura() { return espessura; }
    public void setEspessura(double espessura) { this.espessura = espessura; }

    public boolean isTemPorta() { return temPorta; }
    public void setTemPorta(boolean temPorta) { this.temPorta = temPorta; }

    public double getAlturaPorta() { return alturaPorta; }
    public void setAlturaPorta(double alturaPorta) { this.alturaPorta = alturaPorta; }

    public double getLarguraPorta() { return larguraPorta; }
    public void setLarguraPorta(double larguraPorta) { this.larguraPorta = larguraPorta; }

    public boolean isTemJanela() { return temJanela; }
    public void setTemJanela(boolean temJanela) { this.temJanela = temJanela; }

    public double getAlturaJanela() { return alturaJanela; }
    public void setAlturaJanela(double alturaJanela) { this.alturaJanela = alturaJanela; }

    public double getLarguraJanela() { return larguraJanela; }
    public void setLarguraJanela(double larguraJanela) { this.larguraJanela = larguraJanela; }
}