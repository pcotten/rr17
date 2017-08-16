package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.RecipesApiService;
import io.swagger.api.factories.RecipesApiServiceFactory;

import io.swagger.model.Recipe;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/recipes")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2017-02-13T06:27:37.154Z")
public class RecipesApi  {
   private final RecipesApiService delegate = RecipesApiServiceFactory.getRecipesApi();

    @POST
    @Path("/{recipeId}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    public Response addRecipe( @PathParam("recipeId") Long recipeId, Recipe body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addRecipe(recipeId,body,securityContext);
    }
    @DELETE
    @Path("/{recipeId}")
    
    @Produces({ "application/json", "application/xml" })
    public Response deleteRecipe( @PathParam("recipeId") Long recipeId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteRecipe(recipeId,securityContext);
    }
    @PUT
    @Path("/{recipeId}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    public Response updateRecipe( @PathParam("recipeId") Long recipeId, Recipe body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateRecipe(recipeId,body,securityContext);
    }
}
