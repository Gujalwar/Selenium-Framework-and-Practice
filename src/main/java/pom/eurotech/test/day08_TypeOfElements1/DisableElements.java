package pom.eurotech.test.day08_TypeOfElements1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.eurotech.test.Utilities.WebDriverFactory;

public class DisableElements {
    @Test
    public void testName() throws InterruptedException {
        /*
        --Navigate https://the-internet.herokuapp.com/dynamic_controls
        --verify that input box is Disable
        --Click enable button
        --Verify that input box is enable
        use isEnable() method

         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        //verify that input box is disabled
        System.out.println("inputBox.isEnabled() = " + inputBox.isEnabled());
        //expected result is false
        Assert.assertFalse(inputBox.isEnabled());
        //   inputBox.sendKeys("Eurotech");

        WebElement enableBtn = driver.findElement(By.cssSelector("#input-example>button"));
        enableBtn.click();
        Thread.sleep(5000);

        inputBox.sendKeys("Eurotech");
        //verify that input box is enable
        Assert.assertTrue(inputBox.isEnabled());





        Thread.sleep(1000);
        driver.close();


    }
}

