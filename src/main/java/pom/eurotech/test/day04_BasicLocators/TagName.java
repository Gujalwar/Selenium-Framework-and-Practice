package pom.eurotech.test.day04_BasicLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.eurotech.utilities.WebDriverFactory;

public class TagName {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        driver.findElement(By.id("loginpage-input-email")).sendKeys("eurotech@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Test12345!");
        driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(1000);
        WebElement welcomeMessage = driver.findElement(By.tagName("p"));
        System.out.println("welcomeMessage.getText() = " + welcomeMessage.getText());

        WebElement tagName = driver.findElement(By.tagName("h2"));
        System.out.println("tagName.getText() = " + tagName.getText());


        Thread.sleep(2000);
        driver.close();

    }
}

