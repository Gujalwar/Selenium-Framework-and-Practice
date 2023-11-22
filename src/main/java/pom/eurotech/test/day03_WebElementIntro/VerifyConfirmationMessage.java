package pom.eurotech.test.day03_WebElementIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.eurotech.test.Utilities.WebDriverFactory;

public class VerifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
        /*
--open Chrome browser and navigate "http://eurotech.study/login"
--Enter email "eurotech@gmail.com"
--Enter password "Test12345!"
--Click login btn
--verify confirmation message "Welcome Eurotech"
       */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));

        understandBtn.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("eurotech@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("Test12345!");

        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();
        Thread.sleep(2000);
        String expectedMessage = "Welcome Teacher";
        WebElement welcomeMessage = driver.findElement(By.id("dashboard-p1"));
        //System.out.println("welcomeMessage = " + welcomeMessage);
        // we have two ways to get text message from UI (web pages)
        // 1- getText()--> works 99% and it will return string
        //2-getAttributes()
       String actualMessage = welcomeMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        if(expectedMessage.equals(actualMessage)){
            System.out.println("Passed");
        }else
            System.out.println("Failed");

        Thread.sleep(2000);
        driver.close();


    }
}
