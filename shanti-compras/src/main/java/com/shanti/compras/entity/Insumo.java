package com.shanti.compras.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "insumos")
public class Insumo {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    
  @Column(nullable = false, length = 200)
  private String descricao;
    
  @Column(nullable = false)
  private Integer estoqueInsumo = 0;
    
  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal custoAtual;
    
  @Column(length = 13)
  private String ean;
   
  @Column
  private LocalDate validadeMenor;
    
  @ManyToOne
  @JoinColumn(name = "id_tipo", nullable = false)
  private Tipo tipo;
    
  @OneToMany(mappedBy = "insumo")
  @JsonIgnore
  private List<CompraInsumo> compraInsumos;
    
  @OneToMany(mappedBy = "insumo")
  @JsonIgnore
  private List<Producao> producoes;
    
  // Construtores
  public Insumo() {}
    
  public Insumo(String descricao, BigDecimal custoAtual, Tipo tipo) {
    this.descricao = descricao;
    this.custoAtual = custoAtual;
    this.tipo = tipo;
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
    
  public Integer getEstoqueInsumo() {
    return estoqueInsumo;
  }
    
  public void setEstoqueInsumo(Integer estoqueInsumo) {
    this.estoqueInsumo = estoqueInsumo;
  }
    
  public BigDecimal getCustoAtual() {
    return custoAtual;
  }
    
  public void setCustoAtual(BigDecimal custoAtual) {
    this.custoAtual = custoAtual;
  }
    
  public String getEan() {
    return ean;
  }
    
  public void setEan(String ean) {
    this.ean = ean;
  }
    
  public LocalDate getValidadeMenor() {
    return validadeMenor;
  }
    
  public void setValidadeMenor(LocalDate validadeMenor) {
    this.validadeMenor = validadeMenor;
  }
    
  public Tipo getTipo() {
    return tipo;
  }
    
  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }
    
  public List<CompraInsumo> getCompraInsumos() {
    return compraInsumos;
  }
    
  public void setCompraInsumos(List<CompraInsumo> compraInsumos) {
    this.compraInsumos = compraInsumos;
  }
    
  public List<Producao> getProducoes() {
    return producoes;
  }
    
  public void setProducoes(List<Producao> producoes) {
    this.producoes = producoes;
  }
}