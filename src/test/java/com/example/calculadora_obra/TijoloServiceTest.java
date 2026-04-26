package com.example.calculadora_obra;

import com.example.calculadora_obra.model.Aresta;
import com.example.calculadora_obra.service.TijoloService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TijoloServiceTest {

    private final TijoloService service = new TijoloService();

    @Test
    void deveCalcularQuantidadeDeTijolos() {

        Aresta a1 = new Aresta();
        a1.setComprimento(5.0);
        a1.setTemPorta(true);
        a1.setAlturaPorta(2.0);
        a1.setLarguraPorta(0.8);
        a1.setTemJanela(false);

        Aresta a2 = new Aresta();
        a2.setComprimento(4.0);
        a2.setTemPorta(false);
        a2.setTemJanela(true);
        a2.setAlturaJanela(1.0);
        a2.setLarguraJanela(1.2);

        List<Aresta> arestas = List.of(a1, a2);

        double resultado = service.calcularQuantidade(
                arestas,
                3.0,
                0.29,
                0.14
        );

        assertTrue(resultado > 0);
    }
}