package com.shanti.compras.resource;

import com.shanti.compras.entity.Compra;
import com.shanti.compras.service.CompraService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/compras")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompraResource {
    
  @Inject
  CompraService compraService;
    
  @GET
  public List<Compra> listar() {
    return compraService.listarTodas();
  }
    
  @GET
  @Path("/{id}")
  public Response buscar(@PathParam("id") Long id) {
    Compra compra = compraService.buscarPorId(id);
    if (compra == null) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.ok(compra).build();
  }
    
  @GET
  @Path("/fornecedor/{fornecedorId}")
  public List<Compra> listarPorFornecedor(@PathParam("fornecedorId") Long fornecedorId) {
    return compraService.listarPorFornecedor(fornecedorId);
  }
    
  @POST
  public Response criar(Compra compra) {
    Compra compraCriada = compraService.criar(compra);
    return Response.status(Response.Status.CREATED).entity(compraCriada).build();
  }
    
  @DELETE
  @Path("/{id}")
  public Response deletar(@PathParam("id") Long id) {
    boolean deletado = compraService.deletar(id);
    if (!deletado) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.noContent().build();
  }
}