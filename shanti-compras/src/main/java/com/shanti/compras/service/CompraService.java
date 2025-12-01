package com.shanti.compras.service;

import com.shanti.compras.entity.Compra;
import com.shanti.compras.entity.CompraInsumo;
import com.shanti.compras.repository.CompraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CompraService {
    
    @Inject
    CompraRepository compraRepository;
    
    @Inject
    InsumoService insumoService;
    
    public List<Compra> listarTodas() {
        return compraRepository.listAll();
    }
    
    public Compra buscarPorId(Long id) {
        return compraRepository.findById(id);
    }
    
    public List<Compra> listarPorFornecedor(Long fornecedorId) {
        return compraRepository.findByFornecedor(fornecedorId);
    }
    
    @Transactional
    public Compra criar(Compra compra) {
        // Persiste a compra
        compraRepository.persist(compra);
        
        // Atualiza o estoque dos insumos
        for (CompraInsumo ci : compra.getCompraInsumos()) {
            ci.setCompra(compra);
            insumoService.atualizarEstoque(ci.getInsumo().getId(), ci.getQuantidade());
        }
        
        return compra;
    }
    
    @Transactional
    public boolean deletar(Long id) {
        return compraRepository.deleteById(id);
    }
}