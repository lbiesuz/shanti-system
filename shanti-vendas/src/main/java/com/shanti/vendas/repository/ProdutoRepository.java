package com.shanti.vendas.repository;

import com.shanti.vendas.entity.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {
    
    public List<Produto> findByCategoria(Long categoriaId) {
        return list("categoria.id", categoriaId);
    }
    
    public List<Produto> findEstoqueBaixo(Integer quantidade) {
        return list("estoqueProduto < ?1", quantidade);
    }
    
    public Produto findByEan(String ean) {
        return find("ean", ean).firstResult();
    }
}