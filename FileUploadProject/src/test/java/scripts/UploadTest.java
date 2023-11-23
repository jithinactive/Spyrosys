package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadTest {

    public static WebDriver driver;

    @BeforeTest
    public void onSetup(){
        driver = new ChromeDriver();
        driver.get("https://www.ilovepdf.com/pdf_to_word");
        driver.manage().window().maximize();

    }

    @Test
    public void fileLocate() throws AWTException {

        driver.findElement(By.cssSelector("#pickfiles"));
        fileUpload("C:\\Users\\admin2\\Desktop\\Jithin\\jiobill.pdf");

    }
    public void fileUpload(String p) throws AWTException {

        //to copy path to clipboard
        StringSelection strSelection = new StringSelection(p);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection,null);
        // to paste into system window
        Robot robot = new Robot();
        robot.delay(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);

        driver.findElement(By.cssSelector("#processTask")).click();
        String text = driver.findElement(By.cssSelector("h1.title2")).getText();
        if(text.equals("Your PDF has been converted to an editable WORD document")){
            System.out.println("File uploaded and converted");
        }
        else {
            System.out.println("Task Failed");
        }

    }



    @AfterTest
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
