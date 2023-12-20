package pom.eurotech.test.day14_PropertiesFile_Singleton;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pom.eurotech.utilities.WebDriverFactory;

public class SingletonReview {

    @Test
    public  void singletonReview(){
        WebDriver driver1 = WebDriverFactory.getDriver("chrome");
        WebDriver driver2 = WebDriverFactory.getDriver("chrome");
        driver1.get("http://www.google.com");

    }



    }




