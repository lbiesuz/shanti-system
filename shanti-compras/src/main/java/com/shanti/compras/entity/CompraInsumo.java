package com.shanti.compras.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "compra_insumos")
public class CompraInsumo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Integer quantidade;
    
    @Column
    private LocalDate validadeInsumo;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal custo;
    
    @ManyToOne
    @JoinColumn(name = "id_insumo", nullable = false)
    private Insumo insumo;
    
    @ManyToOne
    @JoinColumn(name = "id_compra", nullable = false)
    private Compra compra;
    
    // Construtores
    public CompraInsumo() {}
    
    public CompraInsumo(Integer quantidade, BigDecimal custo, Insumo insumo, Compra compra) {
        this.quantidade = quantidade;
        this.custo = custo;
        this.insumo = insumo;
        this.compra = compra;
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
    
    public LocalDate getValidadeInsumo() {
        return validadeInsumo;
    }
    
    public void setValidadeInsumo(LocalDate validadeInsumo) {
        this.validadeInsumo = validadeInsumo;
    }
    
    public BigDecimal getCusto() {
        return custo;
    }
    
    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }
    
    public Insumo getInsumo() {
        return insumo;
    }
    
    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
    
    public Compra getCompra() {
        return compra;
    }
    
    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}