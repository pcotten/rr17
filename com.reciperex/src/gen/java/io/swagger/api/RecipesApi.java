package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.RecipesApiService;
import io.swagger.api.factories.RecipesApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Recipe;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/recipes")


@io.swagger.annotations.Api(description = "the recipes API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-13T06:27:30.917Z")
public class RecipesApi  {
   private final RecipesApiService delegate = RecipesApiServiceFactory.getRecipesApi();

    @POST
    @Path("/{recipeId}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Add a new recipe to the database", notes = "", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = void.class) })
    public Response addRecipe(@ApiParam(value = "Recipe id to delete",required=true) @PathParam("recipeId") Long recipeId
,@ApiParam(value = "Recipe object that needs to be added to the database" ) Recipe body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addRecipe(recipeId,body,securityContext);
    }
    @DELETE
    @Path("/{recipeId}")
    
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Deletes a recipe", notes = "", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid recipe id", response = void.class) })
    public Response deleteRecipe(@ApiParam(value = "Recipe id to delete",required=true) @PathParam("recipeId") Long recipeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteRecipe(recipeId,securityContext);
    }
    @PUT
    @Path("/{recipeId}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Update an existing recipe", notes = "", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Recipe not found", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Validation exception", response = void.class) })
    public Response updateRecipe(@ApiParam(value = "Recipe id to update",required=true) @PathParam("recipeId") Long recipeId
,@ApiParam(value = "Recipe object that needs to be updated in the database" ) Recipe body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateRecipe(recipeId,body,securityContext);
    }
}
