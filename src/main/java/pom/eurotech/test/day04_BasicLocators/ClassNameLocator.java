package pom.eurotech.test.day04_BasicLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.eurotech.utilities.WebDriverFactory;

public class ClassNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        driver.findElement(By.name("email")).sendKeys("eurotech@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Test12345!");
        //  driver.findElement(By.id("loginpage-form-btn")).click();
        driver.findElement(By.className("btn btn-primary")).click();

        Thread.sleep(1000);
        WebElement title = driver.findElement(By.className("my-2"));
        System.out.println("title.getText() = " + title.getText());


        Thread.sleep(2000);
        driver.close();




    }
}
