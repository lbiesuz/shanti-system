package com.shanti.vendas.service;

import com.shanti.vendas.entity.Categoria;
import com.shanti.vendas.repository.CategoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CategoriaService {
    
    @Inject
    CategoriaRepository categoriaRepository;
    
    public List<Categoria> listarTodas() {
        return categoriaRepository.listAll();
    }
    
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }
    
    @Transactional
    public Categoria criar(Categoria categoria) {
        categoriaRepository.persist(categoria);
        return categoria;
    }
    
    @Transactional
    public Categoria atualizar(Long id, Categoria categoriaAtualizada) {
        Categoria categoria = categoriaRepository.findById(id);
        if (categoria != null) {
            categoria.setDescricao(categoriaAtualizada.getDescricao());
            categoriaRepository.persist(categoria);
        }
        return categoria;
    }
    
    @Transactional
    public boolean deletar(Long id) {
        return categoriaRepository.deleteById(id);
    }
}