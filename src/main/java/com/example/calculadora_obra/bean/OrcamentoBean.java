package com.example.calculadora_obra.bean;

import com.example.calculadora_obra.model.Orcamento;
import com.example.calculadora_obra.repository.OrcamentoRepository;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class OrcamentoBean implements Serializable {

    @Inject
    private transient OrcamentoRepository orcamentoRepository;

    private String numeroBusca;
    private String nomeBusca;
    private List<Orcamento> resultados = new ArrayList<>();
    private String mensagem;

    public void buscarPorNumero() {
        resultados = new ArrayList<>();
        mensagem = null;

        orcamentoRepository.findByNumero(numeroBusca).ifPresentOrElse(
                resultados::add,
                () -> mensagem = "Nenhum orçamento encontrado com esse número."
        );
    }

    public void buscarPorNome() {
        mensagem = null;
        resultados = orcamentoRepository.findByNomeUsuarioContainingIgnoreCase(nomeBusca);

        if (resultados.isEmpty()) {
            mensagem = "Nenhum orçamento encontrado para esse nome.";
        }
    }

    public String getNumeroBusca() { return numeroBusca; }
    public void setNumeroBusca(String numeroBusca) { this.numeroBusca = numeroBusca; }

    public String getNomeBusca() { return nomeBusca; }
    public void setNomeBusca(String nomeBusca) { this.nomeBusca = nomeBusca; }

    public List<Orcamento> getResultados() { return resultados; }

    public String getMensagem() { return mensagem; }
}