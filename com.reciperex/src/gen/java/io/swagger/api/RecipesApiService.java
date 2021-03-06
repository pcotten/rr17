package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Recipe;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-13T06:27:30.917Z")
public abstract class RecipesApiService {
    public abstract Response addRecipe(Long recipeId,Recipe body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteRecipe(Long recipeId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateRecipe(Long recipeId,Recipe body,SecurityContext securityContext) throws NotFoundException;
}
