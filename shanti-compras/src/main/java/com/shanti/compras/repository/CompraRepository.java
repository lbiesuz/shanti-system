package com.shanti.compras.repository;

import com.shanti.compras.entity.Compra;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class CompraRepository implements PanacheRepository<Compra> {
    
  public List<Compra> findByFornecedor(Long fornecedorId) {
    return list("fornecedor.id", fornecedorId);
  }
    
  public List<Compra> findByPeriodo(LocalDate inicio, LocalDate fim) {
    return list("dataCompra BETWEEN ?1 AND ?2", inicio, fim);
  }
}