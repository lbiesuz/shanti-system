package com.shanti.vendas.repository;

import com.shanti.vendas.entity.Venda;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class VendaRepository implements PanacheRepository<Venda> {
    
    public List<Venda> findByCliente(Long clienteId) {
        return list("cliente.id", clienteId);
    }
    
    public List<Venda> findByPeriodo(LocalDate inicio, LocalDate fim) {
        return list("dataVenda BETWEEN ?1 AND ?2", inicio, fim);
    }
    
    public List<Venda> findByFormaPagamento(String formaPagamento) {
        return list("formaPagamento", formaPagamento);
    }
}