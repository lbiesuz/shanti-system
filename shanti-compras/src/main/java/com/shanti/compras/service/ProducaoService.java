package com.shanti.compras.service;

import com.shanti.compras.client.VendasClient;
import com.shanti.compras.dto.ProducaoRequestDTO;
import com.shanti.compras.dto.ProdutoDTO;
import com.shanti.compras.entity.Insumo;
import com.shanti.compras.entity.Producao;
import com.shanti.compras.repository.ProducaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.util.List;

@ApplicationScoped
public class ProducaoService {
    
  @Inject
  ProducaoRepository producaoRepository;
    
  @Inject
  InsumoService insumoService;
    
  @Inject
  @RestClient
  VendasClient vendasClient;
    
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
  public Producao criarComProduto(ProducaoRequestDTO dto) {
    // 1. Busca o insumo
    Insumo insumo = insumoService.buscarPorId(dto.getInsumoId());
    if (insumo == null) {
        throw new RuntimeException("Insumo não encontrado");
    }
        
    // 2. Desconta insumo do estoque
    insumoService.atualizarEstoque(dto.getInsumoId(), -dto.getQuantidade());
        
    // 3. Se produto já existe, apenas atualiza estoque
    Long idProduto = dto.getIdProduto();
        
    if (idProduto != null) {
        try {
            vendasClient.atualizarEstoque(idProduto, dto.getQuantidade());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar estoque do produto: " + e.getMessage());
        }
    } else {
    // 4. Se não existe, cria o produto no microserviço Vendas
        ProdutoDTO novoProduto = new ProdutoDTO();
        novoProduto.setDescricao(dto.getDescricaoProduto());
        novoProduto.setEstoqueProduto(dto.getQuantidade());
        novoProduto.setPrecoAtual(dto.getPrecoProduto());
        novoProduto.setEan(dto.getEanProduto());
        novoProduto.setCategoriaId(dto.getCategoriaId());
            
        try {
            ProdutoDTO produtoCriado = vendasClient.criarProduto(novoProduto);
            idProduto = produtoCriado.getId();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar produto no microserviço Vendas: " + e.getMessage());
        }
    }
        
    // 5. Cria a produção
    Producao producao = new Producao();
    producao.setLote(dto.getLote());
    producao.setValidadeProduto(dto.getValidadeProduto());
    producao.setQuantidade(dto.getQuantidade());
    producao.setInsumo(insumo);
    producao.setIdProduto(idProduto);
        
    producaoRepository.persist(producao);
    return producao;
  }
    
  @Transactional
  public boolean deletar(Long id) {
    return producaoRepository.deleteById(id);
  }
}