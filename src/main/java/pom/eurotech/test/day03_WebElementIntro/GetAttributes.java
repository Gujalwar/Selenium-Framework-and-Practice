package pom.eurotech.test.day03_WebElementIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.eurotech.utilities.WebDriverFactory;

public class GetAttributes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));

        understandBtn.click();
        WebElement emailInput = driver.findElement(By.id("loginpage-input-email"));
        emailInput.sendKeys("eurotech@gmail.com");
        //System.out.println("emailInput.getText() = " + emailInput.getText());
        System.out.println("emailInput.getAttribute(\"value\") = " + emailInput.getAttribute("value"));
        System.out.println("emailInput.getAttribute(\"placeholder\") = " + emailInput.getAttribute("placeholder"));
        System.out.println("emailInput.getAttribute(\"id\") = " + emailInput.getAttribute("id"));
        System.out.println("emailInput.getAttribute(\"name\") = " + emailInput.getAttribute("name"));
        System.out.println("emailInput.getAttribute(\"type\") = " + emailInput.getAttribute("type"));
        System.out.println("emailInput.getAttribute(\"class\") = " + emailInput.getAttribute("class"));

        driver.findElement(By.name("password")).sendKeys("Test12345!");
        driver.findElement(By.id("loginpage-form-btn")).click();
        Thread.sleep(2000);
        String actualMessage = driver.findElement(By.id("dashboard-p1")).getText();
        System.out.println("actualMessage = " + actualMessage);
        driver.close();


    }
}
