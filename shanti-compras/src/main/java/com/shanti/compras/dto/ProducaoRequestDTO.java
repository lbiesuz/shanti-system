package com.shanti.compras.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProducaoRequestDTO {
    
    private String lote;
    private LocalDate validadeProduto;
    private Integer quantidade;
    private Long insumoId;
    
    // Informações do produto (se for criar novo)
    private String descricaoProduto;
    private BigDecimal precoProduto;
    private String eanProduto;
    private Long categoriaId;
    private Long idProduto; // Se já existe
    
    // Construtores
    public ProducaoRequestDTO() {}
    
    // Getters e Setters
    public String getLote() {
        return lote;
    }
    
    public void setLote(String lote) {
        this.lote = lote;
    }
    
    public LocalDate getValidadeProduto() {
        return validadeProduto;
    }
    
    public void setValidadeProduto(LocalDate validadeProduto) {
        this.validadeProduto = validadeProduto;
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public Long getInsumoId() {
        return insumoId;
    }
    
    public void setInsumoId(Long insumoId) {
        this.insumoId = insumoId;
    }
    
    public String getDescricaoProduto() {
        return descricaoProduto;
    }
    
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
    
    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }
    
    public void setPrecoProduto(BigDecimal precoProduto) {
        this.precoProduto = precoProduto;
    }
    
    public String getEanProduto() {
        return eanProduto;
    }
    
    public void setEanProduto(String eanProduto) {
        this.eanProduto = eanProduto;
    }
    
    public Long getCategoriaId() {
        return categoriaId;
    }
    
    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
    
    public Long getIdProduto() {
        return idProduto;
    }
    
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
}