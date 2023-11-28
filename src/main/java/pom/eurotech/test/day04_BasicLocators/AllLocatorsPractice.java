package pom.eurotech.test.day04_BasicLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pom.eurotech.test.Utilities.WebDriverFactory;

public class AllLocatorsPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title = " + actualTitle);
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else
            System.out.println("Failed");
        driver.findElement(By.linkText("products")).click();







    }
}
