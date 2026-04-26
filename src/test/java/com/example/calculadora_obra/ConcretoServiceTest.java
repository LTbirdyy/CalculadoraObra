package com.example.calculadora_obra;

import com.example.calculadora_obra.model.Aresta;
import com.example.calculadora_obra.service.ConcretoService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConcretoServiceTest {

    private final ConcretoService service = new ConcretoService();

    @Test
    void deveCalcularVolumeDeConcreto() {

        Aresta a1 = new Aresta();
        a1.setComprimento(5.0);
        a1.setEspessura(0.2);

        Aresta a2 = new Aresta();
        a2.setComprimento(4.0);
        a2.setEspessura(0.2);

        List<Aresta> arestas = List.of(a1, a2);

        double resultado = service.calcularVolume(
                arestas,
                0.3
        );

        assertTrue(resultado > 0);
    }
}