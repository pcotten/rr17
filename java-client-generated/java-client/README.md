# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.DefaultApi;

import java.io.File;
import java.util.*;

public class DefaultApiExample {

    public static void main(String[] args) {
        
        DefaultApi apiInstance = new DefaultApi();
        String username = "username_example"; // String | Username associated with the pantry
        String ingredientId = "ingredientId_example"; // String | Id of the ingredient to add
        try {
            apiInstance.addIngredientToPantry(username, ingredientId);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#addIngredientToPantry");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost/rest*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**addIngredientToPantry**](docs/DefaultApi.md#addIngredientToPantry) | **POST** /users/{username}/pantry/ingredients/{ingredientId} | Adds an ingredient to a user&#39;s pantry
*DefaultApi* | [**addMealToMealPlan**](docs/DefaultApi.md#addMealToMealPlan) | **POST** /users/{username}/mealPlans/{mealPlanId}/meals/{mealId} | Adds a meal to the specified mealPlan in the specified user&#39;s collection
*DefaultApi* | [**addRecipe**](docs/DefaultApi.md#addRecipe) | **POST** /recipes/{recipeId} | Add a new recipe to the database
*DefaultApi* | [**addRecipeToCookbook**](docs/DefaultApi.md#addRecipeToCookbook) | **POST** /users/{username}/cookbooks/{cookbookId}/recipes/{recipeId} | Adds a recipe to the specified cookbook to the specified user&#39;s collection
*DefaultApi* | [**addRecipeToMeal**](docs/DefaultApi.md#addRecipeToMeal) | **POST** /users/{username}/meals/{mealId}/recipes/{recipeId} | Adds a recipe to the specified meal to the specified user&#39;s collection
*DefaultApi* | [**createCookbook**](docs/DefaultApi.md#createCookbook) | **POST** /users/{username}/cookbooks/{cookbookId} | Creates a new cookbook to the specified user&#39;s collection
*DefaultApi* | [**createMeal**](docs/DefaultApi.md#createMeal) | **POST** /users/{username}/meals/{mealId} | Creates a new meal to the specified user&#39;s collection
*DefaultApi* | [**createMealPlan**](docs/DefaultApi.md#createMealPlan) | **POST** /users/{username}/mealPlans/{mealPlanId} | Creates a new meal to the specified user&#39;s collection
*DefaultApi* | [**createUser**](docs/DefaultApi.md#createUser) | **POST** /users/{username} | Create user
*DefaultApi* | [**deleteIngredientFromPantry**](docs/DefaultApi.md#deleteIngredientFromPantry) | **DELETE** /users/{username}/pantry/ingredients/{ingredientId} | Deletes a meal within the specified mealPlan in the specified user&#39;s collection
*DefaultApi* | [**deleteMealFromMealPlan**](docs/DefaultApi.md#deleteMealFromMealPlan) | **DELETE** /users/{username}/mealPlans/{mealPlanId}/meals/{mealId} | Deletes a meal within the specified mealPlan in the specified user&#39;s collection
*DefaultApi* | [**deleteRecipe**](docs/DefaultApi.md#deleteRecipe) | **DELETE** /recipes/{recipeId} | Deletes a recipe
*DefaultApi* | [**deleteRecipeFromMeal**](docs/DefaultApi.md#deleteRecipeFromMeal) | **DELETE** /users/{username}/meals/{mealId}/recipes/{recipeId} | Deletes a recipe from the specified cookbook in the specified user&#39;s collection
*DefaultApi* | [**deleteRecipeInCookbook**](docs/DefaultApi.md#deleteRecipeInCookbook) | **DELETE** /users/{username}/cookbooks/{cookbookId}/recipes/{recipeId} | Updates a recipe within the specified cookbook in the specified user&#39;s collection
*DefaultApi* | [**deleteUser**](docs/DefaultApi.md#deleteUser) | **DELETE** /users/{username} | Delete user
*DefaultApi* | [**getCookbookRecipes**](docs/DefaultApi.md#getCookbookRecipes) | **GET** /users/{username}/cookbooks/{cookbookId}/recipes | Fetch all recipes in the specified cookbook
*DefaultApi* | [**getCookbooksByUserId**](docs/DefaultApi.md#getCookbooksByUserId) | **GET** /users/{username}/cookbooks | Finds cookbooks by userId
*DefaultApi* | [**getMealPlanMeals**](docs/DefaultApi.md#getMealPlanMeals) | **GET** /users/{username}/mealPlan/{mealPlanId}/meals | Fetch all meals in the specified mealPlan
*DefaultApi* | [**getMealPlansByUserId**](docs/DefaultApi.md#getMealPlansByUserId) | **GET** /users/{username}/mealPlans | Finds mealPlans by userId
*DefaultApi* | [**getMealRecipes**](docs/DefaultApi.md#getMealRecipes) | **GET** /users/{username}/meals/{mealId}/recipes | Fetch all recipes in the specified meal
*DefaultApi* | [**getMealsByUserId**](docs/DefaultApi.md#getMealsByUserId) | **GET** /users/{username}/meals | Finds meals by userId
*DefaultApi* | [**getUserByName**](docs/DefaultApi.md#getUserByName) | **GET** /users/{username} | Get user by user name
*DefaultApi* | [**loginUser**](docs/DefaultApi.md#loginUser) | **GET** /users/login | Logs user into the system
*DefaultApi* | [**logoutUser**](docs/DefaultApi.md#logoutUser) | **GET** /users/logout | Logs out current logged in user session
*DefaultApi* | [**updateIngredientInPantry**](docs/DefaultApi.md#updateIngredientInPantry) | **PUT** /users/{username}/pantry/ingredients/{ingredientId} | Updates a meal within the specified mealPlan in the specified user&#39;s collection
*DefaultApi* | [**updateMealInMealPlan**](docs/DefaultApi.md#updateMealInMealPlan) | **PUT** /users/{username}/mealPlans/{mealPlanId}/meals/{mealId} | Updates a meal within the specified mealPlan in the specified user&#39;s collection
*DefaultApi* | [**updateRecipe**](docs/DefaultApi.md#updateRecipe) | **PUT** /recipes/{recipeId} | Update an existing recipe
*DefaultApi* | [**updateRecipeInCookbook**](docs/DefaultApi.md#updateRecipeInCookbook) | **PUT** /users/{username}/cookbooks/{cookbookId}/recipes/{recipeId} | Updates a recipe within the specified cookbook in the specified user&#39;s collection
*DefaultApi* | [**updateRecipelInMeal**](docs/DefaultApi.md#updateRecipelInMeal) | **PUT** /users/{username}/meals/{mealId}/recipes/{recipeId} | Updates a recipe within the specified meal in the specified user&#39;s collection
*DefaultApi* | [**updateUser**](docs/DefaultApi.md#updateUser) | **PUT** /users/{username} | Updated user


## Documentation for Models

 - [Category](docs/Category.md)
 - [Cookbook](docs/Cookbook.md)
 - [Ingredient](docs/Ingredient.md)
 - [Instruction](docs/Instruction.md)
 - [Meal](docs/Meal.md)
 - [MealPlan](docs/MealPlan.md)
 - [Recipe](docs/Recipe.md)
 - [User](docs/User.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



