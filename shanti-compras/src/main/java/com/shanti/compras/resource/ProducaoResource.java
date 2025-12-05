package com.shanti.compras.resource;

import com.shanti.compras.dto.ProducaoRequestDTO;
import com.shanti.compras.entity.Producao;
import com.shanti.compras.service.ProducaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/producoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProducaoResource {
    
  @Inject
  ProducaoService producaoService;
    
  @GET
  public List<Producao> listar() {
    return producaoService.listarTodas();
  }
    
  @GET
  @Path("/{id}")
  public Response buscar(@PathParam("id") Long id) {
    Producao producao = producaoService.buscarPorId(id);
    if (producao == null) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.ok(producao).build();
  }
    
  @GET
  @Path("/produto/{idProduto}")
  public List<Producao> listarPorProduto(@PathParam("idProduto") Long idProduto) {
    return producaoService.listarPorProduto(idProduto);
  }
    
  @POST
  public Response criar(Producao producao) {
    Producao producaoCriada = producaoService.criar(producao);
    return Response.status(Response.Status.CREATED).entity(producaoCriada).build();
  }
    
  @POST
  @Path("/com-produto")
  public Response criarComProduto(ProducaoRequestDTO dto) {
    try {
        Producao producao = producaoService.criarComProduto(dto);
        return Response.status(Response.Status.CREATED).entity(producao).build();
    } catch (Exception e) {
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(e.getMessage()).build();
    }
  }
    
  @DELETE
  @Path("/{id}")
  public Response deletar(@PathParam("id") Long id) {
    boolean deletado = producaoService.deletar(id);
    if (!deletado) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.noContent().build();
  }
}