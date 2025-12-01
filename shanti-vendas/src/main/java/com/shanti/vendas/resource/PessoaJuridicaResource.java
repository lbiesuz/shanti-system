package com.shanti.vendas.resource;

import com.shanti.vendas.entity.PessoaJuridica;
import com.shanti.vendas.service.PessoaJuridicaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/pessoas-juridicas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaJuridicaResource {
    
    @Inject
    PessoaJuridicaService pessoaJuridicaService;
    
    @GET
    public List<PessoaJuridica> listar() {
        return pessoaJuridicaService.listarTodas();
    }
    
    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        PessoaJuridica pessoa = pessoaJuridicaService.buscarPorId(id);
        if (pessoa == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(pessoa).build();
    }
    
    @GET
    @Path("/cnpj/{cnpj}")
    public Response buscarPorCnpj(@PathParam("cnpj") String cnpj) {
        PessoaJuridica pessoa = pessoaJuridicaService.buscarPorCnpj(cnpj);
        if (pessoa == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(pessoa).build();
    }
    
    @POST
    public Response criar(PessoaJuridica pessoaJuridica) {
        PessoaJuridica pessoaCriada = pessoaJuridicaService.criar(pessoaJuridica);
        return Response.status(Response.Status.CREATED).entity(pessoaCriada).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, PessoaJuridica pessoaJuridica) {
        PessoaJuridica pessoaAtualizada = pessoaJuridicaService.atualizar(id, pessoaJuridica);
        if (pessoaAtualizada == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(pessoaAtualizada).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = pessoaJuridicaService.deletar(id);
        if (!deletado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}