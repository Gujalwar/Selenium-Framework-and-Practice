package pom.eurotech.test.day09_TypesOfElements2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.eurotech.utilities.WebDriverFactory;

import java.util.List;

public class ListOfElements {


    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @Test
    public void test1() throws InterruptedException {


        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> menuList = driver.findElements(By.xpath("//a[text()='Checkboxes']/../../li/a"));

        System.out.println("menuList.size() = " + menuList.size());
        int expectedSize =44;
        int actualSize = menuList.size();
        Assert.assertEquals(actualSize,expectedSize);

        //print checkboxes title
        System.out.println("menuList.get(5).getText() = " + menuList.get(5).getText());
        for (WebElement element : menuList) {
            System.out.println("element.getText() = " + element.getText());
        }

        for (WebElement element : menuList) {
            System.out.println("element.isDisplayed() = " + element.isDisplayed());
            Assert.assertTrue(element.isDisplayed());
        }
        //Click Checkboxes
        String itemToClick = "Dropdown";
        for (WebElement element : menuList) {
            if(itemToClick.equals(element.getText())){
                System.out.println("Item to click "+ itemToClick+" is found , will click");
                element.click();
                Thread.sleep(1000);
                break;
            }

        }


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
}

