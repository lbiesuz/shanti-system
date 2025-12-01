package com.shanti.vendas.service;

import com.shanti.vendas.entity.Venda;
import com.shanti.vendas.entity.VendaProduto;
import com.shanti.vendas.repository.VendaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class VendaService {
    
    @Inject
    VendaRepository vendaRepository;
    
    @Inject
    ProdutoService produtoService;
    
    public List<Venda> listarTodas() {
        return vendaRepository.listAll();
    }
    
    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id);
    }
    
    public List<Venda> listarPorCliente(Long clienteId) {
        return vendaRepository.findByCliente(clienteId);
    }
    
    @Transactional
    public Venda criar(Venda venda) {
        // Persiste a venda
        vendaRepository.persist(venda);
        
        // Atualiza o estoque dos produtos (desconta)
        for (VendaProduto vp : venda.getVendaProdutos()) {
            vp.setVenda(venda);
            produtoService.atualizarEstoque(vp.getProduto().getId(), -vp.getQuantidade());
        }
        
        return venda;
    }
    
    @Transactional
    public boolean deletar(Long id) {
        return vendaRepository.deleteById(id);
    }
}