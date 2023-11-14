package crossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Browsertest {

	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) {
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
	}
	@Test
	public void url() {
		driver.get("https://www.google.com");
	}
	
	
}
