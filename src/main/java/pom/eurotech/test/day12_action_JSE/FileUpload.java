package pom.eurotech.test.day12_action_JSE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.eurotech.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;


public class FileUpload {

        WebDriver driver;

        @BeforeMethod
        public void setUp() {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        @Test
        public void fileUpload() {
            driver.get("https://the-internet.herokuapp.com/upload");
            WebElement chooseFile = driver.findElement(By.id("file-upload"));

            chooseFile.sendKeys("/Users/erhanilgar/Documents/Eurotech.rtf");

            driver.findElement(By.id("file-submit")).click();

        /*
        Windows user
        chooseFile.sendKeys("\"C:\\Users\\Gylyc\\OneDrive\\Desktop\\Upload.txt\"");
        if doesn't work
        try this
        chooseFile.sendKeys("C:/Users/Gylyc/OneDrive/Desktop/Upload.txt");
         */

        }

        @Test
        public void upload2() {

            System.out.println(System.getProperty("user.dir"));
            //  /Users/erhanilgar/IdeaProjects/seleniumProject/src/main/ETS_B12_TestNGSelenium

            String projectPath = System.getProperty("user.dir");
            String filePath="src/test/resources/Eurotech.txt";

            String fullPath=projectPath+"/"+filePath;

            System.out.println("fullPath = " + fullPath);

            driver.get("https://the-internet.herokuapp.com/upload");
            WebElement chooseFile = driver.findElement(By.id("file-upload"));
            chooseFile.sendKeys(fullPath);

            driver.findElement(By.id("file-submit")).click();
        }

        @AfterMethod
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
    }

