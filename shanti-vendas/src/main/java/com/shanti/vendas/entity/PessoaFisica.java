package com.shanti.vendas.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pessoas_fisicas")
public class PessoaFisica extends Cliente {
    
    @Column(length = 11, unique = true)
    private String cpf;
    
    @Column(nullable = false, length = 200)
    private String nome;
    
    @Column
    private LocalDate nascimento;
    
    @Column(length = 20)
    private String genero;
    
    // Construtores
    public PessoaFisica() {}
    
    public PessoaFisica(String nome, String cpf, String telefone, String email) {
        super(telefone, email);
        this.nome = nome;
        this.cpf = cpf;
    }
    
    // Getters e Setters
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public LocalDate getNascimento() {
        return nascimento;
    }
    
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
}