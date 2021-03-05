package dao;

import com.google.gson.Gson;
import entidades.Categoria;
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

@Path("Categoria")
public class CategoriaResource {

    @Context
    private UriInfo context;

    public CategoriaResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCategorias() {
        Gson gson = new Gson();
        return gson.toJson(categoriaDao.getAll());
    }

    @Path("{categoriaId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCategoria(@PathParam("categoriaId") String id) {
        Gson gson = new Gson();
        Categoria cg = new Categoria();
        cg = categoriaDao.getOne(Long.parseLong(id));
        return gson.toJson(cg);
    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public boolean inserirCategoria(String content) {
        Gson gson = new Gson();
        Categoria cg = (Categoria) gson.fromJson(content, Categoria.class);
        return categoriaDao.persist(cg);
    }

    @Path("excluir/{categoriaId}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean excluirCategoria(@PathParam("categoriaId") String id) {
        return categoriaDao.excluir(Long.parseLong(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean alterarCategoria(String content) {
        Gson gson = new Gson();
        Categoria cg = (Categoria) gson.fromJson(content, Categoria.class);
        return categoriaDao.editar(cg);
    }
}
