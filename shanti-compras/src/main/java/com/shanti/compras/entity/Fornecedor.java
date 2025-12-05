package com.shanti.compras.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    
  @Column(length = 15)
  private String telefone;
    
  @Column(length = 100)
  private String email;
    
  @Column(length = 200)
  private String endereco;
    
  @Column(length = 14, unique = true)
  private String cnpj;
    
  @Column(length = 200)
  private String razaoSocial;
   
  @Column(length = 100)
  private String contato;
   
  @Column(length = 200)
  private String nomeFantasia;
   
  @OneToMany(mappedBy = "fornecedor")
  @JsonIgnore
  private List<Compra> compras;
    
  // Construtores
  public Fornecedor() {}
    
  public Fornecedor(String nomeFantasia, String cnpj) {
    this.nomeFantasia = nomeFantasia;
    this.cnpj = cnpj;
  }
    
  // Getters e Setters
  public Long getId() {
    return id;
  }
    
  public void setId(Long id) {
    this.id = id;
  }
    
  public String getTelefone() {
    return telefone;
  }
    
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
    
  public String getEmail() {
    return email;
  }
    
  public void setEmail(String email) {
    this.email = email;
  }
    
  public String getEndereco() {
    return endereco;
  }
    
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
    
  public String getCnpj() {
    return cnpj;
  }
    
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }
    
  public String getRazaoSocial() {
    return razaoSocial;
  }
    
  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }
    
  public String getContato() {
    return contato;
  }
    
  public void setContato(String contato) {
    this.contato = contato;
  }
    
  public String getNomeFantasia() {
    return nomeFantasia;
  }
    
  public void setNomeFantasia(String nomeFantasia) {
    this.nomeFantasia = nomeFantasia;
  }
    
  public List<Compra> getCompras() {
    return compras;
  }
    
  public void setCompras(List<Compra> compras) {
    this.compras = compras;
  }
}