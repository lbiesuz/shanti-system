package com.shanti.vendas.resource;

import com.shanti.vendas.entity.Produto;
import com.shanti.vendas.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    
    @Inject
    ProdutoService produtoService;
    
    @GET
    public List<Produto> listar() {
        return produtoService.listarTodos();
    }
    
    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        Produto produto = produtoService.buscarPorId(id);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(produto).build();
    }
    
    @GET
    @Path("/categoria/{categoriaId}")
    public List<Produto> listarPorCategoria(@PathParam("categoriaId") Long categoriaId) {
        return produtoService.listarPorCategoria(categoriaId);
    }
    
    @GET
    @Path("/estoque-baixo/{quantidade}")
    public List<Produto> listarEstoqueBaixo(@PathParam("quantidade") Integer quantidade) {
        return produtoService.listarEstoqueBaixo(quantidade);
    }
    
    @POST
    public Response criar(Produto produto) {
        Produto produtoCriado = produtoService.criar(produto);
        return Response.status(Response.Status.CREATED).entity(produtoCriado).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Produto produto) {
        Produto produtoAtualizado = produtoService.atualizar(id, produto);
        if (produtoAtualizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(produtoAtualizado).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = produtoService.deletar(id);
        if (!deletado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}