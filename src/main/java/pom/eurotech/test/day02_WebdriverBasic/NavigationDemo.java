package pom.eurotech.test.day02_WebdriverBasic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        // waiting method

        Thread.sleep(2000);

        // navigate to different website
        driver.navigate().to("http://www.facebook.com");

        Thread.sleep(2000);

        // goes back to previous page
        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        // to refresh the page

        driver.navigate().refresh();
        driver.close();



    }
}
