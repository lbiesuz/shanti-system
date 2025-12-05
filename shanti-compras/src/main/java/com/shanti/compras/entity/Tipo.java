package com.shanti.compras.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "tipos")
public class Tipo {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    
  @Column(nullable = false, length = 100)
  private String descricao;
    
  @OneToMany(mappedBy = "tipo")
  @JsonIgnore
  private List<Insumo> insumos;
    
  // Construtores
  public Tipo() {}
   
  public Tipo(String descricao) {
    this.descricao = descricao;
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
    
  public List<Insumo> getInsumos() {
    return insumos;
  }
    
  public void setInsumos(List<Insumo> insumos) {
    this.insumos = insumos;
  }
}