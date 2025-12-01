package com.shanti.compras.service;

import com.shanti.compras.entity.Insumo;
import com.shanti.compras.repository.InsumoRepository;
import com.shanti.compras.repository.TipoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class InsumoService {
    
    @Inject
    InsumoRepository insumoRepository;
    
    @Inject
    TipoRepository tipoRepository;
    
    public List<Insumo> listarTodos() {
        return insumoRepository.listAll();
    }
    
    public Insumo buscarPorId(Long id) {
        return insumoRepository.findById(id);
    }
    
    public List<Insumo> listarPorTipo(Long tipoId) {
        return insumoRepository.findByTipo(tipoId);
    }
    
    public List<Insumo> listarEstoqueBaixo(Integer quantidade) {
        return insumoRepository.findEstoqueBaixo(quantidade);
    }
    
    @Transactional
    public Insumo criar(Insumo insumo) {
        insumoRepository.persist(insumo);
        return insumo;
    }
    
    @Transactional
    public Insumo atualizar(Long id, Insumo insumoAtualizado) {
        Insumo insumo = insumoRepository.findById(id);
        if (insumo != null) {
            insumo.setDescricao(insumoAtualizado.getDescricao());
            insumo.setCustoAtual(insumoAtualizado.getCustoAtual());
            insumo.setEan(insumoAtualizado.getEan());
            insumo.setTipo(insumoAtualizado.getTipo());
            insumoRepository.persist(insumo);
        }
        return insumo;
    }
    
    @Transactional
    public void atualizarEstoque(Long id, Integer quantidade) {
        Insumo insumo = insumoRepository.findById(id);
        if (insumo != null) {
            insumo.setEstoqueInsumo(insumo.getEstoqueInsumo() + quantidade);
            insumoRepository.persist(insumo);
        }
    }
    
    @Transactional
    public boolean deletar(Long id) {
        return insumoRepository.deleteById(id);
    }
}