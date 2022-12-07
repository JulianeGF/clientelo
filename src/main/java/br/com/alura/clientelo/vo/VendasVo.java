package br.com.alura.clientelo.vo;

import java.math.BigDecimal;

public class VendasVo {

    private String nomeDaCategoria;
    private Long quantidade;
    private BigDecimal montante;

    public VendasVo(String nomeDaCategoria, Long quantidade, BigDecimal montante) {
        this.nomeDaCategoria = nomeDaCategoria;
        this.quantidade = quantidade;
        this.montante = montante;
    }

    public String getNomeDaCategoria() {
        return nomeDaCategoria;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public BigDecimal getMontante() {
        return montante;
    }
}
