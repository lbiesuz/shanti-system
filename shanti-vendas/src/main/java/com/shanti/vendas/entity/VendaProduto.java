package com.shanti.vendas.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "venda_produtos")
public class VendaProduto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Integer quantidade;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;
    
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name = "id_venda", nullable = false)
    private Venda venda;
    
    // Construtores
    public VendaProduto() {}
    
    public VendaProduto(Integer quantidade, BigDecimal preco, Produto produto, Venda venda) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
        this.venda = venda;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public BigDecimal getPreco() {
        return preco;
    }
    
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    
    public Produto getProduto() {
        return produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public Venda getVenda() {
        return venda;
    }
    
    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}