package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dragdrop {

    public static WebDriver driver;

    @BeforeTest
    public void onSetup(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();

    }
    @Test
    public void droptest(){

       WebElement drag = driver.findElement(By.id("draggable"));
       WebElement drop = driver.findElement(By.id("droppable"));
       Actions act = new Actions(driver);
       act.dragAndDrop(drag,drop).perform();
       String text = drop.getText();
       if(text.equals("Dropped")){
           System.out.println("Dropped");
       }
       else{
           System.out.println("Not expected");
       }
    }
    @AfterTest
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
