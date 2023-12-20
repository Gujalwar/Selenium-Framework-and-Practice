package pom.eurotech.test.day05_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.eurotech.utilities.WebDriverFactory;

public class Homework {
    public static void main(String[] args) throws InterruptedException {


        /* --open chrome browser --navigate ebay.com --search selenium --verify that result area has selenium text */

        /* Test Case 2 go to ebay.com search selenium click on search button print number of results */ //USE XPATH LOCATOR ONLY


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://ebay.com");
        Thread.sleep(2000);
        WebElement acceptAll = driver.findElement(By.xpath("//button[@id='gdpr-banner-accept']"));
        acceptAll.click();
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Selenium");
        WebElement searchBtn = driver.findElement(By.xpath("//input[@id ='gh-btn']"));
        searchBtn.click();
        Thread.sleep(2000);
        String expectedUrl = "https://www.ebay.com/sch/i.html?_from=R40&_trksid=p4432023.m570.l1313&_nkw=Selenium&_sacat=0";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)){
            System.out.println("Passed");
        }else
            System.out.println("Failed");

        Thread.sleep(2000);
       String verifyResult = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[1]/div[1]/div[1]/h1")).getText();
        System.out.println(verifyResult);
          Thread.sleep(2000);
          if(verifyResult.contains("Selenium")){
              System.out.println("Passed");
          }else
              System.out.println("Failed");
          Thread.sleep(2000);
          WebElement result = driver.findElement(By.xpath("//h1/span[1]"));
        System.out.println("Total Results = " + result.getText());
        Thread.sleep(2000);
        driver.close();


    }
}


