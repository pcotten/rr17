package com.reciperex.storage.entity.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reciperex.model.Ingredient;
import com.reciperex.model.Instruction;
import com.reciperex.model.Recipe;
import com.reciperex.model.User;
import com.reciperex.storage.entity.RecipeService;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;
import com.reciperex.storage.service.SQLBuilder;

public class RecipeServiceImpl implements RecipeService{

	DatabaseConfig config = new DatabaseConfig();
	QueryRunner queryRunner = new QueryRunner();
	ObjectMapper mapper = new ObjectMapper();
	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	Map<String, String> constraints = new HashMap<String, String>();
	IngredientServiceImpl ingredientService = new IngredientServiceImpl();
	InstructionServiceImpl instructionService = new InstructionServiceImpl();
	
	public RecipeServiceImpl(){
		
	}
	
	
	public int insertNewRecipe(Recipe recipe, Integer userId){
		
		Savepoint savepoint;
		int r = 0;
		
		try {
			conn = manager.getConnection();
			savepoint = conn.setSavepoint();
			try {
				recipe = insertRecipeEntity(recipe);
				if (recipe.getId() != null){
					r = 1;
				}
				if (r != 0){
					System.out.println("Recipe entity " + recipe.getTitle() + " successfully inserted into database");
				}
				else {
					System.out.println("Unable to complete recipe insert - failed to insert recipe entity");
					throw new SQLException();
				}
				
				r = linkRecipeToUser(recipe, userId);
				if (r != 0){
					System.out.println("Recipe  " + recipe.getTitle() + " successfully linked to user " + userId);
				}
				else {
					System.out.println("Unable to complete recipe insert - failed to link recipe to user");
					throw new SQLException();
				}
								
				r = insertRecipeIngredients(recipe);
				if (r != 0){
					System.out.println("Recipe ingredients successfully inserted into database");
				}
				else {
					System.out.println("Unable to complete recipe insert - failed to insert ingredients");
					throw new SQLException();
				}
								
				r = linkIngredientsToRecipe(recipe);
				if (r != 0){
					System.out.println("Recipe ingredients successfully linked in database");
				}
				else {
					System.out.println("Unable to complete recipe insert - failed to link ingredients");
					throw new SQLException();
				}
				
				r = insertRecipeInstructions(recipe);
				if (r != 0){
					System.out.println("Recipe instructions successfully inserted in database");
				}
				else {
					System.out.println("Unable to complete recipe insert - failed to insert instructions");
					throw new SQLException();
				}
				
				// insert categories
				// link categories to recipe
				// insert images
				
				
			} catch (SQLException e) {
				System.out.println("Attempting rollback");
//				conn.rollback(savepoint);
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println("Unable to perform rollback.");
			e1.printStackTrace();
		}
		return r;
	}


	private Recipe insertRecipeEntity(Recipe recipe) throws SQLException {

		pstmt = conn.prepareStatement("INSERT INTO recipe (title, description, owner, attributedTo, "
			+ "numberOfServings, ovenTemp, servingSize, cookTime, prepTime) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, recipe.getTitle());
		pstmt.setString(2, recipe.getDescription());
		pstmt.setString(3, recipe.getOwner());
		pstmt.setString(4, recipe.getAttributedTo());
		pstmt.setInt(5, recipe.getNumberOfServings());
		pstmt.setInt(6, recipe.getOvenTemp());
		pstmt.setString(7, recipe.getServingSize());
		pstmt.setString(8, recipe.getCookTime());
		pstmt.setString(9, recipe.getPrepTime());
		
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()){
			Integer id = Integer.valueOf(rs.getString("GENERATED_KEY"));
			recipe.setId(id);
		}
		return recipe;
	}


	private int insertRecipeIngredients(Recipe recipe) throws SQLException {
		
		constraints.clear();
		
		List<Map<String, Object>> ingredientMapList = ingredientService.queryIngredients(recipe);

		for (String s : recipe.getIngredients().keySet()){
			boolean exists = false;
			for (Map<String, Object> m : ingredientMapList){
				if (s.equals(m.get("name"))){
					exists = true;
					break;
				}
			}
			if (!exists){
				Ingredient newIngredient = new Ingredient(s, null);
				int insertResult = ingredientService.insertNewIngredient(newIngredient);
				if (insertResult != 1){
					System.out.println("Ingredient " + s + "could not be added to database.");
					throw new SQLException();
				}
			}
		}
		return 1;
	}
	
	private int linkIngredientsToRecipe(Recipe recipe) throws SQLException {
		int result = 0;
		
		List<Map<String, Object>> ingredientMapList = ingredientService.queryIngredients(recipe);
	
		if (conn.isClosed()){
			conn = manager.getConnection();
		}
		Map<String, Integer> ingredientMap = new HashMap<String, Integer>();
		for (Map<String, Object> m : ingredientMapList){
			ingredientMap.put(m.get("name").toString(), Integer.valueOf(m.get("id").toString()));
		}
		
		for (String m : recipe.getIngredients().keySet()){
			
			pstmt = conn.prepareStatement("INSERT INTO ingredient_recipe (recipeId, ingredientId, quantity) VALUES (?, ?, ?)");
			pstmt.setInt(1, recipe.getId());
			pstmt.setInt(2, ingredientMap.get(m));
			pstmt.setString(3, recipe.getIngredients().get(m));
			
			result = pstmt.executeUpdate();
			
			if (result != 1){
				System.out.println("Unable to create link between recipe '" + recipe.getTitle() + " and ingredient '" + m + "'");
			}
		}

		return result;
	}


	private int insertRecipeInstructions(Recipe recipe) throws SQLException {
		constraints.clear();
		int r = 0;
		List<Map<String, Object>> instructionMapList = instructionService.queryInstructions(recipe);
		System.out.println(instructionMapList);

		for (Integer i : recipe.getInstructions().keySet()){

			Instruction newInstruction = new Instruction(i, recipe.getInstructions().get(i), recipe.getId());
			r = instructionService.insertNewInstruction(newInstruction);
			if (r != 1){
				System.out.println("Instruction " + i + "could not be added to database.");
				throw new SQLException();
			}
		}
		return r;
	}
	
	
	private int linkRecipeToUser(Recipe recipe, Integer userId) throws SQLException {
		int result = 0;
		
		if (conn.isClosed()){
			conn = manager.getConnection();
		}
		
		pstmt = conn.prepareStatement("INSERT INTO user_recipe (recipeId, userId) VALUES (?, ?)");
		pstmt.setInt(1, recipe.getId());
		pstmt.setInt(2, userId);
		
		result = pstmt.executeUpdate();
		
		if (result != 1){
			System.out.println("Unable to create link between recipe '" + recipe.getTitle() + " and user " + userId);
		}
		
		return result;
	}

	public Recipe getRecipeByRecipeId(Integer recipeId){
		
		conn = manager.getConnection();
		Recipe recipe = new Recipe();
		ResultSet resultSet = null;
		// retrieve entity
		constraints.clear();
		constraints.put("id", recipeId.toString());
		recipe = (Recipe) manager.retrieveSingleEntity(constraints, Recipe.class);
		
		// retrieve ingredients
		try {
			pstmt = conn.prepareStatement("SELECT * FROM ingredients_by_recipeid WHERE recipeId = ?");
			pstmt.setInt(1, recipeId);
			
			resultSet = pstmt.executeQuery();
			Map<String, String> ingredientsMap = new HashMap<String, String>();
			while (resultSet.next()){
				ingredientsMap.put(resultSet.getString("name"), resultSet.getString("quantity"));
			}
			recipe.setIngredients(ingredientsMap);
			
		// retrieve instructions
			pstmt = conn.prepareStatement("SELECT * FROM instruction WHERE recipeId = ?");
			pstmt.setInt(1, recipeId);
			
			resultSet = pstmt.executeQuery();
			Map<Integer, String> instructionMap = new HashMap<Integer, String>();
			while (resultSet.next()){
				instructionMap.put(resultSet.getInt("orderIndex"), resultSet.getString("text"));
			}
			recipe.setInstructions(instructionMap);
		
		
		// retrieve images
			pstmt = conn.prepareStatement("SELECT * FROM image WHERE recipeId = ?");
			pstmt.setInt(1, recipeId);
			
			resultSet = pstmt.executeQuery();
			List<String> stringList = new ArrayList<String>();
			while (resultSet.next()){
				stringList.add(resultSet.getString("imagePath"));
			}
			recipe.getImages().addAll(stringList);
		
		// retrieve categories
			pstmt = conn.prepareStatement("SELECT * FROM category_by_recipeid WHERE recipeId = ?");
			pstmt.setInt(1, recipeId);
			
			resultSet = pstmt.executeQuery();
			stringList.clear();
			while (resultSet.next()){
				stringList.add(resultSet.getString("name"));
			}
			recipe.getCategories().addAll(stringList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recipe;
	}
	
	public int updateRecipe(Recipe recipe){
		// TODO - pain in the butt method for updating recipe components in the DB
		return 0;
	}
	
	//
	public int deleteRecipe(Integer id) throws SQLException{
		
		int result = -1;

		conn = manager.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM recipe WHERE id = ?");
		pstmt.setInt(1, id);
		result = pstmt.executeUpdate();
		if (result != -1){
			System.out.println("Successfully removed recipe with recipeId " + id);
		}
		else {
			System.out.println("Unable to remove recipe entity with recipeId " + id);
		}
		
		return result;
	}
	
	
}
