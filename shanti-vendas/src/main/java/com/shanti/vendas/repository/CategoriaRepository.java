package com.shanti.vendas.repository;

import com.shanti.vendas.entity.Categoria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepository<Categoria> {
    
    public Categoria findByDescricao(String descricao) {
        return find("descricao", descricao).firstResult();
    }
}