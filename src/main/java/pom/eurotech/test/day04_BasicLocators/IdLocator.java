package pom.eurotech.test.day04_BasicLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.eurotech.test.Utilities.WebDriverFactory;

public class IdLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        Faker faker = new Faker();
        driver.findElement(By.id("userName")).sendKeys(faker.name().fullName());
        driver.findElement(By.id("userEmail")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("currentAddress")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("permanentAddress")).sendKeys(faker.address().fullAddress());

         Thread.sleep(3000);
         driver.close();
    }
}
