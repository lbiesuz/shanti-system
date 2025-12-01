package com.shanti.compras.service;

import com.shanti.compras.entity.Fornecedor;
import com.shanti.compras.repository.FornecedorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FornecedorService {
    
    @Inject
    FornecedorRepository fornecedorRepository;
    
    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.listAll();
    }
    
    public Fornecedor buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }
    
    public Fornecedor buscarPorCnpj(String cnpj) {
        return fornecedorRepository.findByCnpj(cnpj);
    }
    
    @Transactional
    public Fornecedor criar(Fornecedor fornecedor) {
        fornecedorRepository.persist(fornecedor);
        return fornecedor;
    }
    
    @Transactional
    public Fornecedor atualizar(Long id, Fornecedor fornecedorAtualizado) {
        Fornecedor fornecedor = fornecedorRepository.findById(id);
        if (fornecedor != null) {
            fornecedor.setNomeFantasia(fornecedorAtualizado.getNomeFantasia());
            fornecedor.setRazaoSocial(fornecedorAtualizado.getRazaoSocial());
            fornecedor.setCnpj(fornecedorAtualizado.getCnpj());
            fornecedor.setTelefone(fornecedorAtualizado.getTelefone());
            fornecedor.setEmail(fornecedorAtualizado.getEmail());
            fornecedor.setEndereco(fornecedorAtualizado.getEndereco());
            fornecedor.setContato(fornecedorAtualizado.getContato());
            fornecedorRepository.persist(fornecedor);
        }
        return fornecedor;
    }
    
    @Transactional
    public boolean deletar(Long id) {
        return fornecedorRepository.deleteById(id);
    }
}