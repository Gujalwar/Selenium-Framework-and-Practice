package pom.eurotech.test.day04_BasicLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.eurotech.utilities.WebDriverFactory;

public class DemoGoogle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.google.com");
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        String expectedTitle = "Google";
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Passed");
        } else
            System.out.println("Failed");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"input\"]")).sendKeys("Computer");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();


    }
}

