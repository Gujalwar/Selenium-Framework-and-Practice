package pom.eurotech.test.day08_TypeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.eurotech.test.Utilities.WebDriverFactory;

public class CheckBoxDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement option1 = driver.findElement(By.cssSelector("#checkBoxOption1"));
        System.out.println(option1.isSelected()); // false
        Assert.assertFalse(option1.isSelected(), "Option 1 is SELECTED");

        option1.click();
        Thread.sleep(2000);

        System.out.println(option1.isSelected()); //true
        Assert.assertTrue(option1.isSelected(), "Option 1 is UNSELECTED");


        driver.close();
    }
}