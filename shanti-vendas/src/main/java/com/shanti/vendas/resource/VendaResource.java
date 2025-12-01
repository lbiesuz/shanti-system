package com.shanti.vendas.resource;

import com.shanti.vendas.entity.Venda;
import com.shanti.vendas.service.VendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/vendas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VendaResource {
    
    @Inject
    VendaService vendaService;
    
    @GET
    public List<Venda> listar() {
        return vendaService.listarTodas();
    }
    
    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        Venda venda = vendaService.buscarPorId(id);
        if (venda == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(venda).build();
    }
    
    @GET
    @Path("/cliente/{clienteId}")
    public List<Venda> listarPorCliente(@PathParam("clienteId") Long clienteId) {
        return vendaService.listarPorCliente(clienteId);
    }
    
    @POST
    public Response criar(Venda venda) {
        Venda vendaCriada = vendaService.criar(venda);
        return Response.status(Response.Status.CREATED).entity(vendaCriada).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = vendaService.deletar(id);
        if (!deletado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}