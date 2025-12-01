package com.shanti.vendas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo")
@JsonSubTypes({
    @JsonSubTypes.Type(value = PessoaFisica.class, name = "fisica"),
    @JsonSubTypes.Type(value = PessoaJuridica.class, name = "juridica")
})
public abstract class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 15)
    private String telefone;
    
    @Column(length = 100)
    private String email;
    
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Venda> vendas;
    
    // Construtores
    public Cliente() {}
    
    public Cliente(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
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
    
    public List<Venda> getVendas() {
        return vendas;
    }
    
    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
}