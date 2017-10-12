import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.saucelabs.junit.ConcurrentParameterized;

@RunWith(ConcurrentParameterized.class)
public class sampletestcasesaucelabs {
	public static final String USERNAME = System.getenv("awafa");
	public static final String ACCESS_KEY = System.getenv("6406b977-db05-4a39-b940-5d47ead6ecf7"); 
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	@ConcurrentParameterized.Parameters
	public static LinkedList<String[]> browsersStrings()
	{ LinkedList<String[]> browsers = new LinkedList<String[]>(); 
	// windows 7, IE 9 
	browsers.add(new String[]{"Windows 7", "9", "internet explorer"});
	// windows 8, IE 10
	browsers.add(new String[]{"Windows 8", "10", "internet explorer"}); 
	// windows 8.1, IE 11 
	browsers.add(new String[]{"Windows 8.1", "11", "internet explorer"}); 
	return browsers; }
	

	
	
	
	
	
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
