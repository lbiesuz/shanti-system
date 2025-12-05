package com.shanti.compras.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    
  @Column(nullable = false)
  private LocalDate dataCompra;
    
  @Column(length = 50)
  private String notaFiscal;
    
  @Column(length = 50)
  private String formaPagamento;
    
  @Column(precision = 10, scale = 2)
  private BigDecimal custoFrete = BigDecimal.ZERO;
    
  @ManyToOne
  @JoinColumn(name = "id_fornecedor", nullable = false)
  private Fornecedor fornecedor;
    
  @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CompraInsumo> compraInsumos = new ArrayList<>();
    
  // Construtores
  public Compra() {}
    
  public Compra(LocalDate dataCompra, Fornecedor fornecedor) {
    this.dataCompra = dataCompra;
    this.fornecedor = fornecedor;
  }
    
  // Getters e Setters
  public Long getId() {
    return id;
  }
    
  public void setId(Long id) {
    this.id = id;
  }
    
  public LocalDate getDataCompra() {
    return dataCompra;
  }
    
  public void setDataCompra(LocalDate dataCompra) {
    this.dataCompra = dataCompra;
  }
    
  public String getNotaFiscal() {
    return notaFiscal;
  }
    
  public void setNotaFiscal(String notaFiscal) {
    this.notaFiscal = notaFiscal;
  }
    
  public String getFormaPagamento() {
    return formaPagamento;
  }
    
  public void setFormaPagamento(String formaPagamento) {
    this.formaPagamento = formaPagamento;
  }
    
  public BigDecimal getCustoFrete() {
    return custoFrete;
  }
    
  public void setCustoFrete(BigDecimal custoFrete) {
    this.custoFrete = custoFrete;
  }
    
  public Fornecedor getFornecedor() {
    return fornecedor;
  }
    
  public void setFornecedor(Fornecedor fornecedor) {
    this.fornecedor = fornecedor;
  }
    
  public List<CompraInsumo> getCompraInsumos() {
    return compraInsumos;
  }
    
  public void setCompraInsumos(List<CompraInsumo> compraInsumos) {
    this.compraInsumos = compraInsumos;
  }
}