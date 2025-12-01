package com.shanti.compras.service;

import com.shanti.compras.entity.Producao;
import com.shanti.compras.repository.ProducaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProducaoService {
    
    @Inject
    ProducaoRepository producaoRepository;
    
    @Inject
    InsumoService insumoService;
    
    public List<Producao> listarTodas() {
        return producaoRepository.listAll();
    }
    
    public Producao buscarPorId(Long id) {
        return producaoRepository.findById(id);
    }
    
    public List<Producao> listarPorProduto(Long idProduto) {
        return producaoRepository.findByProduto(idProduto);
    }
    
    @Transactional
    public Producao criar(Producao producao) {
        // Desconta o insumo do estoque
        insumoService.atualizarEstoque(
            producao.getInsumo().getId(), 
            -producao.getQuantidade()
        );
        
        // Persiste a produção
        producaoRepository.persist(producao);
        return producao;
    }
    
    @Transactional
    public boolean deletar(Long id) {
        return producaoRepository.deleteById(id);
    }
}