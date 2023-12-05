package pom.eurotech.test.day08_TypeOfElements1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.eurotech.test.Utilities.WebDriverFactory;

public class Homework {

     /*
    Test Case 1
    --Navigate https://demo.aspnetawesome.com/
    -- verify that vegetable is selected
    -- verify that legume is NOT selected
    -- click legume
    -- verify that vegetable is NOT selected
    -- verify that legume is selected
     */

    /*
    Test Case :2
    --Navigate https://demo.aspnetawesome.com/
    -- verify that Broccoli and Artichoke are SELECTED
    -- click Cauliflower
    -- click Broccoli
    -- click Artichoke
    -- verify that Broccoli and Artichoke are NOT SELECTED
    -- verify that Cauliflower is Selected
     */


    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");

        WebElement vegetable = driver.findElement(By.xpath("//div[text()='Vegetables']/../input"));
        Assert.assertTrue(vegetable.isSelected(), "IS NOT SELECTED");

        WebElement legumeRadio = driver.findElement(By.xpath("//div[text()='Legumes']/../div[1]"));
        legumeRadio.click();
        //  Assert.assertFalse(legume.isSelected(),"IS SELECTED"); //false

        Thread.sleep(3000);
        System.out.println(legumeRadio.isSelected());
        WebElement legume = driver.findElement(By.xpath("//div[text()='Legumes']/../input"));
        System.out.println(legume.isSelected());
        Assert.assertFalse(vegetable.isSelected());
        driver.close();


    }


    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        WebElement broccoli = driver.findElement(By.xpath("//div[text() = 'Broccoli' ]/../input"));
        Assert.assertTrue(broccoli.isSelected(),"Broccoli is not selected");
        WebElement artichoke = driver.findElement(By.xpath("//div[text() = 'Artichoke' ]/../input"));
        Assert.assertTrue(artichoke.isSelected(),"Artichoke is not selected");
        Thread.sleep(2000);
        WebElement cauliflower = driver.findElement(By.xpath("//div[text() = 'Cauliflower' ]/../input"));

        cauliflower.click();
        broccoli.click();
        artichoke.click();

        Assert.assertFalse(broccoli.isSelected(),"Broccoli is selected");
        Assert.assertFalse(artichoke.isSelected(),"Artichoke is selected" );
        Assert.assertTrue(cauliflower.isSelected(), "Cauliflower is not selected");

        Thread.sleep(3000);
        driver.close();
    }
}

