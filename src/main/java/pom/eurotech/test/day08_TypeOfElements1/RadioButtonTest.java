package pom.eurotech.test.day08_TypeOfElements1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.eurotech.test.Utilities.WebDriverFactory;

public class RadioButtonTest {
    @Test
    public void test1() throws InterruptedException {

        /*-- Verify that radio button 2 is unselected
         -- Click radio button 2
         -- Verify that radio button 2 is selected
        */


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement radioButton2 = driver.findElement(By.cssSelector("input[value = radio2]"));

        // verify that radio 2 is unselected

        Assert.assertFalse(radioButton2.isSelected(),"Be Careful Radio2 Is Selected");
        radioButton2.click();
        Assert.assertTrue(radioButton2.isSelected(),"Radio 2 is Unselected");
        Thread.sleep(2000);
        driver.close();

    }
}
