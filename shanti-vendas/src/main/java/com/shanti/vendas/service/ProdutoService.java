package com.shanti.vendas.service;

import com.shanti.vendas.entity.Produto;
import com.shanti.vendas.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProdutoService {
    
    @Inject
    ProdutoRepository produtoRepository;
    
    public List<Produto> listarTodos() {
        return produtoRepository.listAll();
    }
    
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }
    
    public List<Produto> listarPorCategoria(Long categoriaId) {
        return produtoRepository.findByCategoria(categoriaId);
    }
    
    public List<Produto> listarEstoqueBaixo(Integer quantidade) {
        return produtoRepository.findEstoqueBaixo(quantidade);
    }
    
    @Transactional
    public Produto criar(Produto produto) {
        produtoRepository.persist(produto);
        return produto;
    }
    
    @Transactional
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = produtoRepository.findById(id);
        if (produto != null) {
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPrecoAtual(produtoAtualizado.getPrecoAtual());
            produto.setEan(produtoAtualizado.getEan());
            produto.setCategoria(produtoAtualizado.getCategoria());
            produtoRepository.persist(produto);
        }
        return produto;
    }
    
    @Transactional
    public void atualizarEstoque(Long id, Integer quantidade) {
        Produto produto = produtoRepository.findById(id);
        if (produto != null) {
            produto.setEstoqueProduto(produto.getEstoqueProduto() + quantidade);
            produtoRepository.persist(produto);
        }
    }
    
    @Transactional
    public boolean deletar(Long id) {
        return produtoRepository.deleteById(id);
    }
}