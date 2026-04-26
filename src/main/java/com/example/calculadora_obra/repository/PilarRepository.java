package com.example.calculadora_obra.repository;

import com.example.calculadora_obra.model.Aresta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilarRepository extends JpaRepository<Aresta, Long> {
}