package pom.eurotech.test.day04_BasicLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.eurotech.test.Utilities.WebDriverFactory;

public class NameLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
         driver.get("https://demoqa.com/text-box");
         driver.manage().window().maximize();
         Faker faker = new Faker();

         driver.findElement(By.name("email")).sendKeys(faker.name().fullName());
         driver.findElement(By.name("password")).sendKeys(faker.internet().password());
         driver.findElement(By.id("loginpage-form-btn")).click();
         Thread.sleep(2000);
         driver.close();
    }
}
