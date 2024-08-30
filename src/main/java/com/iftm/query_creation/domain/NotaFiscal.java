package com.iftm.query_creation.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_nf")
    private Long idNf;

    @Column(name = "id_item")
    private Long idItem;

    @Column(name = "cod_prod")
    private Integer codProd;

    @Column(name = "valor_unit")
    private Double valorUnit;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "desconto")
    private Double desconto;

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
        return "NotaFiscal{" +
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