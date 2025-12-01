package com.shanti.vendas.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoas_juridicas")
public class PessoaJuridica extends Cliente {
    
    @Column(length = 14, unique = true)
    private String cnpj;
    
    @Column(length = 100)
    private String contato;
    
    @Column(length = 200)
    private String nomeFantasia;
    
    @Column(length = 200)
    private String razaoSocial;
    
    // Construtores
    public PessoaJuridica() {}
    
    public PessoaJuridica(String nomeFantasia, String cnpj, String telefone, String email) {
        super(telefone, email);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }
    
    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
    
    public String getRazaoSocial() {
        return razaoSocial;
    }
    
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}