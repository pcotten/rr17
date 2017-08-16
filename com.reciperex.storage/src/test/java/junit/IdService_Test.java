package junit;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reciperex.model.User;
import com.reciperex.service.IdService;
import com.reciperex.storage.service.DatabaseManagerOLD;


public class IdService_Test {

	static DatabaseManagerOLD dbManager;
	static User user;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dbManager = new DatabaseManagerOLD();
		user = new User("John", "Doe", "jdoe@someplace.net", "mrjj123", "myPassword!");
	}
	
	
	@Test
	public void test() {
		Integer highId = dbManager.queryMaxIdNumber("user");
		Integer nextId = IdService.generateId("user");
		Assert.assertTrue("Generated Id was not the next consecutive after the highest", highId + 1 == nextId);
	}

}
