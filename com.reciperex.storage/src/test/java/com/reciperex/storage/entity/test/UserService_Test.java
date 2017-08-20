package com.reciperex.storage.entity.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.reciperex.model.Cookbook;
import com.reciperex.model.Image;
import com.reciperex.model.Meal;
import com.reciperex.model.MealPlan;
import com.reciperex.model.Recipe;
import com.reciperex.model.User;
import com.reciperex.storage.entity.CookbookService;
import com.reciperex.storage.entity.ImageService;
import com.reciperex.storage.entity.IngredientService;
import com.reciperex.storage.entity.InstructionService;
import com.reciperex.storage.entity.MealPlanService;
import com.reciperex.storage.entity.MealService;
import com.reciperex.storage.entity.RecipeService;
import com.reciperex.storage.entity.UserService;
import com.reciperex.storage.entity.impl.CookbookServiceImpl;
import com.reciperex.storage.entity.impl.ImageServiceImpl;
import com.reciperex.storage.entity.impl.IngredientServiceImpl;
import com.reciperex.storage.entity.impl.InstructionServiceImpl;
import com.reciperex.storage.entity.impl.MealPlanServiceImpl;
import com.reciperex.storage.entity.impl.MealServiceImpl;
import com.reciperex.storage.entity.impl.RecipeServiceImpl;
import com.reciperex.storage.entity.impl.UserServiceImpl;
import com.reciperex.storage.service.DatabaseManager;
import com.reciperex.storage.service.SQLBuilder;

public class UserService_Test {
	
	User user;
	Recipe recipe;
	Meal meal;
	MealPlan mealPlan;
	Cookbook cookbook;
	Image profilePic;
	DatabaseManager manager;
	UserService userService;
	RecipeService recipeService;
	MealService mealService;
	MealPlanService mealPlanService;
	CookbookService cookbookService;
	ImageService imageService;
	InstructionService instructionService;
	IngredientService ingredientService;
	
	
	@Before
	public void init(){
		manager = new DatabaseManager();
		userService = new UserServiceImpl();
		recipeService = new RecipeServiceImpl();
		mealService = new MealServiceImpl();
		mealPlanService = new MealPlanServiceImpl();
		cookbookService = new CookbookServiceImpl();
		imageService = new ImageServiceImpl();
		
		user = new User();
		user.setUsername("testUser1");
		user.setPassword("testPass");
		user.setFirstName("Test");
		user.setLastName("User");
		user.setAge(30);
		user.setBio("Test user bio");
		user.setEmail("testUser@reciperex.com");
		user.setCity("Nowhere");
		user.setState("NoState");
		user.setCountry("NoCountry");
		user.setGender('M');

		profilePic = new Image();
		profilePic.setImagePath("file:///c:/Path/To/Pic");
		profilePic.setImageText("Profile picture text");
		
		recipe = new Recipe();
		recipe.setTitle("Test Recipe");
		recipe.setOwner("testUser1");
		recipe.setAttributedTo("unknown");
		recipe.setDescription("This is the best chocolate cake recipe I have found to date");
		recipe.setOvenTemp(350);
		recipe.setAttributedTo("Unknown");
		recipe.setNumberOfServings(12);
		recipe.setCookTime("30 minutes");
		recipe.setPrepTime("30 minutes");
		recipe.getIngredients().put("salt", "1 teaspoon");
		recipe.getIngredients().put("bakers unsweetened chocolate", "3 squares");
		recipe.getIngredients().put("flour", "2 cups");
		recipe.getIngredients().put("brown sugar", "2 1/4 cups");
		recipe.getIngredients().put("water, boiling", "1 cup");
		recipe.getInstructions().put(1, "Do this.");
		recipe.getInstructions().put(2, "Do that.");
		recipe.getInstructions().put(3, "Cook this.");
		recipe.getInstructions().put(4, "Bake that.");
		
		meal = new Meal();
		meal.setName("Test Meal");
		meal.setLastPrepared(LocalDate.now());
		meal.setRecipes(new ArrayList<Integer>());
		
		mealPlan = new MealPlan();
		mealPlan.setName("Test MealPlan");
		mealPlan.setMeals(new ArrayList<Integer>());
		
		cookbook = new Cookbook();
		cookbook.setTitle("Test Cookbook");
		
	}
	
	@Test
	public void UserService_CRUD() throws SQLException {
		int result = 0;
		
		// Test create operation
		result = userService.insertNewUser(user);
		Assert.assertTrue(result == 1);
		
		user = userService.getUserByUsername(user.getUsername());
		
		// Set up internal references to entities (DO ALL THIS DURING UPDATE TEST)
		recipeService.insertNewRecipe(recipe, user.getId());

		meal.getRecipes().add(recipe.getId());
		mealService.insertNewMeal(meal, user.getId());

		mealPlan.getMeals().add(meal.getId());
		mealPlanService.insertNewMealPlan(mealPlan, user.getId());

		cookbook.setCreatorId(user.getId());
		cookbook.getRecipes().add(recipe.getId());
		cookbookService.insertNewCookbook(cookbook, user.getId());

		profilePic.setRecipeId(null);
		profilePic.setUserId(user.getId());
		imageService.insertNewImage(profilePic);
		user.setProfilePic(profilePic);
		
		// Test update operation
		
		// Test delete operation
		result = -1;
		try {
			result = userService.deleteUser(user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(result != -1);
		
		// Check database for user
		Connection conn = manager.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql = "SELECT COUNT(*) FROM user WHERE id = " + user.getId();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		Assert.assertTrue(rs.getInt("COUNT(*)") == 0);
		
	}

}
