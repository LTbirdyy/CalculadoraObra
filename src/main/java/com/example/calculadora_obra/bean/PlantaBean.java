package com.example.calculadora_obra.bean;

import com.example.calculadora_obra.dto.ComodoDTO;
import com.example.calculadora_obra.dto.ParedeDTO;
import com.example.calculadora_obra.model.Aresta;
import com.example.calculadora_obra.model.Orcamento;
import com.example.calculadora_obra.repository.OrcamentoRepository;
import com.example.calculadora_obra.service.ConcretoService;
import com.example.calculadora_obra.service.TijoloService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Named
@ViewScoped
public class PlantaBean implements Serializable {

    @Inject
    private transient ConcretoService concretoService;

    @Inject
    private transient TijoloService tijoloService;

    @Inject
    private transient OrcamentoRepository orcamentoRepository;

    private ComodoDTO comodo = new ComodoDTO();
    private ParedeDTO parede = new ParedeDTO();
    private List<ComodoDTO> comodos = new ArrayList<>();

    private String nomeUsuario;
    private double comprimentoTijolo = 0.19;
    private double larguraTijolo = 0.09;

    // resultado
    private double areaTotal;
    private double volumeConcreto;
    private double quantidadeTijolos;
    private String numeroOrcamento;
    private boolean calculado;

    @PostConstruct
    public void init() {
        comodo = new ComodoDTO();
    }

    // ➕ adicionar parede ao cômodo atual
    public void adicionarParede() {
        comodo.getParedes().add(parede);
        parede = new ParedeDTO();
    }

    // ➕ adicionar cômodo (com suas paredes) à lista
    public void adicionarComodo() {
        comodos.add(comodo);
        comodo = new ComodoDTO();
    }

    // 🧮 cálculo final, chamando os services de verdade
    public void calcular() {
        areaTotal = 0;
        volumeConcreto = 0;
        quantidadeTijolos = 0;

        for (ComodoDTO c : comodos) {
            areaTotal += c.getLargura() * c.getComprimento();

            List<Aresta> arestas = new ArrayList<>();
            for (ParedeDTO p : c.getParedes()) {
                Aresta a = new Aresta();
                a.setComprimento(p.getComprimento());
                a.setEspessura(p.getEspessura());
                a.setTemPorta(p.isTemPorta());
                a.setAlturaPorta(p.getAlturaPorta());
                a.setLarguraPorta(p.getLarguraPorta());
                a.setTemJanela(p.isTemJanela());
                a.setAlturaJanela(p.getAlturaJanela());
                a.setLarguraJanela(p.getLarguraJanela());
                arestas.add(a);
            }

            volumeConcreto += concretoService.calcularVolume(arestas, c.getAltura());
            quantidadeTijolos += tijoloService.calcularQuantidade(
                    arestas, c.getAltura(), comprimentoTijolo, larguraTijolo);
        }

        // salva o orçamento
        Orcamento orcamento = new Orcamento();
        orcamento.setNumero(UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        orcamento.setNomeUsuario(nomeUsuario);
        orcamento.setDataCriacao(LocalDateTime.now());
        orcamento.setAreaTotal(areaTotal);
        orcamento.setVolumeConcreto(volumeConcreto);
        orcamento.setQuantidadeTijolos(quantidadeTijolos);
        orcamentoRepository.save(orcamento);

        numeroOrcamento = orcamento.getNumero();
        calculado = true;
    }

    // getters e setters

    public ComodoDTO getComodo() { return comodo; }
    public void setComodo(ComodoDTO comodo) { this.comodo = comodo; }

    public ParedeDTO getParede() { return parede; }
    public void setParede(ParedeDTO parede) { this.parede = parede; }

    public List<ComodoDTO> getComodos() { return comodos; }
    public void setComodos(List<ComodoDTO> comodos) { this.comodos = comodos; }

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

    public double getComprimentoTijolo() { return comprimentoTijolo; }
    public void setComprimentoTijolo(double comprimentoTijolo) { this.comprimentoTijolo = comprimentoTijolo; }

    public double getLarguraTijolo() { return larguraTijolo; }
    public void setLarguraTijolo(double larguraTijolo) { this.larguraTijolo = larguraTijolo; }

    public double getAreaTotal() { return areaTotal; }
    public double getVolumeConcreto() { return volumeConcreto; }
    public double getQuantidadeTijolos() { return quantidadeTijolos; }
    public String getNumeroOrcamento() { return numeroOrcamento; }
    public boolean isCalculado() { return calculado; }
}