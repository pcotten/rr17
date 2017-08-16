package io.swagger.api.factories;

import io.swagger.api.RecipesApiService;
import io.swagger.api.impl.RecipesApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-13T06:27:30.917Z")
public class RecipesApiServiceFactory {
    private final static RecipesApiService service = new RecipesApiServiceImpl();

    public static RecipesApiService getRecipesApi() {
        return service;
    }
}
