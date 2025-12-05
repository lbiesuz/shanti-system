package com.shanti.compras.dto;

import java.math.BigDecimal;

public class ProdutoDTO {
    
  private Long id;
  private String descricao;
  private Integer estoqueProduto;
  private BigDecimal precoAtual;
  private String ean;
  private Long categoriaId;
    
  // Construtores
  public ProdutoDTO() {}
    
  public ProdutoDTO(String descricao, Integer estoqueProduto, BigDecimal precoAtual, String ean, Long categoriaId) {
    this.descricao = descricao;
    this.estoqueProduto = estoqueProduto;
    this.precoAtual = precoAtual;
    this.ean = ean;
    this.categoriaId = categoriaId;
  }
    
  // Getters e Setters
  public Long getId() {
    return id;
  }
    
  public void setId(Long id) {
    this.id = id;
  }
    
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