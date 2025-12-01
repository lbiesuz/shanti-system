package com.shanti.compras.repository;

import com.shanti.compras.entity.Producao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProducaoRepository implements PanacheRepository<Producao> {
    
    public List<Producao> findByProduto(Long idProduto) {
        return list("idProduto", idProduto);
    }
    
    public List<Producao> findByLote(String lote) {
        return list("lote", lote);
    }
}