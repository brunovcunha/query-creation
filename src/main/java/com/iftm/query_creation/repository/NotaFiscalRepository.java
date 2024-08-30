package com.iftm.query_creation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iftm.query_creation.domain.NotaFiscal;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {
    @Query("select n from NotaFiscal n where n.desconto = 0.00")
    List<NotaFiscal> findAllByDescontoInexists();

    @Query("select n from NotaFiscal n where n.desconto != 0.00")
    List<NotaFiscal> findAllByDescontoExists();

    List<NotaFiscal> findAllByOrderByValorUnitDesc();

    @Query("select n from NotaFiscal n where n.quantidade = (select max(nf.quantidade) from NotaFiscal nf) ")
    List<NotaFiscal> findMaxProdInNf();

    List<NotaFiscal> findByQuantidadeGreaterThan(Integer quant);

    @Query("SELECT nf FROM NotaFiscal nf WHERE (nf.valorUnit * nf.quantidade) > 500")
    List<NotaFiscal> findNotasFiscaisComTotalMaiorQue500();

}
