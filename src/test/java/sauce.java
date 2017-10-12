
import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.LinkedList;
import java.io.File;
import java.net.URL;

import org.openqa.selenium.support.ui.Select;
import com.saucelabs.junit.ConcurrentParameterized;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.openqa.selenium.OutputType.*;

@RunWith(ConcurrentParameterized.class)
public class sauce {
   
	public static final String USERNAME = "awafa"; 
	public static final String ACCESS_KEY = "6406b977-db05-4a39-b940-5d47ead6ecf7"; 
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	protected String browser; 
	protected String os;  
	protected String version; 
	protected String sessionId;
	protected WebDriver driver; 
   
	public sauce(String os, String version, String browser) 
	{ 
		super();
	this.os = os;
	this.version = version;
	this.browser = browser;
	}
	
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
	

    @Before
    public void setUp() throws Exception {

    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability(CapabilityType.BROWSER_NAME, browser); 
    	capabilities.setCapability(CapabilityType.VERSION, version); 
    	capabilities.setCapability(CapabilityType.PLATFORM, os); 
    	driver = new RemoteWebDriver(new URL(URL), capabilities); 
    	this.sessionId = (((RemoteWebDriver) driver).getSessionId()).toString(); 
    	String message = String.format("SauceOnDemandSessionID=%1$s", this.sessionId); 
    	System.out.println(message); }
   
    @Test
    public void sauce() {
        driver.get("https://dev.swipezoom.com/");
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
