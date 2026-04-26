package com.example.calculadora_obra.repository;

import com.example.calculadora_obra.model.Vertice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParedeRepository extends JpaRepository<Vertice, Long> {
}