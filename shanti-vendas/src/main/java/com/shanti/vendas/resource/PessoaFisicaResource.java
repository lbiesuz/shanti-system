package com.shanti.vendas.resource;

import com.shanti.vendas.entity.PessoaFisica;
import com.shanti.vendas.service.PessoaFisicaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/pessoas-fisicas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaFisicaResource {
    
    @Inject
    PessoaFisicaService pessoaFisicaService;
    
    @GET
    public List<PessoaFisica> listar() {
        return pessoaFisicaService.listarTodas();
    }
    
    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        PessoaFisica pessoa = pessoaFisicaService.buscarPorId(id);
        if (pessoa == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(pessoa).build();
    }
    
    @GET
    @Path("/cpf/{cpf}")
    public Response buscarPorCpf(@PathParam("cpf") String cpf) {
        PessoaFisica pessoa = pessoaFisicaService.buscarPorCpf(cpf);
        if (pessoa == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(pessoa).build();
    }
    
    @POST
    public Response criar(PessoaFisica pessoaFisica) {
        PessoaFisica pessoaCriada = pessoaFisicaService.criar(pessoaFisica);
        return Response.status(Response.Status.CREATED).entity(pessoaCriada).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, PessoaFisica pessoaFisica) {
        PessoaFisica pessoaAtualizada = pessoaFisicaService.atualizar(id, pessoaFisica);
        if (pessoaAtualizada == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(pessoaAtualizada).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = pessoaFisicaService.deletar(id);
        if (!deletado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}