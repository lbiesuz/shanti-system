package com.shanti.vendas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produtos")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 200)
    private String descricao;
    
    @Column(nullable = false)
    private Integer estoqueProduto = 0;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precoAtual;
    
    @Column(length = 13)
    private String ean;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
    
    @OneToMany(mappedBy = "produto")
    @JsonIgnore
    private List<VendaProduto> vendaProdutos;
    
    // Construtores
    public Produto() {}
    
    public Produto(String descricao, BigDecimal precoAtual, Categoria categoria) {
        this.descricao = descricao;
        this.precoAtual = precoAtual;
        this.categoria = categoria;
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
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public List<VendaProduto> getVendaProdutos() {
        return vendaProdutos;
    }
    
    public void setVendaProdutos(List<VendaProduto> vendaProdutos) {
        this.vendaProdutos = vendaProdutos;
    }
}