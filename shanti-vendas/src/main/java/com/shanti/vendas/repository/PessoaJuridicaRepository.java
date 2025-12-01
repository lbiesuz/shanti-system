package com.shanti.vendas.repository;

import com.shanti.vendas.entity.PessoaJuridica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaJuridicaRepository implements PanacheRepository<PessoaJuridica> {
    
    public PessoaJuridica findByCnpj(String cnpj) {
        return find("cnpj", cnpj).firstResult();
    }
}