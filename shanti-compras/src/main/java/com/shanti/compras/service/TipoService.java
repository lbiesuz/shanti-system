package com.shanti.compras.service;

import com.shanti.compras.entity.Tipo;
import com.shanti.compras.repository.TipoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TipoService {
    
    @Inject
    TipoRepository tipoRepository;
    
    public List<Tipo> listarTodos() {
        return tipoRepository.listAll();
    }
    
    public Tipo buscarPorId(Long id) {
        return tipoRepository.findById(id);
    }
    
    @Transactional
    public Tipo criar(Tipo tipo) {
        tipoRepository.persist(tipo);
        return tipo;
    }
    
    @Transactional
    public Tipo atualizar(Long id, Tipo tipoAtualizado) {
        Tipo tipo = tipoRepository.findById(id);
        if (tipo != null) {
            tipo.setDescricao(tipoAtualizado.getDescricao());
            tipoRepository.persist(tipo);
        }
        return tipo;
    }
    
    @Transactional
    public boolean deletar(Long id) {
        return tipoRepository.deleteById(id);
    }
}