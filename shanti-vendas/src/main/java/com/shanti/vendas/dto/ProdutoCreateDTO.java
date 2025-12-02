package com.shanti.vendas.dto;

import java.math.BigDecimal;

public class ProdutoCreateDTO {
    
    private String descricao;
    private Integer estoqueProduto;
    private BigDecimal precoAtual;
    private String ean;
    private Long categoriaId;
    
    // Construtores
    public ProdutoCreateDTO() {}
    
    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getEstoqueProduto() {
        return estoqueProduto;
    }
    
    public void setEstoqueProduto(Integer estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
    }
    
    public BigDecimal getPrecoAtual() {
        return precoAtual;
    }
    
    public void setPrecoAtual(BigDecimal precoAtual) {
        this.precoAtual = precoAtual;
    }
    
    public String getEan() {
        return ean;
    }
    
    public void setEan(String ean) {
        this.ean = ean;
    }
    
    public Long getCategoriaId() {
        return categoriaId;
    }
    
    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}