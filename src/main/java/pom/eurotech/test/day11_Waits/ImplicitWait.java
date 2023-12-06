package pom.eurotech.test.day11_Waits;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.eurotech.test.Utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void implicitWait() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement message = driver.findElement(By.id("message"));
        System.out.println("message.getText() = " + message.getText());

    }
    @Test
    public void implicit2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();

        WebElement message = driver.findElement(By.id("message"));
        System.out.println("message.getText() = " + message.getText());
    }

    @Test
    public void testName() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start>button")).click();
        WebElement hello = driver.findElement(By.cssSelector("#finish>h4"));
        System.out.println("hello.getText() = " + hello.getText());
    }

    @Test
    public void test2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        inputBox.sendKeys("Hello");


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

