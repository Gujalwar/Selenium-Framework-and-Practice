package pom.eurotech.test.day19_Review;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pom.eurotech.test.TestBase;
import pom.eurotech.utilities.BrowserUtils;

public class StaleElements extends TestBase {


    @Test
    public void staleElement() {
        driver.get("https://freecrm.com/");
        WebElement loginBtn = driver.findElement(By.xpath("//span[text()='Log In']"));
        loginBtn.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("eurotech@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("Test123");

        driver.navigate().refresh();
        BrowserUtils.waitForVisibility(emailInput,9);
        emailInput.sendKeys("eurotech@gmail.com");
    }

    @Test
    public void staleFix() {
        driver.get("https://freecrm.com/");
        WebElement loginBtn = driver.findElement(By.xpath("//span[text()='Log In']"));
        loginBtn.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("eurotech@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("Test123");

        driver.navigate().refresh();
        BrowserUtils.waitFor(3);

        try{
            emailInput.sendKeys("eurotech@gmail.com");
        }catch (StaleElementReferenceException e){
            emailInput=driver.findElement(By.name("email"));
            emailInput.sendKeys("eurotech@gmail.com");
        }

    }
}
