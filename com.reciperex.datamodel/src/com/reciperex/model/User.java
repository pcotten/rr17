package com.reciperex.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String bio;
	private Image profilePic;
	private String firstName;
	private String lastName;
	private Integer age;
	private Character gender;
	private String city;
	private String state;
	private String country;
	private String pantryCode;
	
	private List<Recipe> recipes;
	private List<MealPlan> mealPlans;
	private List<Meal> meals;
	private List<Cookbook> cookbooks;
	private List<Integer> friends; 
	
	public User(){
		
	}
	
	public User(Integer id, String username, String password, String email, String bio, 
			Image profilePic, String firstName, String lastName, Integer age, 
			Character gender, String city, String state, String country, String pantryCode) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.bio = bio;
		this.profilePic = profilePic;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pantryCode = pantryCode;
		this.recipes = new ArrayList<Recipe>();
		this.meals = new ArrayList<Meal>();
		this.mealPlans = new ArrayList<MealPlan>();
		this.cookbooks = new ArrayList<Cookbook>();
		this.friends = new ArrayList<Integer>();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPantryCode() {
		return pantryCode;
	}
	
	public void setPantryCode(String pantryCode) {
		this.pantryCode = pantryCode;
	}

	public List<Meal> getMeals() {
		return meals;
	}
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public List<Cookbook> getCookbooks() {
		return cookbooks;
	}
	public void setCookbooks(List<Cookbook> cookbooks) {
		this.cookbooks = cookbooks;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Image getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(Image profilePic) {
		this.profilePic = profilePic;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Integer getUserId() {
		return id;
	}

	public void setUserId(Integer userId) {
		this.id = userId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public List<MealPlan> getMealPlans() {
		return mealPlans;
	}

	public void setMealPlans(List<MealPlan> mealPlans) {
		this.mealPlans = mealPlans;
	}

	public List<Integer> getFriends() {
		return friends;
	}

	public void setFriends(List<Integer> friends) {
		this.friends = friends;
	}

	
	
}
