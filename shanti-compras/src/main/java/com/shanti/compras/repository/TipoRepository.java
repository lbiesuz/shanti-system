package com.shanti.compras.repository;

import com.shanti.compras.entity.Tipo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoRepository implements PanacheRepository<Tipo> {
    
    public Tipo findByDescricao(String descricao) {
        return find("descricao", descricao).firstResult();
    }
}