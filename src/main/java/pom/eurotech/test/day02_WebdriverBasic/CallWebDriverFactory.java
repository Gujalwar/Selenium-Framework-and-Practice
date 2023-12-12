package pom.eurotech.test.day02_WebdriverBasic;

import org.openqa.selenium.WebDriver;
import pom.eurotech.utilities.WebDriverFactory;

public class CallWebDriverFactory {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("FireFox");
        driver.get("http://eurotech.study/login");
        String exceptedTitle = "DevEx";
        String actualTitle = driver.getTitle();

        if(exceptedTitle.equals(actualTitle)){
            System.out.println("Passed");

        }else
            System.out.println("Failed");

    }
}
