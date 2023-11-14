package datadriven;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestFile {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		
	}
	
	@BeforeMethod
	public void url() {
		driver.get("https://www.facebook.com/login");
	}
	
@Test
 public void main() throws IOException, InterruptedException {
		File f= new File("C:\\Users\\admin2\\Desktop\\Jithin\\newexcel.xlsx");	
		FileInputStream fi = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum());
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			String un= sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("username= "+un);
			String pwd = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("password= "+pwd);
			
			driver.findElement(By.cssSelector("#email")).clear();
			driver.findElement(By.cssSelector("#email")).sendKeys(un);
			driver.findElement(By.cssSelector("#pass")).clear();
			driver.findElement(By.cssSelector("#pass")).sendKeys(pwd);
			driver.findElement(By.cssSelector("#loginbutton")).click();
			
			String actual = driver.getCurrentUrl();
			System.out.println(actual);
			String expurl = "https://www.facebook.com/";
			if(expurl.equals(actual)) {
				
				System.out.println("Login Successful");
			}
			else 
			{
				System.out.println("Login Failed");
			}
			}
		Thread.sleep(3000);
		driver.quit();
}


	
 

}
