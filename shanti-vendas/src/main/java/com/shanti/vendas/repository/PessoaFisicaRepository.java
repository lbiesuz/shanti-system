package com.shanti.vendas.repository;

import com.shanti.vendas.entity.PessoaFisica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaFisicaRepository implements PanacheRepository<PessoaFisica> {
    
    public PessoaFisica findByCpf(String cpf) {
        return find("cpf", cpf).firstResult();
    }
}