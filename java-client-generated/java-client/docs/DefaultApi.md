# DefaultApi

All URIs are relative to *http://localhost/rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addIngredientToPantry**](DefaultApi.md#addIngredientToPantry) | **POST** /users/{username}/pantry/ingredients/{ingredientId} | Adds an ingredient to a user&#39;s pantry
[**addMealToMealPlan**](DefaultApi.md#addMealToMealPlan) | **POST** /users/{username}/mealPlans/{mealPlanId}/meals/{mealId} | Adds a meal to the specified mealPlan in the specified user&#39;s collection
[**addRecipe**](DefaultApi.md#addRecipe) | **POST** /recipes/{recipeId} | Add a new recipe to the database
[**addRecipeToCookbook**](DefaultApi.md#addRecipeToCookbook) | **POST** /users/{username}/cookbooks/{cookbookId}/recipes/{recipeId} | Adds a recipe to the specified cookbook to the specified user&#39;s collection
[**addRecipeToMeal**](DefaultApi.md#addRecipeToMeal) | **POST** /users/{username}/meals/{mealId}/recipes/{recipeId} | Adds a recipe to the specified meal to the specified user&#39;s collection
[**createCookbook**](DefaultApi.md#createCookbook) | **POST** /users/{username}/cookbooks/{cookbookId} | Creates a new cookbook to the specified user&#39;s collection
[**createMeal**](DefaultApi.md#createMeal) | **POST** /users/{username}/meals/{mealId} | Creates a new meal to the specified user&#39;s collection
[**createMealPlan**](DefaultApi.md#createMealPlan) | **POST** /users/{username}/mealPlans/{mealPlanId} | Creates a new meal to the specified user&#39;s collection
[**createUser**](DefaultApi.md#createUser) | **POST** /users/{username} | Create user
[**deleteIngredientFromPantry**](DefaultApi.md#deleteIngredientFromPantry) | **DELETE** /users/{username}/pantry/ingredients/{ingredientId} | Deletes a meal within the specified mealPlan in the specified user&#39;s collection
[**deleteMealFromMealPlan**](DefaultApi.md#deleteMealFromMealPlan) | **DELETE** /users/{username}/mealPlans/{mealPlanId}/meals/{mealId} | Deletes a meal within the specified mealPlan in the specified user&#39;s collection
[**deleteRecipe**](DefaultApi.md#deleteRecipe) | **DELETE** /recipes/{recipeId} | Deletes a recipe
[**deleteRecipeFromMeal**](DefaultApi.md#deleteRecipeFromMeal) | **DELETE** /users/{username}/meals/{mealId}/recipes/{recipeId} | Deletes a recipe from the specified cookbook in the specified user&#39;s collection
[**deleteRecipeInCookbook**](DefaultApi.md#deleteRecipeInCookbook) | **DELETE** /users/{username}/cookbooks/{cookbookId}/recipes/{recipeId} | Updates a recipe within the specified cookbook in the specified user&#39;s collection
[**deleteUser**](DefaultApi.md#deleteUser) | **DELETE** /users/{username} | Delete user
[**getCookbookRecipes**](DefaultApi.md#getCookbookRecipes) | **GET** /users/{username}/cookbooks/{cookbookId}/recipes | Fetch all recipes in the specified cookbook
[**getCookbooksByUserId**](DefaultApi.md#getCookbooksByUserId) | **GET** /users/{username}/cookbooks | Finds cookbooks by userId
[**getMealPlanMeals**](DefaultApi.md#getMealPlanMeals) | **GET** /users/{username}/mealPlan/{mealPlanId}/meals | Fetch all meals in the specified mealPlan
[**getMealPlansByUserId**](DefaultApi.md#getMealPlansByUserId) | **GET** /users/{username}/mealPlans | Finds mealPlans by userId
[**getMealRecipes**](DefaultApi.md#getMealRecipes) | **GET** /users/{username}/meals/{mealId}/recipes | Fetch all recipes in the specified meal
[**getMealsByUserId**](DefaultApi.md#getMealsByUserId) | **GET** /users/{username}/meals | Finds meals by userId
[**getUserByName**](DefaultApi.md#getUserByName) | **GET** /users/{username} | Get user by user name
[**loginUser**](DefaultApi.md#loginUser) | **GET** /users/login | Logs user into the system
[**logoutUser**](DefaultApi.md#logoutUser) | **GET** /users/logout | Logs out current logged in user session
[**updateIngredientInPantry**](DefaultApi.md#updateIngredientInPantry) | **PUT** /users/{username}/pantry/ingredients/{ingredientId} | Updates a meal within the specified mealPlan in the specified user&#39;s collection
[**updateMealInMealPlan**](DefaultApi.md#updateMealInMealPlan) | **PUT** /users/{username}/mealPlans/{mealPlanId}/meals/{mealId} | Updates a meal within the specified mealPlan in the specified user&#39;s collection
[**updateRecipe**](DefaultApi.md#updateRecipe) | **PUT** /recipes/{recipeId} | Update an existing recipe
[**updateRecipeInCookbook**](DefaultApi.md#updateRecipeInCookbook) | **PUT** /users/{username}/cookbooks/{cookbookId}/recipes/{recipeId} | Updates a recipe within the specified cookbook in the specified user&#39;s collection
[**updateRecipelInMeal**](DefaultApi.md#updateRecipelInMeal) | **PUT** /users/{username}/meals/{mealId}/recipes/{recipeId} | Updates a recipe within the specified meal in the specified user&#39;s collection
[**updateUser**](DefaultApi.md#updateUser) | **PUT** /users/{username} | Updated user


<a name="addIngredientToPantry"></a>
# **addIngredientToPantry**
> addIngredientToPantry(username, ingredientId)

Adds an ingredient to a user&#39;s pantry



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with the pantry
String ingredientId = "ingredientId_example"; // String | Id of the ingredient to add
try {
    apiInstance.addIngredientToPantry(username, ingredientId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#addIngredientToPantry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with the pantry |
 **ingredientId** | **String**| Id of the ingredient to add |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="addMealToMealPlan"></a>
# **addMealToMealPlan**
> addMealToMealPlan(username, mealPlanId, mealId)

Adds a meal to the specified mealPlan in the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with collection of mealPlans
String mealPlanId = "mealPlanId_example"; // String | Id of the mealPlan the meal is in
Long mealId = 789L; // Long | Id of the meal to be added to the mealPlan
try {
    apiInstance.addMealToMealPlan(username, mealPlanId, mealId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#addMealToMealPlan");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with collection of mealPlans |
 **mealPlanId** | **String**| Id of the mealPlan the meal is in |
 **mealId** | **Long**| Id of the meal to be added to the mealPlan |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="addRecipe"></a>
# **addRecipe**
> addRecipe(recipeId, body)

Add a new recipe to the database



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Long recipeId = 789L; // Long | Recipe id to delete
Recipe body = new Recipe(); // Recipe | Recipe object that needs to be added to the database
try {
    apiInstance.addRecipe(recipeId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#addRecipe");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **recipeId** | **Long**| Recipe id to delete |
 **body** | [**Recipe**](Recipe.md)| Recipe object that needs to be added to the database | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="addRecipeToCookbook"></a>
# **addRecipeToCookbook**
> addRecipeToCookbook(username, cookbookId, recipeId)

Adds a recipe to the specified cookbook to the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with collection of cookbooks
String cookbookId = "cookbookId_example"; // String | Id of the cookbook to be created
Long recipeId = 789L; // Long | Id of the recipe to be added to the cookbook
try {
    apiInstance.addRecipeToCookbook(username, cookbookId, recipeId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#addRecipeToCookbook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with collection of cookbooks |
 **cookbookId** | **String**| Id of the cookbook to be created |
 **recipeId** | **Long**| Id of the recipe to be added to the cookbook |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="addRecipeToMeal"></a>
# **addRecipeToMeal**
> addRecipeToMeal(username, mealId, recipeId)

Adds a recipe to the specified meal to the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with collection of meals
String mealId = "mealId_example"; // String | Id of the meal the recipe is in
Long recipeId = 789L; // Long | Id of the recipe to be added to the meal
try {
    apiInstance.addRecipeToMeal(username, mealId, recipeId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#addRecipeToMeal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with collection of meals |
 **mealId** | **String**| Id of the meal the recipe is in |
 **recipeId** | **Long**| Id of the recipe to be added to the meal |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="createCookbook"></a>
# **createCookbook**
> createCookbook(username, cookbookId)

Creates a new cookbook to the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with collection of cookbooks
String cookbookId = "cookbookId_example"; // String | Id of the cookbook to be created
try {
    apiInstance.createCookbook(username, cookbookId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createCookbook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with collection of cookbooks |
 **cookbookId** | **String**| Id of the cookbook to be created |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, applictiaon/xml
 - **Accept**: application/json, application/xml

<a name="createMeal"></a>
# **createMeal**
> createMeal(username, mealId)

Creates a new meal to the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with collection of meals
String mealId = "mealId_example"; // String | Id of the meal to be created
try {
    apiInstance.createMeal(username, mealId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createMeal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with collection of meals |
 **mealId** | **String**| Id of the meal to be created |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, applictiaon/xml
 - **Accept**: application/json, application/xml

<a name="createMealPlan"></a>
# **createMealPlan**
> createMealPlan(username, mealPlanId)

Creates a new meal to the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with collection of mealPlans
String mealPlanId = "mealPlanId_example"; // String | Id of the mealPlan to be created
try {
    apiInstance.createMealPlan(username, mealPlanId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createMealPlan");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with collection of mealPlans |
 **mealPlanId** | **String**| Id of the mealPlan to be created |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, applictiaon/xml
 - **Accept**: application/json, application/xml

<a name="createUser"></a>
# **createUser**
> createUser(username, body)

Create user

This can only be done by the logged in user.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | The name of the user to be created
User body = new User(); // User | Created user object
try {
    apiInstance.createUser(username, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The name of the user to be created |
 **body** | [**User**](User.md)| Created user object | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="deleteIngredientFromPantry"></a>
# **deleteIngredientFromPantry**
> deleteIngredientFromPantry(username, ingredientId)

Deletes a meal within the specified mealPlan in the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with the pantry
String ingredientId = "ingredientId_example"; // String | Id of the ingredient to delete
try {
    apiInstance.deleteIngredientFromPantry(username, ingredientId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteIngredientFromPantry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with the pantry |
 **ingredientId** | **String**| Id of the ingredient to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="deleteMealFromMealPlan"></a>
# **deleteMealFromMealPlan**
> deleteMealFromMealPlan(username, mealPlanId, mealId)

Deletes a meal within the specified mealPlan in the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with collection of mealPlans
String mealPlanId = "mealPlanId_example"; // String | Id of the mealPlan the meal is in
Long mealId = 789L; // Long | Id of the meal to be deleted from the mealPlan
try {
    apiInstance.deleteMealFromMealPlan(username, mealPlanId, mealId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteMealFromMealPlan");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with collection of mealPlans |
 **mealPlanId** | **String**| Id of the mealPlan the meal is in |
 **mealId** | **Long**| Id of the meal to be deleted from the mealPlan |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: Not defined

<a name="deleteRecipe"></a>
# **deleteRecipe**
> deleteRecipe(recipeId)

Deletes a recipe



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Long recipeId = 789L; // Long | Recipe id to delete
try {
    apiInstance.deleteRecipe(recipeId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteRecipe");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **recipeId** | **Long**| Recipe id to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="deleteRecipeFromMeal"></a>
# **deleteRecipeFromMeal**
> deleteRecipeFromMeal(username, mealId, recipeId)

Deletes a recipe from the specified cookbook in the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with collection of meals
String mealId = "mealId_example"; // String | Id of the meal the recipe is in
Long recipeId = 789L; // Long | Id of the recipe to be deleted from the meal
try {
    apiInstance.deleteRecipeFromMeal(username, mealId, recipeId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteRecipeFromMeal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with collection of meals |
 **mealId** | **String**| Id of the meal the recipe is in |
 **recipeId** | **Long**| Id of the recipe to be deleted from the meal |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: Not defined

<a name="deleteRecipeInCookbook"></a>
# **deleteRecipeInCookbook**
> deleteRecipeInCookbook(username, cookbookId, recipeId)

Updates a recipe within the specified cookbook in the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with collection of cookbooks
String cookbookId = "cookbookId_example"; // String | Id of the cookbook to be created
Long recipeId = 789L; // Long | Id of the recipe to be added to the cookbook
try {
    apiInstance.deleteRecipeInCookbook(username, cookbookId, recipeId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteRecipeInCookbook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with collection of cookbooks |
 **cookbookId** | **String**| Id of the cookbook to be created |
 **recipeId** | **Long**| Id of the recipe to be added to the cookbook |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: Not defined

<a name="deleteUser"></a>
# **deleteUser**
> deleteUser(username)

Delete user

This can only be done by the logged in user.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | The name that needs to be deleted
try {
    apiInstance.deleteUser(username);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The name that needs to be deleted |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="getCookbookRecipes"></a>
# **getCookbookRecipes**
> List&lt;Recipe&gt; getCookbookRecipes(username, cookbookId)

Fetch all recipes in the specified cookbook



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with collection of cookbooks
String cookbookId = "cookbookId_example"; // String | Id of the cookbook to be created
try {
    List<Recipe> result = apiInstance.getCookbookRecipes(username, cookbookId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getCookbookRecipes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with collection of cookbooks |
 **cookbookId** | **String**| Id of the cookbook to be created |

### Return type

[**List&lt;Recipe&gt;**](Recipe.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="getCookbooksByUserId"></a>
# **getCookbooksByUserId**
> List&lt;Cookbook&gt; getCookbooksByUserId(username)

Finds cookbooks by userId



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username to use to find cookbooks
try {
    List<Cookbook> result = apiInstance.getCookbooksByUserId(username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getCookbooksByUserId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username to use to find cookbooks |

### Return type

[**List&lt;Cookbook&gt;**](Cookbook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="getMealPlanMeals"></a>
# **getMealPlanMeals**
> List&lt;Meal&gt; getMealPlanMeals(username, mealPlanId)

Fetch all meals in the specified mealPlan



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with the mealPlan
String mealPlanId = "mealPlanId_example"; // String | Id of the mealPlan the meals are in
try {
    List<Meal> result = apiInstance.getMealPlanMeals(username, mealPlanId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getMealPlanMeals");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with the mealPlan |
 **mealPlanId** | **String**| Id of the mealPlan the meals are in |

### Return type

[**List&lt;Meal&gt;**](Meal.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="getMealPlansByUserId"></a>
# **getMealPlansByUserId**
> List&lt;MealPlan&gt; getMealPlansByUserId(username)

Finds mealPlans by userId



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username to use to find mealPlans
try {
    List<MealPlan> result = apiInstance.getMealPlansByUserId(username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getMealPlansByUserId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username to use to find mealPlans |

### Return type

[**List&lt;MealPlan&gt;**](MealPlan.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="getMealRecipes"></a>
# **getMealRecipes**
> List&lt;Recipe&gt; getMealRecipes(username, mealId)

Fetch all recipes in the specified meal



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with the meal
String mealId = "mealId_example"; // String | Id of the meal the recipes are in
try {
    List<Recipe> result = apiInstance.getMealRecipes(username, mealId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getMealRecipes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with the meal |
 **mealId** | **String**| Id of the meal the recipes are in |

### Return type

[**List&lt;Recipe&gt;**](Recipe.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="getMealsByUserId"></a>
# **getMealsByUserId**
> List&lt;Meal&gt; getMealsByUserId(username)

Finds meals by userId



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username to use to find meals
try {
    List<Meal> result = apiInstance.getMealsByUserId(username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getMealsByUserId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username to use to find meals |

### Return type

[**List&lt;Meal&gt;**](Meal.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="getUserByName"></a>
# **getUserByName**
> User getUserByName(username)

Get user by user name



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | The name of the user that needs to be fetched.
try {
    User result = apiInstance.getUserByName(username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getUserByName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The name of the user that needs to be fetched. |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="loginUser"></a>
# **loginUser**
> String loginUser(username, password)

Logs user into the system



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | The user name for login
String password = "password_example"; // String | The password for login in clear text
try {
    String result = apiInstance.loginUser(username, password);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#loginUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The user name for login | [optional]
 **password** | **String**| The password for login in clear text | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="logoutUser"></a>
# **logoutUser**
> logoutUser()

Logs out current logged in user session



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    apiInstance.logoutUser();
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#logoutUser");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="updateIngredientInPantry"></a>
# **updateIngredientInPantry**
> updateIngredientInPantry(username, ingredientId)

Updates a meal within the specified mealPlan in the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with the pantry
String ingredientId = "ingredientId_example"; // String | Id of the ingredient to update
try {
    apiInstance.updateIngredientInPantry(username, ingredientId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateIngredientInPantry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with the pantry |
 **ingredientId** | **String**| Id of the ingredient to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="updateMealInMealPlan"></a>
# **updateMealInMealPlan**
> updateMealInMealPlan(username, mealPlanId, mealId)

Updates a meal within the specified mealPlan in the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with collection of meals
String mealPlanId = "mealPlanId_example"; // String | Id of the mealPlan the meal is in
Long mealId = 789L; // Long | Id of the meal to update
try {
    apiInstance.updateMealInMealPlan(username, mealPlanId, mealId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateMealInMealPlan");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with collection of meals |
 **mealPlanId** | **String**| Id of the mealPlan the meal is in |
 **mealId** | **Long**| Id of the meal to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: Not defined

<a name="updateRecipe"></a>
# **updateRecipe**
> updateRecipe(recipeId, body)

Update an existing recipe



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Long recipeId = 789L; // Long | Recipe id to update
Recipe body = new Recipe(); // Recipe | Recipe object that needs to be updated in the database
try {
    apiInstance.updateRecipe(recipeId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateRecipe");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **recipeId** | **Long**| Recipe id to update |
 **body** | [**Recipe**](Recipe.md)| Recipe object that needs to be updated in the database | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="updateRecipeInCookbook"></a>
# **updateRecipeInCookbook**
> updateRecipeInCookbook(username, cookbookId, recipeId)

Updates a recipe within the specified cookbook in the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with collection of cookbooks
String cookbookId = "cookbookId_example"; // String | Id of the cookbook to be created
Long recipeId = 789L; // Long | Id of the recipe to be added to the cookbook
try {
    apiInstance.updateRecipeInCookbook(username, cookbookId, recipeId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateRecipeInCookbook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with collection of cookbooks |
 **cookbookId** | **String**| Id of the cookbook to be created |
 **recipeId** | **Long**| Id of the recipe to be added to the cookbook |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: Not defined

<a name="updateRecipelInMeal"></a>
# **updateRecipelInMeal**
> updateRecipelInMeal(username, mealId, recipeId)

Updates a recipe within the specified meal in the specified user&#39;s collection



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | Username associated with collection of meals
String mealId = "mealId_example"; // String | Id of the meal the recipe is in
Long recipeId = 789L; // Long | Id of the recipe to update
try {
    apiInstance.updateRecipelInMeal(username, mealId, recipeId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateRecipelInMeal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Username associated with collection of meals |
 **mealId** | **String**| Id of the meal the recipe is in |
 **recipeId** | **Long**| Id of the recipe to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: Not defined

<a name="updateUser"></a>
# **updateUser**
> updateUser(username, body)

Updated user

This can only be done by the logged in user.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String username = "username_example"; // String | name that need to be deleted
User body = new User(); // User | Updated user object
try {
    apiInstance.updateUser(username, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| name that need to be deleted |
 **body** | [**User**](User.md)| Updated user object | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

