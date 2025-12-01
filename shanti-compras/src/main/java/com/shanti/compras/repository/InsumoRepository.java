package com.shanti.compras.repository;

import com.shanti.compras.entity.Insumo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class InsumoRepository implements PanacheRepository<Insumo> {
    
    public List<Insumo> findByTipo(Long tipoId) {
        return list("tipo.id", tipoId);
    }
    
    public List<Insumo> findEstoqueBaixo(Integer quantidade) {
        return list("estoqueInsumo < ?1", quantidade);
    }
}