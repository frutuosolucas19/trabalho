/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import entidades.Produto;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dell
 */
@Path("Produto")
public class ProdutoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutoResource
     */
    public ProdutoResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProdutos() {
        Gson gson = new Gson();
        return gson.toJson(produtoDao.getAll());
    }

    @Path("{produtoId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProdutos(@PathParam("produtoId") String id) {
        Gson gson = new Gson();
        Produto pr = new Produto();
        pr = produtoDao.getOne(Long.parseLong(id));
        return gson.toJson(pr);
    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public boolean inserirProduto(String content) {
        Gson gson = new Gson();
        Produto pr = (Produto) gson.fromJson(content, Produto.class);
        return produtoDao.persist(pr);
    }

    @Path("excluir/{produtoId}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean excluirProduto(@PathParam("produtoId") String id) {
        return produtoDao.excluir(Long.parseLong(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean alterarProduto(String content) {
        Gson gson = new Gson();
        Produto pr = (Produto) gson.fromJson(content, Produto.class);
        return produtoDao.editar(pr);
    }

}
