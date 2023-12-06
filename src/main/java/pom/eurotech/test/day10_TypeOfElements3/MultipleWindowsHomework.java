package pom.eurotech.test.day10_TypeOfElements3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.eurotech.test.Utilities.WebDriverFactory;

import java.util.Set;

public class MultipleWindowsHomework {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void homework() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String parentHandle = driver.getWindowHandle();
        System.out.println("parentHandle = " + parentHandle);
        WebElement openTab = driver.findElement(By.xpath("//a[@id = 'opentab']"));
        openTab.click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            System.out.println(handle);
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                driver.findElement(By.linkText("Access all our Courses")).click();
                Thread.sleep(3000);
                String expectedTitle = "QA Click Academy";
                String actualTitle = driver.findElement(By.tagName("h1")).getText();
                System.out.println("actualTitle = " + actualTitle);
                Assert.assertEquals(actualTitle,expectedTitle);


            }

        }
    }


        @AfterMethod
        public void tearDown() throws InterruptedException {
            Thread.sleep(2000);
            driver.quit();
        }


    }
