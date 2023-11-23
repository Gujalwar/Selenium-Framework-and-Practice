package pom.eurotech.test.day04_BasicLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.eurotech.test.Utilities.WebDriverFactory;

public class PartialLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        WebElement example2 = driver.findElement(By.partialLinkText("Example 2"));
        example2.click();

        String expectedTitle = "Example 2: Element rendered after the fact";

        String actualTitle = driver.findElement(By.tagName("h4")).getText();


        if(expectedTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else
            System.out.println("Failed");


        Thread.sleep(2000);
    }
}
