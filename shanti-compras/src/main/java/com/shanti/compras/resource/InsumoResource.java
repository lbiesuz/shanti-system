package com.shanti.compras.resource;

import com.shanti.compras.entity.Insumo;
import com.shanti.compras.service.InsumoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/insumos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InsumoResource {
    
    @Inject
    InsumoService insumoService;
    
    @GET
    public List<Insumo> listar() {
        return insumoService.listarTodos();
    }
    
    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        Insumo insumo = insumoService.buscarPorId(id);
        if (insumo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(insumo).build();
    }
    
    @GET
    @Path("/tipo/{tipoId}")
    public List<Insumo> listarPorTipo(@PathParam("tipoId") Long tipoId) {
        return insumoService.listarPorTipo(tipoId);
    }
    
    @GET
    @Path("/estoque-baixo/{quantidade}")
    public List<Insumo> listarEstoqueBaixo(@PathParam("quantidade") Integer quantidade) {
        return insumoService.listarEstoqueBaixo(quantidade);
    }
    
    @POST
    public Response criar(Insumo insumo) {
        Insumo insumoCriado = insumoService.criar(insumo);
        return Response.status(Response.Status.CREATED).entity(insumoCriado).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Insumo insumo) {
        Insumo insumoAtualizado = insumoService.atualizar(id, insumo);
        if (insumoAtualizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(insumoAtualizado).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = insumoService.deletar(id);
        if (!deletado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}