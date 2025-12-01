package com.shanti.vendas.service;

import com.shanti.vendas.entity.PessoaJuridica;
import com.shanti.vendas.repository.PessoaJuridicaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PessoaJuridicaService {
    
    @Inject
    PessoaJuridicaRepository pessoaJuridicaRepository;
    
    public List<PessoaJuridica> listarTodas() {
        return pessoaJuridicaRepository.listAll();
    }
    
    public PessoaJuridica buscarPorId(Long id) {
        return pessoaJuridicaRepository.findById(id);
    }
    
    public PessoaJuridica buscarPorCnpj(String cnpj) {
        return pessoaJuridicaRepository.findByCnpj(cnpj);
    }
    
    @Transactional
    public PessoaJuridica criar(PessoaJuridica pessoaJuridica) {
        pessoaJuridicaRepository.persist(pessoaJuridica);
        return pessoaJuridica;
    }
    
    @Transactional
    public PessoaJuridica atualizar(Long id, PessoaJuridica pessoaAtualizada) {
        PessoaJuridica pessoa = pessoaJuridicaRepository.findById(id);
        if (pessoa != null) {
            pessoa.setNomeFantasia(pessoaAtualizada.getNomeFantasia());
            pessoa.setRazaoSocial(pessoaAtualizada.getRazaoSocial());
            pessoa.setCnpj(pessoaAtualizada.getCnpj());
            pessoa.setTelefone(pessoaAtualizada.getTelefone());
            pessoa.setEmail(pessoaAtualizada.getEmail());
            pessoa.setContato(pessoaAtualizada.getContato());
            pessoaJuridicaRepository.persist(pessoa);
        }
        return pessoa;
    }
    
    @Transactional
    public boolean deletar(Long id) {
        return pessoaJuridicaRepository.deleteById(id);
    }
}