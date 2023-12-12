package pom.eurotech.test.day14_PropertiesFile_Singleton;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pom.eurotech.utilities.ConfigurationReader;
import pom.eurotech.utilities.Driver;

public class SingletonTest {

    // Singleton singleton = new Singleton();
    // We can not create a new Singleton Class Object

    @Test
    @Ignore
    public void test1() {
        String s1= Singleton.getInstance();
        System.out.println("s1 = " + s1);
        String s2= Singleton.getInstance();
        System.out.println("s2 = " + s2);
    }

    @Test @Ignore
    public void test2() {
        //WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.co.uk");
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void test3() {
        //WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.co.uk");
    }

    @Test
    public void test4() {
        //WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
    }
}
