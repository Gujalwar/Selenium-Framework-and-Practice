package pom.eurotech.test.day03_WebElementIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.eurotech.utilities.WebDriverFactory;

public class VerifyUrlChanged {
    public static void main(String[] args) throws InterruptedException {
        /* open Chrome browser
        enter email eurotech@gmail.com
        enter password Test12345!
        click login button
        verify that url changed
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));

        understandBtn.click();
        String expectedUrl = "http://eurotech.study/dashboard";
        WebElement emailInput = driver.findElement(By.id("loginpage-input-email"));
        emailInput.sendKeys("eurotech@gmail.com");
        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));
        passwordInput.sendKeys("Test12345!");

        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();
        Thread.sleep(2000);
       String actualUrl = driver.getCurrentUrl();
        System.out.println("expectedUrl = " + expectedUrl);
        System.out.println("actualUrl = " + actualUrl);

        if(expectedUrl.equals(actualUrl)){
           System.out.println("Passed");
       } else
           System.out.println("Failed");
    }
}
