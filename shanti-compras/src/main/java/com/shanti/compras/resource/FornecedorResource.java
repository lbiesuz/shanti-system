package com.shanti.compras.resource;

import com.shanti.compras.entity.Fornecedor;
import com.shanti.compras.service.FornecedorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/fornecedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FornecedorResource {
    
    @Inject
    FornecedorService fornecedorService;
    
    @GET
    public List<Fornecedor> listar() {
        return fornecedorService.listarTodos();
    }
    
    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        Fornecedor fornecedor = fornecedorService.buscarPorId(id);
        if (fornecedor == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(fornecedor).build();
    }
    
    @POST
    public Response criar(Fornecedor fornecedor) {
        Fornecedor fornecedorCriado = fornecedorService.criar(fornecedor);
        return Response.status(Response.Status.CREATED).entity(fornecedorCriado).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Fornecedor fornecedor) {
        Fornecedor fornecedorAtualizado = fornecedorService.atualizar(id, fornecedor);
        if (fornecedorAtualizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(fornecedorAtualizado).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = fornecedorService.deletar(id);
        if (!deletado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}