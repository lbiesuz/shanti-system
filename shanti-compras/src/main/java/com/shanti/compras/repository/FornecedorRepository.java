package com.shanti.compras.repository;

import com.shanti.compras.entity.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor> {
    
    public Fornecedor findByCnpj(String cnpj) {
        return find("cnpj", cnpj).firstResult();
    }
}