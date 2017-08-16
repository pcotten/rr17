package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.UsersApiService;
import io.swagger.api.factories.UsersApiServiceFactory;

import io.swagger.model.Cookbook;
import io.swagger.model.Meal;
import io.swagger.model.MealPlan;
import io.swagger.model.Recipe;
import io.swagger.model.User;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/users")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2017-02-13T06:27:37.154Z")
public class UsersApi  {
   private final UsersApiService delegate = UsersApiServiceFactory.getUsersApi();

    @POST
    @Path("/{username}/pantry/ingredients/{ingredientId}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    public Response addIngredientToPantry( @PathParam("username") String username, @PathParam("ingredientId") String ingredientId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addIngredientToPantry(username,ingredientId,securityContext);
    }
    @POST
    @Path("/{username}/mealPlans/{mealPlanId}/meals/{mealId}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    public Response addMealToMealPlan( @PathParam("username") String username, @PathParam("mealPlanId") String mealPlanId, @PathParam("mealId") Long mealId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addMealToMealPlan(username,mealPlanId,mealId,securityContext);
    }
    @POST
    @Path("/{username}/cookbooks/{cookbookId}/recipes/{recipeId}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    public Response addRecipeToCookbook( @PathParam("username") String username, @PathParam("cookbookId") String cookbookId, @PathParam("recipeId") Long recipeId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addRecipeToCookbook(username,cookbookId,recipeId,securityContext);
    }
    @POST
    @Path("/{username}/meals/{mealId}/recipes/{recipeId}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    public Response addRecipeToMeal( @PathParam("username") String username, @PathParam("mealId") String mealId, @PathParam("recipeId") Long recipeId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addRecipeToMeal(username,mealId,recipeId,securityContext);
    }
    @POST
    @Path("/{username}/cookbooks/{cookbookId}")
    @Consumes({ "application/json", "applictiaon/xml" })
    @Produces({ "application/json", "application/xml" })
    public Response createCookbook( @PathParam("username") String username, @PathParam("cookbookId") String cookbookId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createCookbook(username,cookbookId,securityContext);
    }
    @POST
    @Path("/{username}/meals/{mealId}")
    @Consumes({ "application/json", "applictiaon/xml" })
    @Produces({ "application/json", "application/xml" })
    public Response createMeal( @PathParam("username") String username, @PathParam("mealId") String mealId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createMeal(username,mealId,securityContext);
    }
    @POST
    @Path("/{username}/mealPlans/{mealPlanId}")
    @Consumes({ "application/json", "applictiaon/xml" })
    @Produces({ "application/json", "application/xml" })
    public Response createMealPlan( @PathParam("username") String username, @PathParam("mealPlanId") String mealPlanId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createMealPlan(username,mealPlanId,securityContext);
    }
    @POST
    @Path("/{username}")
    
    @Produces({ "application/json", "application/xml" })
    public Response createUser( @PathParam("username") String username, User body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createUser(username,body,securityContext);
    }
    @DELETE
    @Path("/{username}/pantry/ingredients/{ingredientId}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    public Response deleteIngredientFromPantry( @PathParam("username") String username, @PathParam("ingredientId") String ingredientId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteIngredientFromPantry(username,ingredientId,securityContext);
    }
    @DELETE
    @Path("/{username}/mealPlans/{mealPlanId}/meals/{mealId}")
    @Consumes({ "application/json", "application/xml" })
    
    public Response deleteMealFromMealPlan( @PathParam("username") String username, @PathParam("mealPlanId") String mealPlanId, @PathParam("mealId") Long mealId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteMealFromMealPlan(username,mealPlanId,mealId,securityContext);
    }
    @DELETE
    @Path("/{username}/meals/{mealId}/recipes/{recipeId}")
    @Consumes({ "application/json", "application/xml" })
    
    public Response deleteRecipeFromMeal( @PathParam("username") String username, @PathParam("mealId") String mealId, @PathParam("recipeId") Long recipeId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteRecipeFromMeal(username,mealId,recipeId,securityContext);
    }
    @DELETE
    @Path("/{username}/cookbooks/{cookbookId}/recipes/{recipeId}")
    @Consumes({ "application/json", "application/xml" })
    
    public Response deleteRecipeInCookbook( @PathParam("username") String username, @PathParam("cookbookId") String cookbookId, @PathParam("recipeId") Long recipeId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteRecipeInCookbook(username,cookbookId,recipeId,securityContext);
    }
    @DELETE
    @Path("/{username}")
    
    @Produces({ "application/json", "application/xml" })
    public Response deleteUser( @PathParam("username") String username,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteUser(username,securityContext);
    }
    @GET
    @Path("/{username}/cookbooks/{cookbookId}/recipes")
    
    @Produces({ "application/json", "application/xml" })
    public Response getCookbookRecipes( @PathParam("username") String username, @PathParam("cookbookId") String cookbookId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getCookbookRecipes(username,cookbookId,securityContext);
    }
    @GET
    @Path("/{username}/cookbooks")
    
    @Produces({ "application/json", "application/xml" })
    public Response getCookbooksByUserId( @PathParam("username") String username,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getCookbooksByUserId(username,securityContext);
    }
    @GET
    @Path("/{username}/mealPlan/{mealPlanId}/meals")
    
    @Produces({ "application/json", "application/xml" })
    public Response getMealPlanMeals( @PathParam("username") String username, @PathParam("mealPlanId") String mealPlanId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getMealPlanMeals(username,mealPlanId,securityContext);
    }
    @GET
    @Path("/{username}/mealPlans")
    
    @Produces({ "application/json", "application/xml" })
    public Response getMealPlansByUserId( @PathParam("username") String username,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getMealPlansByUserId(username,securityContext);
    }
    @GET
    @Path("/{username}/meals/{mealId}/recipes")
    
    @Produces({ "application/json", "application/xml" })
    public Response getMealRecipes( @PathParam("username") String username, @PathParam("mealId") String mealId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getMealRecipes(username,mealId,securityContext);
    }
    @GET
    @Path("/{username}/meals")
    
    @Produces({ "application/json", "application/xml" })
    public Response getMealsByUserId( @PathParam("username") String username,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getMealsByUserId(username,securityContext);
    }
    @GET
    @Path("/{username}")
    
    @Produces({ "application/json", "application/xml" })
    public Response getUserByName( @PathParam("username") String username,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getUserByName(username,securityContext);
    }
    @GET
    @Path("/login")
    
    @Produces({ "application/json", "application/xml" })
    public Response loginUser( @QueryParam("username") String username, @QueryParam("password") String password,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.loginUser(username,password,securityContext);
    }
    @GET
    @Path("/logout")
    
    @Produces({ "application/json", "application/xml" })
    public Response logoutUser(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.logoutUser(securityContext);
    }
    @PUT
    @Path("/{username}/pantry/ingredients/{ingredientId}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    public Response updateIngredientInPantry( @PathParam("username") String username, @PathParam("ingredientId") String ingredientId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateIngredientInPantry(username,ingredientId,securityContext);
    }
    @PUT
    @Path("/{username}/mealPlans/{mealPlanId}/meals/{mealId}")
    @Consumes({ "application/json", "application/xml" })
    
    public Response updateMealInMealPlan( @PathParam("username") String username, @PathParam("mealPlanId") String mealPlanId, @PathParam("mealId") Long mealId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateMealInMealPlan(username,mealPlanId,mealId,securityContext);
    }
    @PUT
    @Path("/{username}/cookbooks/{cookbookId}/recipes/{recipeId}")
    @Consumes({ "application/json", "application/xml" })
    
    public Response updateRecipeInCookbook( @PathParam("username") String username, @PathParam("cookbookId") String cookbookId, @PathParam("recipeId") Long recipeId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateRecipeInCookbook(username,cookbookId,recipeId,securityContext);
    }
    @PUT
    @Path("/{username}/meals/{mealId}/recipes/{recipeId}")
    @Consumes({ "application/json", "application/xml" })
    
    public Response updateRecipelInMeal( @PathParam("username") String username, @PathParam("mealId") String mealId, @PathParam("recipeId") Long recipeId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateRecipelInMeal(username,mealId,recipeId,securityContext);
    }
    @PUT
    @Path("/{username}")
    
    @Produces({ "application/json", "application/xml" })
    public Response updateUser( @PathParam("username") String username, User body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateUser(username,body,securityContext);
    }
}
