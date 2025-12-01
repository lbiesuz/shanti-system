package com.shanti.vendas.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendas")
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private LocalDate dataVenda;
    
    @Column(length = 50)
    private String formaPagamento;
    
    @Column(length = 50)
    private String notaFiscal;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal custoFrete = BigDecimal.ZERO;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendaProduto> vendaProdutos = new ArrayList<>();
    
    // Construtores
    public Venda() {}
    
    public Venda(LocalDate dataVenda, Cliente cliente) {
        this.dataVenda = dataVenda;
        this.cliente = cliente;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDate getDataVenda() {
        return dataVenda;
    }
    
    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    public String getFormaPagamento() {
        return formaPagamento;
    }
    
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public String getNotaFiscal() {
        return notaFiscal;
    }
    
    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
    
    public BigDecimal getCustoFrete() {
        return custoFrete;
    }
    
    public void setCustoFrete(BigDecimal custoFrete) {
        this.custoFrete = custoFrete;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<VendaProduto> getVendaProdutos() {
        return vendaProdutos;
    }
    
    public void setVendaProdutos(List<VendaProduto> vendaProdutos) {
        this.vendaProdutos = vendaProdutos;
    }
}