package com.shanti.vendas.resource;

import com.shanti.vendas.entity.Categoria;
import com.shanti.vendas.service.CategoriaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {
    
    @Inject
    CategoriaService categoriaService;
    
    @GET
    public List<Categoria> listar() {
        return categoriaService.listarTodas();
    }
    
    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        Categoria categoria = categoriaService.buscarPorId(id);
        if (categoria == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(categoria).build();
    }
    
    @POST
    public Response criar(Categoria categoria) {
        Categoria categoriaCriada = categoriaService.criar(categoria);
        return Response.status(Response.Status.CREATED).entity(categoriaCriada).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Categoria categoria) {
        Categoria categoriaAtualizada = categoriaService.atualizar(id, categoria);
        if (categoriaAtualizada == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(categoriaAtualizada).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = categoriaService.deletar(id);
        if (!deletado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}