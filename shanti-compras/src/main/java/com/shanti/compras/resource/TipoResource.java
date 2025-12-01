package com.shanti.compras.resource;

import com.shanti.compras.entity.Tipo;
import com.shanti.compras.service.TipoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/tipos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoResource {
    
    @Inject
    TipoService tipoService;
    
    @GET
    public List<Tipo> listar() {
        return tipoService.listarTodos();
    }
    
    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        Tipo tipo = tipoService.buscarPorId(id);
        if (tipo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(tipo).build();
    }
    
    @POST
    public Response criar(Tipo tipo) {
        Tipo tipoCriado = tipoService.criar(tipo);
        return Response.status(Response.Status.CREATED).entity(tipoCriado).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Tipo tipo) {
        Tipo tipoAtualizado = tipoService.atualizar(id, tipo);
        if (tipoAtualizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(tipoAtualizado).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = tipoService.deletar(id);
        if (!deletado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}