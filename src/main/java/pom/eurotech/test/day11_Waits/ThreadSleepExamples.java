package pom.eurotech.test.day11_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.eurotech.test.Utilities.WebDriverFactory;

public class ThreadSleepExamples {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void threadSleep() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#start>button")).click();
        Thread.sleep(6000);

        System.out.println("Text = " + driver.findElement(By.cssSelector("#finish>h4")).getText());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}