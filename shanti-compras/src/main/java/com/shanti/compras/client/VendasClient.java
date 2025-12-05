package com.shanti.compras.client;

import com.shanti.compras.dto.ProdutoDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/produtos")
@RegisterRestClient(configKey = "vendas-api")
public interface VendasClient {
    
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  ProdutoDTO buscarProduto(@PathParam("id") Long id);
    
  @POST
  @Path("/from-dto")  // ← MUDANÇA AQUI
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  ProdutoDTO criarProduto(ProdutoDTO produto);
    
  @PUT
  @Path("/{id}/estoque")
  @Consumes(MediaType.APPLICATION_JSON)
  void atualizarEstoque(@PathParam("id") Long id, Integer quantidade);
}