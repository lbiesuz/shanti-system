package com.shanti.vendas.service;

import com.shanti.vendas.entity.Cliente;
import com.shanti.vendas.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ClienteService {
    
    @Inject
    ClienteRepository clienteRepository;
    
    public List<Cliente> listarTodos() {
        return clienteRepository.listAll();
    }
    
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }
    
    public Cliente buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
    
    @Transactional
    public Cliente criar(Cliente cliente) {
        clienteRepository.persist(cliente);
        return cliente;
    }
    
    @Transactional
    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente cliente = clienteRepository.findById(id);
        if (cliente != null) {
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setEmail(clienteAtualizado.getEmail());
            clienteRepository.persist(cliente);
        }
        return cliente;
    }
    
    @Transactional
    public boolean deletar(Long id) {
        return clienteRepository.deleteById(id);
    }
}