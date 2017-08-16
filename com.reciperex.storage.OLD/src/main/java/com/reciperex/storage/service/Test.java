package com.reciperex.storage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.reciperex.model.User;
import com.reciperex.service.IdService;
import com.reciperex.storage.service.DatabaseManagerOLD;

public class Test {

	
	
	public static void main(String[] args) {
		
		DatabaseManager dbManager = new DatabaseManager();
		
//		Map<String, String> constraints = new HashMap<String, String>();
//		constraints.put("user.pantryId", "2");
//		List<Object> users = dbManager.retrieveEntities(constraints, User.class);
//		for (Object o : users) {
//			User user = (User) users.get(users.indexOf(o));
//			System.out.println(user.getFirstName() + " " + user.getLastName());
//		}
//	}
		
		
		User user = new User();
		int result = 0;
		
		user.setFirstName("Sandra");
		user.setLastName("Chappell");
		user.setAge(32);
		user.setUsername("schappell");
		user.setPassword("password");
		user.setEmail("schappell@somewhere.com");
		user.setBio("Sandra's bio");
		user.setGender('F');
		user.setCity("Arlington");
		user.setState("TX");
		user.setCountry("USA");

		result = dbManager.insertNewUser(user);
		if (result != 0) {
			Map<String, String> constraints = new HashMap<String, String>();
			constraints.put("username", user.getUsername());
			user = (User) dbManager.retrieveSingleEntity(constraints, User.class);
			dbManager.insertNewPantry(user.getUserId());
		}
	}

}
