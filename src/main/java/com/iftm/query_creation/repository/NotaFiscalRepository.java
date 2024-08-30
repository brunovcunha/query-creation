package com.iftm.query_creation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iftm.query_creation.domain.NotaFiscal;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {
    // Aqui você pode adicionar métodos customizados, se necessário
}

