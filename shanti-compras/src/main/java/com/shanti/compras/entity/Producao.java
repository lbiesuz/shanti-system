package com.shanti.compras.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "producoes")
public class Producao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 50)
    private String lote;
    
    @Column
    private LocalDate validadeProduto;
    
    @Column(nullable = false)
    private Integer quantidade;
    
    @ManyToOne
    @JoinColumn(name = "id_insumo", nullable = false)
    private Insumo insumo;
    
    @Column(nullable = false)
    private Long idProduto;  // Referência ao produto no microserviço de Vendas
    
    // Construtores
    public Producao() {}
    
    public Producao(String lote, Integer quantidade, Insumo insumo, Long idProduto) {
        this.lote = lote;
        this.quantidade = quantidade;
        this.insumo = insumo;
        this.idProduto = idProduto;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
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
    
    public Insumo getInsumo() {
        return insumo;
    }
    
    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
    
    public Long getIdProduto() {
        return idProduto;
    }
    
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
}