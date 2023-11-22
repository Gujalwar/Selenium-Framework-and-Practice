package pom.eurotech.test.day02_WebdriverBasic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetURL {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
        String title = driver.getTitle();
        System.out.println("Title = " + title);
        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle))
        {
            System.out.println("Passed");
        } else
            System.out.println("Failed");


        String expectedUrl = driver.getCurrentUrl();
        System.out.println("URL = " + expectedUrl);
        String actualUrl = "https://www.facebook.com/";
        if(expectedUrl.equals(actualUrl))
        {
            System.out.println("Passed");
        } else
            System.out.println("Failed");

        System.out.println("driver.getPageSource() = " + driver.getPageSource());


        driver.close();
    }
}
