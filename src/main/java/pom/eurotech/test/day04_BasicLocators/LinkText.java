package pom.eurotech.test.day04_BasicLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.eurotech.utilities.WebDriverFactory;

public class LinkText {
    public static void main(String[] args) throws InterruptedException {
        /*
        navigate https://the-internet.herokuapp.com/dynamic_loading
        Click on example 1
        verify that Dynamically Loaded Page Elements is there
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebElement example1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
        example1.click();
        String expectedTitle = "Dynamically Loaded Page Elements";

        WebElement title = driver.findElement(By.tagName("h3"));
        String actualTitle= title.getText();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }


        Thread.sleep(2000);
        driver.close();

    }
}
