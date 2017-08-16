package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.reciperex.storage.service.DatabaseManagerOLD;

@RunWith(Suite.class)
@SuiteClasses({DatabaseManager_Test.class, IdService_Test.class})
public class AllTests {
	
}
