package pom.eurotech.test.day03_WebElementIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.eurotech.utilities.WebDriverFactory;

public class EaappPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eaapp.somee.com/");
        driver.navigate().to("http://eaapp.somee.com/Account/Login");
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Login - Execute Automation Employee App";
        System.out.println(actualTitle);
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Passed");

        }else
            System.out.println("Failed");

        driver.findElement(By.id("UserName")).sendKeys("admin");
        driver.findElement(By.id("Password")).sendKeys("password");
        driver.findElement(By.className("//*[@id=loginForm]")).click();
        Thread.sleep(2000);
        String actulUrl = driver.getCurrentUrl();
        String expectedUrl = "http://eaapp.somee.com/";
        if(expectedUrl.equals(actulUrl)){
            System.out.println("Passed");

        }else
            System.out.println("Failed");


    }
}
