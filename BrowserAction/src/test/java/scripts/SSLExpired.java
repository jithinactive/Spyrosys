package scripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class SSLExpired {
	
	public static WebDriver driver;
	
		
	
	

	@AfterTest
	public void quit() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void clickAction() {
		
		//Create instance of ChromeOptions Class
				ChromeOptions handlingSSL = new ChromeOptions();
		//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
				handlingSSL.setAcceptInsecureCerts(true);
		//Creating instance of Chrome driver by passing reference of ChromeOptions object
				driver = new ChromeDriver(handlingSSL);
				driver.get("https://expired.badssl.com/");
				driver.manage().window().maximize();
				System.out.println("The page title is : " +driver.getTitle());
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
				
	}
}
