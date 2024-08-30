package com.iftm.query_creation.DTO;

import com.iftm.query_creation.domain.NotaFiscal;

/**
 * NotaFiscalDTO
 */
public class NotaFiscalDTO {

    private Long id;
    private Long idNf;
    private Long idItem;
    private Integer codProd;
    private Double valorUnit;
    private Integer quantidade;
    private Double desconto;

    // Construtores
    public NotaFiscalDTO() {}

    public NotaFiscalDTO(Long id, Long idNf, Long idItem, Integer codProd, Double valorUnit, Integer quantidade, Double desconto) {
        this.id = id;
        this.idNf = idNf;
        this.idItem = idItem;
        this.codProd = codProd;
        this.valorUnit = valorUnit;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public NotaFiscalDTO(NotaFiscal notaFiscal) {
        this.id = notaFiscal.getId();
        this.idNf = notaFiscal.getIdNf();
        this.idItem = notaFiscal.getIdItem();
        this.codProd = notaFiscal.getCodProd();
        this.valorUnit = notaFiscal.getValorUnit();
        this.quantidade = notaFiscal.getQuantidade();
        this.desconto = notaFiscal.getDesconto();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdNf() {
        return idNf;
    }

    public void setIdNf(Long idNf) {
        this.idNf = idNf;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Integer getCodProd() {
        return codProd;
    }

    public void setCodProd(Integer codProd) {
        this.codProd = codProd;
    }

    public Double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Double valorUnit) {
        this.valorUnit = valorUnit;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "NotaFiscalDTO{" +
                "id=" + id +
                ", idNf=" + idNf +
                ", idItem=" + idItem +
                ", codProd=" + codProd +
                ", valorUnit=" + valorUnit +
                ", quantidade=" + quantidade +
                ", desconto=" + desconto +
                '}';
    }
}
