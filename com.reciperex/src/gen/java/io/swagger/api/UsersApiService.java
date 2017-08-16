package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Cookbook;
import io.swagger.model.Meal;
import io.swagger.model.MealPlan;
import io.swagger.model.Recipe;
import io.swagger.model.User;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-13T06:27:30.917Z")
public abstract class UsersApiService {
    public abstract Response addIngredientToPantry(String username,String ingredientId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addMealToMealPlan(String username,String mealPlanId,Long mealId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addRecipeToCookbook(String username,String cookbookId,Long recipeId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addRecipeToMeal(String username,String mealId,Long recipeId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createCookbook(String username,String cookbookId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createMeal(String username,String mealId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createMealPlan(String username,String mealPlanId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createUser(String username,User body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteIngredientFromPantry(String username,String ingredientId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteMealFromMealPlan(String username,String mealPlanId,Long mealId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteRecipeFromMeal(String username,String mealId,Long recipeId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteRecipeInCookbook(String username,String cookbookId,Long recipeId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteUser(String username,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getCookbookRecipes(String username,String cookbookId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getCookbooksByUserId(String username,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getMealPlanMeals(String username,String mealPlanId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getMealPlansByUserId(String username,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getMealRecipes(String username,String mealId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getMealsByUserId(String username,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUserByName(String username,SecurityContext securityContext) throws NotFoundException;
    public abstract Response loginUser(String username,String password,SecurityContext securityContext) throws NotFoundException;
    public abstract Response logoutUser(SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateIngredientInPantry(String username,String ingredientId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateMealInMealPlan(String username,String mealPlanId,Long mealId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateRecipeInCookbook(String username,String cookbookId,Long recipeId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateRecipelInMeal(String username,String mealId,Long recipeId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateUser(String username,User body,SecurityContext securityContext) throws NotFoundException;
}
