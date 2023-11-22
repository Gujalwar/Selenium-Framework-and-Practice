package pom.eurotech.test.day01_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
    public static void main(String[] args) {
        // We have to enter this line everytime if we want to open a chrome or firefox or safari browser
        WebDriverManager.chromedriver().setup();


        // WebDriver represent the browser, we are creating browser for chrome

        WebDriver driver = new ChromeDriver(); // polymorphisam
        driver.get("https://www.google.com");

        //driver.close();

        String title = driver.getTitle();
        System.out.println("title = " + title);

        // Validating the title
        if (title.equals("Google")) {
            System.out.println("Passed");
        } else
            System.out.println("Failed");

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        //System.out.println("driver.getPageSource() = " + driver.getPageSource());



    }
}







