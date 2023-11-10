package com.jtn.srcshot;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;


public class ScreenshotProgram {
  
	WebDriver driver;
   
   @Before
   public void setup() {
	   
	   driver = new FirefoxDriver();
	    driver.get("https://www.facebook.com/signup");
	    
   }
   
   @Test
   public void takeFullShot() throws IOException {
	   
	   File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileHandler.copy(src, new File("C:\\Users\\admin2\\Desktop\\Jithin\\Screenshot\\Fullshot.png"));
	   
   }
   
   @Test
   
  public void takeCustomShot() throws IOException {
	   
	  WebElement pswd = driver.findElement(By.id("password_step_input"));
	  File src2 = pswd.getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(src2, new File("C:\\Users\\admin2\\Desktop\\Jithin\\Screenshot\\Customshot.png"));
   }
   
   @After
   public void browser() {
	   
	  driver.quit();
   }
}
