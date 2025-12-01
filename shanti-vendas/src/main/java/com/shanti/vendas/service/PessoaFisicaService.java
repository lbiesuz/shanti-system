package com.shanti.vendas.service;

import com.shanti.vendas.entity.PessoaFisica;
import com.shanti.vendas.repository.PessoaFisicaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PessoaFisicaService {
    
    @Inject
    PessoaFisicaRepository pessoaFisicaRepository;
    
    public List<PessoaFisica> listarTodas() {
        return pessoaFisicaRepository.listAll();
    }
    
    public PessoaFisica buscarPorId(Long id) {
        return pessoaFisicaRepository.findById(id);
    }
    
    public PessoaFisica buscarPorCpf(String cpf) {
        return pessoaFisicaRepository.findByCpf(cpf);
    }
    
    @Transactional
    public PessoaFisica criar(PessoaFisica pessoaFisica) {
        pessoaFisicaRepository.persist(pessoaFisica);
        return pessoaFisica;
    }
    
    @Transactional
    public PessoaFisica atualizar(Long id, PessoaFisica pessoaAtualizada) {
        PessoaFisica pessoa = pessoaFisicaRepository.findById(id);
        if (pessoa != null) {
            pessoa.setNome(pessoaAtualizada.getNome());
            pessoa.setCpf(pessoaAtualizada.getCpf());
            pessoa.setTelefone(pessoaAtualizada.getTelefone());
            pessoa.setEmail(pessoaAtualizada.getEmail());
            pessoa.setNascimento(pessoaAtualizada.getNascimento());
            pessoa.setGenero(pessoaAtualizada.getGenero());
            pessoaFisicaRepository.persist(pessoa);
        }
        return pessoa;
    }
    
    @Transactional
    public boolean deletar(Long id) {
        return pessoaFisicaRepository.deleteById(id);
    }
}